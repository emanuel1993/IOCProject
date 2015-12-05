package com.ioc.rotw.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioc.rotw.bussinesslogic.Manager;
import com.ioc.rotw.entities.Mission;

public class ListMissionsServlet extends HttpServlet {

	private static final long serialVersionUID = 5037183675623715216L;
	
	String type;
	Manager manager;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		manager = new Manager();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*HttpSession session = req.getSession(true);
		if (session == null)
			return;*/
		Enumeration<String> parameters = req.getParameterNames();
		if (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			if (parameter.equals("mission_type"))
				type = req.getParameter(parameter);
		}
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MissionsPage.jsp");
		List<Mission> missions = manager.getMissionsByType(type);
		if (dispatcher != null) {
			req.setAttribute("missions", missions);
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
