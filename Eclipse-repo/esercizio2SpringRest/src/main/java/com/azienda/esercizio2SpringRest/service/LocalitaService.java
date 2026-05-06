package com.azienda.esercizio2SpringRest.service;

import com.azienda.esercizio2SpringRest.model.Localita;
import com.azienda.esercizio2SpringRest.repository.LocalitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LocalitaService {

    private final LocalitaRepository localitaRepository;

    public LocalitaService(LocalitaRepository localitaRepository) {
        this.localitaRepository = localitaRepository;
    }

    public List<Localita> getAll() {
        return localitaRepository.findAll();
    }

    public Localita getById(Integer id) {
        Optional<Localita> localita = localitaRepository.findById(id);
        return localita.orElse(null);
    }

    public Localita getByNome(String nome) {
        Optional<Localita> localita = localitaRepository.findByNomeIgnoreCase(nome);
        return localita.orElse(null);
    }

    public List<Localita> getByTemperaturaMinoreDi(Double valore) {
        return localitaRepository.findByTemperaturaLessThan(valore);
    }

    public List<Localita> getByTemperaturaMaggioreDi(Double valore) {
        return localitaRepository.findByTemperaturaGreaterThan(valore);
    }

    public Localita create(Localita nuovaLocalita) {
        nuovaLocalita.setId(null);
        return localitaRepository.save(nuovaLocalita);
    }

    public Localita updateCompleto(Integer id, Localita localitaAggiornata) {
        Optional<Localita> optional = localitaRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Localita esistente = optional.get();
        esistente.setNome(localitaAggiornata.getNome());
        esistente.setTemperatura(localitaAggiornata.getTemperatura());

        return localitaRepository.save(esistente);
    }

    public Localita updateParziale(Integer id, Map<String, Object> campi) {
        Optional<Localita> optional = localitaRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Localita esistente = optional.get();

        if (campi.containsKey("nome")) {
            Object nomeObj = campi.get("nome");
            if (nomeObj != null) {
                esistente.setNome(nomeObj.toString());
            }
        }

        if (campi.containsKey("temperatura")) {
            Object tempObj = campi.get("temperatura");
            if (tempObj != null) {
                if (tempObj instanceof Number) {
                    esistente.setTemperatura(((Number) tempObj).doubleValue());
                } else {
                    esistente.setTemperatura(Double.parseDouble(tempObj.toString()));
                }
            }
        }

        return localitaRepository.save(esistente);
    }

    public boolean deleteById(Integer id) {
        if (!localitaRepository.existsById(id)) {
            return false;
        }
        localitaRepository.deleteById(id);
        return true;
    }

    public long deleteByTemperaturaMinoreDi(Double valore) {
        return localitaRepository.deleteByTemperaturaLessThan(valore);
    }

    public long deleteByTemperaturaMaggioreDi(Double valore) {
        return localitaRepository.deleteByTemperaturaGreaterThan(valore);
    }
}
