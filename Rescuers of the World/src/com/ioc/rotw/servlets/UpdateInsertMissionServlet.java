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

public class UpdateInsertMissionServlet extends HttpServlet {

	private static final long serialVersionUID = -803588086937224992L;
	
	int id;
	Manager manager;
	Mission mission;
	
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
		mission = new Mission();
		if (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			if (parameter.equals("mission_id"))
				id = Integer.parseInt(req.getParameter(parameter));
			if (parameter.equals("mission_type"))
				mission.setMissionType(req.getParameter(parameter));
			if (parameter.equals("level"))
				mission.setLevel(Integer.parseInt(req.getParameter(parameter)));
			if (parameter.equals("description"))
				mission.setDescription(req.getParameter(parameter));
			if (parameter.equals("max_participants"))
				mission.setMaxParticipants(Integer.parseInt(req.getParameter(parameter)));
			if (parameter.equals("participants"))
				mission.setParticipants(Integer.parseInt(req.getParameter(parameter)));
			if (parameter.equals("mission_name"))
				mission.setMissionName(req.getParameter(parameter));
			if (parameter.equals("pic_name"))
				mission.setPicName(req.getParameter(parameter));
		}
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + "samepage.jsp");
		boolean succeed = manager.addReplaceMission(id, mission);
		if (dispatcher != null) {
			req.setAttribute("succeed", succeed);
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
