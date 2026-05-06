package com.azienda.servlet.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/endSession")
public class RemoveSession extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			request.getSession().removeAttribute("chiave");
			request.getRequestDispatcher("html/ok.html").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.getRequestDispatcher("html/errore.html").forward(request, response);
			
		}
		
	}

}
