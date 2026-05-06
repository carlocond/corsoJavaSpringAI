package com.azienda.progetto.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ricercaServlet")
public class RicercaServlet extends HttpServlet {

	// Costante da usare sia in servlet sia in ricerca
	public static final String PARAM_RICERCA = "chiaveRicerca";

	private final List<String> citta;

	public RicercaServlet() {
		citta = new ArrayList<>(Arrays.asList(
			"Roma", "Milano", "Napoli", "Torino", "Palermo", "Genova",
			"Bologna", "Firenze", "Bari", "Catania", "Venezia", "Verona",
			"Messina", "Padova", "Trieste", "Taranto", "Brescia", "Parma"
		));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		eseguiRicerca(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		eseguiRicerca(req, resp);
	}

	private void eseguiRicerca(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String input = req.getParameter(PARAM_RICERCA);
			if (input == null) input = "";
			String filtro = input.trim().toLowerCase();

			List<String> risultati = new ArrayList<>();
			for (String nomeCitta : citta) {
				String nomeLower = nomeCitta.toLowerCase();
				if (nomeLower.contains(filtro)) {
					risultati.add(nomeCitta);
				}
			}

			req.setAttribute("risultati", risultati);
			req.setAttribute("testoRicerca", input);
			req.getRequestDispatcher("/jsp/risultati.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore durante la ricerca");
		}
	}
}
