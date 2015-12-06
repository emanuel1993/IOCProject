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
		Mission mission = new Mission();
		while (parameters.hasMoreElements()) {
			String parameter = (String) parameters.nextElement();
			System.out.println("Let's write something down : " + parameter +" : " + req.getParameter(parameter));
			if (parameter.equals("mission_id"))
				if(req.getParameter(parameter) != null && !(req.getParameter(parameter).equals("")))
					mission.setIdmission(Integer.parseInt(req.getParameter(parameter)));
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
		boolean succeed = manager.addReplaceMission(mission);
		
		resp.setContentType("text/html");
		
		List<Mission> missions = manager.getMissionsByType(mission.getMissionType());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MissionsPage.jsp");
		if (dispatcher != null) {
			req.setAttribute("missions", missions);
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mission_type = req.getParameter("mission_type");
		String mission_id = req.getParameter("mission_id");
		
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ReportForm.jsp");
		if (dispatcher != null) {
			req.setAttribute("mission_type", mission_type);
			req.setAttribute("mission_id", mission_id);
			dispatcher.forward(req, resp);
		}
	}
}
