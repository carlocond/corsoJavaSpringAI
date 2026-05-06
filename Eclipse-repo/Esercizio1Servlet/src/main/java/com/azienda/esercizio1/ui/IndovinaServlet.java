package com.azienda.esercizio1.ui;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/indovinaServlet")
public class IndovinaServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			String num = req.getParameter("num");
			int numero = Integer.parseInt(num);
			
			int numRandom = new Random().nextInt(10);
			
			 System.out.println("Numero scelto dall'utente: " + numero);
			 System.out.println("Numero uscito: " + numRandom);
			 
			 if (numero == numRandom) {
				req.getRequestDispatcher("vittoria.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("sconfitta.html").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("errore.html").forward(req, resp);
		}
		
	}

}
