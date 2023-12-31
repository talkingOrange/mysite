package com.poscodx.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;
import com.poscodx.web.mvc.board.BoardActionFactory;

public class BoardController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String actionName = request.getParameter("a");
		
		ActionFactory af = new BoardActionFactory(); 
		Action action = af.getAction(actionName);
		action.execute(request, response);
	   
//	   request
//      .getRequestDispatcher("/WEB-INF/views/board/list.jsp")
//      .forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}