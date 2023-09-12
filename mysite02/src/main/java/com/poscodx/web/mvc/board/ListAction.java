package com.poscodx.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 번호, 제목, 내용, 조회수, 작성일, gNo, oNo, Depth, userNo 가져오기
		List<BoardVo> list = new BoardDao().findAll();

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
		WebUtil.forward("board/list", request, response);

	}

}
