package com.poscodx.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class writeFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("no");
        System.out.println("writeFormAction" + param);

        // "no" 파라미터 값을 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("param", param);
		
		WebUtil.forward("board/write", request, response);
	}

}
