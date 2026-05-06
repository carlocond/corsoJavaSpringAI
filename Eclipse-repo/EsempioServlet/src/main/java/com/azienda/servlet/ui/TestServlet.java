package com.azienda.servlet.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String num = req.getParameter("num");
			int numero = Integer.parseInt(num); //puo' fallire
			
			System.out.println(numero);
			
			//getRequestDispatcher prende la pagina, forward gira
			req.getRequestDispatcher("html/ok.html").forward(req, resp);
			
			//In caso di errore, guarda catch 31
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("html/errore.html").forward(req, resp);
		}
		
	}

}
