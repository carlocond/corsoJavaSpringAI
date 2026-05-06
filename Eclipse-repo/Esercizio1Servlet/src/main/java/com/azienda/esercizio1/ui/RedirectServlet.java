package com.azienda.esercizio1.ui;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Random rand = new Random();
		
		int lat = rand.nextInt(100);
		int lon = rand.nextInt(100);
		
		//String query
		resp.sendRedirect(req.getContextPath() + "/acquisisciServlet?lat" + lat + "&lon=" + lon);
		
	}
	
}
