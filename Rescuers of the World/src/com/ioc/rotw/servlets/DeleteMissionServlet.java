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

public class DeleteMissionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7706564778306180804L;
	
	int id;
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
		while (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			if (parameter.equals("mission_id"))
				id = Integer.parseInt(req.getParameter(parameter));
			if (parameter.equals("mission_type"))
				type = req.getParameter(parameter);
		}

		Boolean deleted = manager.deleteMissionEntity(id, type);
		List<Mission> missions = manager.getMissionsByType(type);
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MissionsPage.jsp");
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
