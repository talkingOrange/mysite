package com.poscodx.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String param = request.getParameter("no");
		System.out.println(param);
		if (param != null) {
			Long no = Long.parseLong(param);
			new BoardDao().deleteByNo(no);
		} else {
			System.out.println("error: \"no\" is null");
		}
		response.sendRedirect(request.getContextPath() + "/board");
	}

}
