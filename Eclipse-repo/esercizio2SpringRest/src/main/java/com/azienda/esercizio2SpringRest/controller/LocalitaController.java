package com.azienda.esercizio2SpringRest.controller;

import com.azienda.esercizio2SpringRest.model.Localita;
import com.azienda.esercizio2SpringRest.service.LocalitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3036")
@RestController
@RequestMapping("/api/localita")
public class LocalitaController {

    private final LocalitaService localitaService;

    public LocalitaController(LocalitaService localitaService) {
        this.localitaService = localitaService;
    }

    @GetMapping
    public List<Localita> getAll() {
        return localitaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localita> getById(@PathVariable Integer id) {
        Localita localita = localitaService.getById(id);
        if (localita == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(localita);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Localita> getByNome(@PathVariable String nome) {
        Localita localita = localitaService.getByNome(nome);
        if (localita == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(localita);
    }

    @GetMapping("/temperatura/minore/{valore}")
    public List<Localita> getByTemperaturaMinoreDi(@PathVariable Double valore) {
        return localitaService.getByTemperaturaMinoreDi(valore);
    }

    @GetMapping("/temperatura/maggiore/{valore}")
    public List<Localita> getByTemperaturaMaggioreDi(@PathVariable Double valore) {
        return localitaService.getByTemperaturaMaggioreDi(valore);
    }

    @PostMapping
    public ResponseEntity<Localita> create(@RequestBody Localita nuovaLocalita) {
        Localita creata = localitaService.create(nuovaLocalita);
        return ResponseEntity.ok(creata);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Localita> updateCompleto(@PathVariable Integer id, @RequestBody Localita localitaAggiornata) {
        Localita aggiornata = localitaService.updateCompleto(id, localitaAggiornata);
        if (aggiornata == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aggiornata);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Localita> updateParziale(@PathVariable Integer id, @RequestBody Map<String, Object> campi) {
        Localita aggiornata = localitaService.updateParziale(id, campi);
        if (aggiornata == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aggiornata);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        boolean eliminata = localitaService.deleteById(id);
        if (!eliminata) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Localita eliminata");
    }

    @DeleteMapping("/temperatura/minore/{valore}")
    public ResponseEntity<String> deleteByTemperaturaMinoreDi(@PathVariable Double valore) {
        long eliminate = localitaService.deleteByTemperaturaMinoreDi(valore);
        return ResponseEntity.ok("Localita eliminate: " + eliminate);
    }

    @DeleteMapping("/temperatura/maggiore/{valore}")
    public ResponseEntity<String> deleteByTemperaturaMaggioreDi(@PathVariable Double valore) {
        long eliminate = localitaService.deleteByTemperaturaMaggioreDi(valore);
        return ResponseEntity.ok("Localita eliminate: " + eliminate);
    }
}
