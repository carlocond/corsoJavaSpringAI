package com.azienda.esercizio1SpringRest.service;

import com.azienda.esercizio1SpringRest.model.Localita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class LocalitaService {

    private final List<Localita> localitaList = new ArrayList<>();
    private Integer nextId = 1;

    public LocalitaService() {
        localitaList.add(new Localita(nextId++, "Roma", 24.5));
        localitaList.add(new Localita(nextId++, "Milano", 20.0));
        localitaList.add(new Localita(nextId++, "Torino", 18.3));
        localitaList.add(new Localita(nextId++, "Napoli", 27.1));
    }

    public List<Localita> getAll() {
        return localitaList;
    }

    public Localita getById(Integer id) {
        for (Localita l : localitaList) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    public Localita getByNome(String nome) {
        for (Localita l : localitaList) {
            if (l.getNome().equalsIgnoreCase(nome)) {
                return l;
            }
        }
        return null;
    }

    public List<Localita> getByTemperaturaMinoreDi(Double valore) {
        List<Localita> risultato = new ArrayList<>();
        for (Localita l : localitaList) {
            if (l.getTemperatura() < valore) {
                risultato.add(l);
            }
        }
        return risultato;
    }

    public List<Localita> getByTemperaturaMaggioreDi(Double valore) {
        List<Localita> risultato = new ArrayList<>();
        for (Localita l : localitaList) {
            if (l.getTemperatura() > valore) {
                risultato.add(l);
            }
        }
        return risultato;
    }

    public Localita create(Localita nuovaLocalita) {
        nuovaLocalita.setId(nextId++);
        localitaList.add(nuovaLocalita);
        return nuovaLocalita;
    }

    public Localita updateCompleto(Integer id, Localita localitaAggiornata) {
        Localita esistente = getById(id);
        if (esistente == null) {
            return null;
        }
        esistente.setNome(localitaAggiornata.getNome());
        esistente.setTemperatura(localitaAggiornata.getTemperatura());
        return esistente;
    }

    public Localita updateParziale(Integer id, Map<String, Object> campi) {
        Localita esistente = getById(id);
        if (esistente == null) {
            return null;
        }

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

        return esistente;
    }

    public boolean deleteById(Integer id) {
        return localitaList.removeIf(l -> l.getId().equals(id));
    }

    public int deleteByTemperaturaMinoreDi(Double valore) {
        int count = 0;
        Iterator<Localita> iterator = localitaList.iterator();
        while (iterator.hasNext()) {
            Localita l = iterator.next();
            if (l.getTemperatura() < valore) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public int deleteByTemperaturaMaggioreDi(Double valore) {
        int count = 0;
        Iterator<Localita> iterator = localitaList.iterator();
        while (iterator.hasNext()) {
            Localita l = iterator.next();
            if (l.getTemperatura() > valore) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }
}
