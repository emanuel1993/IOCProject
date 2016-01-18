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
import com.ioc.rotw.entities.DistressLevel;
import com.ioc.rotw.entities.Mission;

public class GetMissionServlet extends HttpServlet {

	private static final long serialVersionUID = 4459087946040487607L;
	
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
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ReportForm.jsp");
		Mission mission = manager.getMissionEntity(id, type);
		List<DistressLevel> distressLevels = manager.getDistressLevelList();
		String visitedSectors = mission.getMapData().getVisitedSectors();
		if (dispatcher != null) {
			req.setAttribute("mission_type", mission.getMissionType());
			req.setAttribute("mission_id", mission.getIdmission());
			req.setAttribute("distress_level_id", mission.getDistressLevel().getId());
			req.setAttribute("mission_name", mission.getMissionName());
			req.setAttribute("description", mission.getDescription());
			req.setAttribute("map_center", mission.getMapData().getCenter());
			req.setAttribute("map_zoom", mission.getMapData().getZoom());
			req.setAttribute("distress_levels", distressLevels);
			
			if (visitedSectors != null) {
				if (visitedSectors.contains("11"))
					req.setAttribute("map_sector11", true);
				else
					req.setAttribute("map_sector11", false);
				if (visitedSectors.contains("12"))
					req.setAttribute("map_sector12", true);
				else
					req.setAttribute("map_sector12", false);
				if (visitedSectors.contains("13"))
					req.setAttribute("map_sector13", true);
				else
					req.setAttribute("map_sector13", false);
				if (visitedSectors.contains("21"))
					req.setAttribute("map_sector21", true);
				else
					req.setAttribute("map_sector21", false);
				if (visitedSectors.contains("22"))
					req.setAttribute("map_sector22", true);
				else
					req.setAttribute("map_sector22", false);
				if (visitedSectors.contains("23"))
					req.setAttribute("map_sector23", true);
				else
					req.setAttribute("map_sector23", false);
				if (visitedSectors.contains("31"))
					req.setAttribute("map_sector31", true);
				else
					req.setAttribute("map_sector31", false);
				if (visitedSectors.contains("32"))
					req.setAttribute("map_sector32", true);
				else
					req.setAttribute("map_sector32", false);
				if (visitedSectors.contains("33"))
					req.setAttribute("map_sector33", true);
				else
					req.setAttribute("map_sector33", false);
				}
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
