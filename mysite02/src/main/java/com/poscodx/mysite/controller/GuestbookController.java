package com.poscodx.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.GuestbookDao;
import com.poscodx.mysite.vo.GuestbookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");

		if ("insert".equals(action)) {

			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String contents = request.getParameter("content");

			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);

			new GuestbookDao().insert(vo);
			System.out.println(vo);
			response.sendRedirect("/mysite02/guestbook");

		} else if ("delete".equals(action)) {
			String stringNo = request.getParameter("no");
			Long no = Long.parseLong(stringNo);
			String password = request.getParameter("password");

			new GuestbookDao().deleteByNoAndPassword(no, password);
			response.sendRedirect("/mysite02/guestbook");
		} else if ("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(request, response);

		} else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/guestbook/index.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
