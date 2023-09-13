package com.poscodx.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;

public class writeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// String param = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 세션을 통해 "no" 파라미터 값을 얻어옴
		HttpSession session = request.getSession();
		String param = (String) session.getAttribute("param");

		System.out.println("param2" + param);

		BoardVo boardVo = new BoardVo();
		boardVo.setTitle(title);
		boardVo.setContents(content);
		
		// session을 통해 userNo를 얻어옴.
		session = request.getSession(true);
		UserVo user = (UserVo) session.getAttribute("authUser");

		// user의 정보가 null인 경우, login 화면으로 이동
		if (user != null) {
			Long userNo = user.getNo();
			boardVo.setUserNo(userNo);
			if (param != null) {
				Long no = Long.parseLong(param);
				boardVo.setNo(no);
				BoardVo parentWrite = new BoardDao().findByNo(no);
				Long gNo = parentWrite.getgNo();
				Long oNo = parentWrite.getoNo();
				Long depth = parentWrite.getDepth();
				
				boardVo.setgNo(gNo);
				boardVo.setoNo(oNo);
				boardVo.setDepth(depth);
				
				System.out.println(parentWrite);
				
			} else {
				System.out.println("param information not found in session.");
			}
			new BoardDao().insert(boardVo);
			System.out.println(boardVo);
			response.sendRedirect(request.getContextPath() + "/board");
		} else {
			System.out.println("User's information not found in session.");
			response.sendRedirect(request.getContextPath() + "/user?a=loginform");
		}

	}

}
