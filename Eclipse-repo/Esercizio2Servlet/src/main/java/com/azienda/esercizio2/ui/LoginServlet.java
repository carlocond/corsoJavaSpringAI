package com.azienda.esercizio2.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String utente = req.getParameter("utente");
			String password = req.getParameter("password");
			
			boolean utenteValido = utente != null && utente.equalsIgnoreCase("Pippo");
			boolean passwordValida = password != null && password.equals("Pluto");
			
			if (utenteValido && passwordValida) {
				
				HttpSession session = req.getSession();
				
				session.setAttribute("loggato", "SI");
				resp.sendRedirect(req.getContextPath() + "html/privata/homePrivata.html");
				
			} else {
				
				resp.sendRedirect(req.getContextPath() + "html/privata/loginErrato.html");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "html/privata/loginErrato.html");
		}
		
	}
}
