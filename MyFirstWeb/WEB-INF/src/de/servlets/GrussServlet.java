package de.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.forms.EingabeForm;

public class GrussServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		EingabeForm form = new EingabeForm(name);
		
//		// Daten in SessionScope retten
//		req.getSession().setAttribute("form", form);
		
		
		// Request-Scope
		req.setAttribute("form", form);
		
		// ServiceCall
		
//		// Leitet via Browser an die JSp weiter (neuer Request-Response Zyklus)
//		resp.sendRedirect("antwort.jsp");
		
		
		// Server intern
		req.getRequestDispatcher("antwort.jsp").forward(req, resp);
		
	}

}
