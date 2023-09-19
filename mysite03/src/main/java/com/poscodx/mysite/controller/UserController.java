package com.poscodx.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping(value = "/joinsuccess", method = RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(HttpSession session,
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "password", required = true, defaultValue = "") String password, Model model) {
		UserVo authUser = userService.getUser(email, password);

		// 로그인 실패시, email을 jsp에게 보내며 email은 띄운 채로 login 페이지에 머무름.
		if (authUser == null) {
			model.addAttribute("email", email);
			return "user/login";
		}

		/** 인증 처리 **/
		session.setAttribute("authUser", authUser);

		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping(value = "/update")
	public String update(HttpSession session, Model model) {
		// Access Control(접근 제어) -- url로 update를 검색했을 때, 로그인 안되어 있는 사용자 막기
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/user/login";
		}
		///////////////////////////////////////////////////////////

		UserVo userVo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo", userVo);
		return "user/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpSession session, UserVo userVo) {
		// Access Control(접근 제어) -- url로 update를 검색했을 때, 로그인 안되어 있는 사용자 막기
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/user/login";
		}
		///////////////////////////////////////////////////////////
		userVo.setNo(authUser.getNo());
		userService.update(userVo);
		
		authUser.setName(userVo.getName());

		return "redirect:/user/update";
	}
	
	//@ExceptionHandler(Exception.class)
	//public String handlerException() {
	//	return "error/exception";
	//}
}