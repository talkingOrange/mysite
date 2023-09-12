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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle(title);
		boardVo.setContents(content);
	
		// session을 통해 userNo를 얻어옴.
		HttpSession session = request.getSession(true);
		UserVo user = (UserVo) session.getAttribute("authUser");
		
		// user의 정보가 null인 경우, login 화면으로 이동
		if (user != null) {
		    Long userNo = user.getNo(); 
		    boardVo.setUserNo(userNo);
		    System.out.println(boardVo);
		    new BoardDao().insert(boardVo);
		    response.sendRedirect(request.getContextPath() + "/board");
		} else {
		    System.out.println("User's information not found in session.");
		    response.sendRedirect(request.getContextPath() + "/user?a=loginform");
		}
		   
	}

}
