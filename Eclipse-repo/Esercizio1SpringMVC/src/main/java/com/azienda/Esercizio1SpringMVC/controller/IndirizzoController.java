package com.azienda.Esercizio1SpringMVC.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.azienda.Esercizio1SpringMVC.model.Indirizzo;
import com.azienda.Esercizio1SpringMVC.model.ParametriRicerca;
import com.azienda.Esercizio1SpringMVC.service.IndirizzoService;

import jakarta.validation.Valid;


@Controller
public class IndirizzoController {

	private final IndirizzoService indirizzoService;

    public IndirizzoController(IndirizzoService indirizzoService) {
        this.indirizzoService = indirizzoService;
    }

    @GetMapping("/indirizzi")
    public String listaCompleta(Model model) {
        model.addAttribute("listaIndirizzi", indirizzoService.findAll());
        return "indirizzi";
    }

    @GetMapping("/indirizzi/{param}")
    public String listaPerCitta(@PathVariable String param, Model model) {
        model.addAttribute("listaIndirizzi", indirizzoService.findByCitta(param));
        model.addAttribute("cittaRicercata", param);
        return "indirizzi-filtrati";
    }

    @GetMapping("/ricerca")
    public String paginaRicerca(Model model) {
        model.addAttribute("parametriRicerca", new ParametriRicerca());
        model.addAttribute("risultati", List.of());
        return "ricerca";
    }

    
    //@ModelAttribute fa il binding automatico tra input form e classe ParametriRicerca.
    @PostMapping("/ricerca")
    public String submitRicerca(@ModelAttribute("parametriRicerca") ParametriRicerca parametriRicerca, Model model) {
        String citta = parametriRicerca.getCitta() == null ? "" : parametriRicerca.getCitta().trim();
        String via = parametriRicerca.getVia() == null ? "" : parametriRicerca.getVia().trim();

        List<Indirizzo> risultati;
        if (citta.isBlank() && via.isBlank()) {
            risultati = List.of();
        } else {
            risultati = indirizzoService.findByCittaOrVia(citta, via);
        }

        model.addAttribute("risultati", risultati);
        return "ricerca";
    }

    @GetMapping("/indirizzi/nuovo")
    public String nuovoIndirizzo(Model model) {
        model.addAttribute("indirizzo", new Indirizzo());
        return "nuovo-indirizzo";
    }

    //@ModelAttribute fa binding verso la classe Indirizzo, @Valid attiva le validazioni Bean Validation.
    @PostMapping("/indirizzi/nuovo")
    public String salvaIndirizzo(@Valid @ModelAttribute("indirizzo") Indirizzo indirizzo, BindingResult bindingResult) {
    	
    	//BindingResult contiene eventuali errori tipo campo vuoto, civico non valido.
    	//Se ok salva via service e fa redirect su /indirizzi per ricaricare la lista completa.
    	
        if (bindingResult.hasErrors()) {
            return "nuovo-indirizzo";
        }
        indirizzoService.save(indirizzo);
        return "redirect:/indirizzi";
    }
	
}
