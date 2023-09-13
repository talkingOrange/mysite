package com.poscodx.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.dao.PagingDao;
import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.PagingVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// pagingVo에서 paging을 위한 계산이 들어간다. 
		// param을 통해 받아온 page 번호를 통해 sql의 limit를 조절한다.
		PagingVo paging = new PagingVo();
		String param = request.getParameter("page");
		System.out.println(param);
		int page = 1; //게시판 클릭 시에는 page param이 없어서 null임.
		if(param != null) {
			page = Integer.parseInt(param);
		}
		paging.setPage(page);
		paging.setTotalCount(new PagingDao().findTotalCount().getTotalCount());

		// 번호, 제목, 내용, 조회수, 작성일, gNo, oNo, Depth, userNo 가져오기
		List<BoardVo> list = new BoardDao().findAll(paging.getPage(), paging.getLimit());
		System.out.println("limit의 page"+paging.getPage());
		System.out.println("limit의 limit"+paging.getLimit());
		
		
		// userNo를 이용하여 userName 담기
		for (BoardVo board : list) {
			Long userNo = board.getUserNo();
			UserVo user = new UserDao().findByNo(userNo);
			if (user != null) {
				board.setUserName(user.getName());
			}
		}
		
		// list로 attribute
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		WebUtil.forward("board/list", request, response);

	}

}
