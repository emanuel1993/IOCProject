package com.ioc.rotw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioc.rotw.bussinesslogic.Manager;
import com.ioc.rotw.entities.Mission;
import com.ioc.rotw.helper.Constants;

public class IndexServlet extends HttpServlet {

	public final static long serialVersionUID = 20152015L;

	private Manager manager;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		manager = new Manager();
	}

	@Override
	public void destroy() {
	}

/*	public boolean isLoginError(String username, String password) {
		return (username != null && !username.isEmpty() && password != null && !password.isEmpty()
				&& manager.getType(username, password) == Constants.USER_NONE);
	}*/

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdaD");
		RequestDispatcher dispatcher = null;
		dispatcher = getServletContext().getRequestDispatcher("/" + Constants.LOGIN_PAGE);
		if (dispatcher != null) {
				dispatcher.forward(request, response);
				return;
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
