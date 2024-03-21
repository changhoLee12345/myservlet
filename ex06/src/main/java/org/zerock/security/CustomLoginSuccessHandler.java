package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURL()); // http://localhost:8080/controller/sample/admin
		System.out.println(request.getRequestURI());
		System.out.println(request.getServletContext().getContextPath());
		System.out.println(request.getServerName());
		System.out.println(request.getServletPath());

		log.warn("Login Success");

		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		log.warn("Role Names: " + roleNames);

		String path = "";
		if (roleNames.contains("ROLE_ADMIN")) {
			path = request.getServletContext().getContextPath() + "/sample/admin";
			response.sendRedirect(path);
			return;
		}

		if (roleNames.contains("ROLE_MEMBER")) {
			path = request.getServletContext().getContextPath() + "/sample/member";
			response.sendRedirect(path);
			return;
		}

		path = request.getServletContext().getContextPath() + "";
		response.sendRedirect(path);

	}

}