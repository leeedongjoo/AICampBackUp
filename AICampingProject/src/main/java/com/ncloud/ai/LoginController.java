package com.ncloud.ai;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncloud.common.JsonHndr;

import com.ncloud.domain.LoginVO;
import com.ncloud.service.LoginService;


@Controller
@RequestMapping("/Login")
public class LoginController {
	
	@Inject
	LoginService service;
	
	@PostMapping(value = "/signin")
	public String insertChatLibrary(@ModelAttribute("LoginVO") LoginVO vo, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String user_email = request.getParameter("user_email");
		String user_pwd = request.getParameter("password");
		String loginCheck = request.getParameter("logincheck");
		

		vo.setEmail(user_email);
		vo.setPassword(user_pwd);

		
		
		int result = service.checkUser(vo);
		System.out.println("����Ʈ"+result);
		// ���� �α� ������ֵ��� ����
		// Ȩ ������ 
		
		// ����Ʈ = 1 �ΰ�� 
		// ��� �����Ͱ� �ִٴ°Ŵϱ� ���⼭ ��Ű����
		
		// ����Ʈ < 0 �ΰ��
		// �׳� ���� 
		String a= "";
		
		
		if(result==1) {

			loginCheck="1";
			request.setAttribute("logincheck", loginCheck);
			a="home";
			
		}
		else {
			a="home";
		}
		return a;
	}
}
