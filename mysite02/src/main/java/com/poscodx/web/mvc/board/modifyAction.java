package com.poscodx.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class modifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		if (param != null) {
			Long no = Long.parseLong(param);
			
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContents(contents);
			boardVo.setNo(no);
			
			new BoardDao().update(boardVo);
			request.setAttribute("boardVo", boardVo);

		} else {
			System.out.println("error: \"no\" is null");
		}

		WebUtil.forward("board/view", request, response);
	}

}