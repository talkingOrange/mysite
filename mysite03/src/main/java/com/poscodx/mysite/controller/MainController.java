package com.poscodx.mysite.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;

@Controller
public class MainController {
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;

	@RequestMapping("/")
	public String index(Model model) {
		SiteVo vo = siteService.getSite();

		// ServletContext를 이용하여 데이터를 가져옴
		servletContext.setAttribute("siteTitle", vo.getTitle()); // "siteTitle"로 저장

		model.addAttribute("siteVo", vo);
		return "main/index";
	}

}
