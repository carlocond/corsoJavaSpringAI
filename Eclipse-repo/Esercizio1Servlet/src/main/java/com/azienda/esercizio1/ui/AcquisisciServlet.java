package com.azienda.esercizio1.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/acquisisciServlet")
public class AcquisisciServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//Acquisizione valori, ref
			String lat = req.getParameter("lat");
			String lon = req.getParameter("lon");
			
			//Conversione
			int latitudine = Integer.parseInt(lat);
			int longitudine = Integer.parseInt(lon);
			
			
			System.out.println("Latitudine" + latitudine);
			System.out.println("Longitudine" + longitudine);
			
			//Esecuzione richiesta
			req.getRequestDispatcher("risposta.html").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("errore.html").forward(req, resp);
		}
	}
	
}
