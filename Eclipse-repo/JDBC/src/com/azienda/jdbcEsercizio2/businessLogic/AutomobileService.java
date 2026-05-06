package com.azienda.jdbcEsercizio2.businessLogic;

import java.sql.SQLException;
import java.util.List;

import com.azienda.jdbcEsercizio2.dao.DaoAutomobile;
import com.azienda.jdbcEsercizio2.model.Automobile;

public class AutomobileService {

	private DaoAutomobile dao;
	
	public AutomobileService(DaoAutomobile dao) {
		this.dao = dao;
	}
	
	//METODO UTIL
	private void validaCampiObbligatori(String marca, String modello, String targa, String colore, Float cilindrata) {
        if (isBlank(marca) || isBlank(modello) || isBlank(targa) || isBlank(colore) || cilindrata == null || cilindrata <= 0) {
            throw new IllegalArgumentException("Tutti i campi sono obbligatori e cilindrata deve essere > 0.");
        }
    }

	//METODO UTIL
    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
	
    //IMPLEMENTAZIONE INSERT
	public Automobile addAutomobile(String marca, String modello, String targa, String colore, Float cilindrata)
			throws SQLException {
		
		validaCampiObbligatori(marca, modello, targa, colore, cilindrata);
		
		Integer nextId = dao.getNextId();
		Automobile a = new Automobile(nextId, marca.trim(), modello.trim(), targa.trim(), colore.trim(), cilindrata);
		if (dao.existsDuplicate(a)) {
			throw new IllegalArgumentException("Controlla i campi, l'auto e' gia presente");
		}
		
		return dao.insert(a);
		
	}
	
	//IMPLEMENTAZIONE READ ALL
	public List<Automobile> getAllAutomobile() throws SQLException{
		return dao.read();
	}
	
	//IMPLEMENTAZIONE DELETE PER TARGA
	public void deleteByMarca(String prefissoMarca) throws SQLException {
		if (isBlank(prefissoMarca)) {
			throw new IllegalArgumentException("Non devi lasciare vuoto");
		}
		dao.deleteByMarca(prefissoMarca);
	}
	
	//IMPLEMENTAZIONE UPDATE TARGA PER MARCA
	public void updateTargaByMarca(String prefissoMarca, String nuovaTarga) throws SQLException{
		if (isBlank(prefissoMarca) || isBlank(nuovaTarga)) {
			throw new IllegalArgumentException("Non devi lasciare vuoto");
		}
		dao.updateTargaByMarca(prefissoMarca.trim(), nuovaTarga.trim());
	}
	
	//IMPLEMENTAZIONE UPDATE PER ID
	public Automobile updateAutomobileById(Integer id, String marca, String modello, String targa, String colore, Float cilindrata) 
			throws SQLException {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("ID non valido");
		}
		
		validaCampiObbligatori(marca, modello, targa, colore, cilindrata);
		Automobile aggiornata = new Automobile(id, marca.trim(), modello.trim(), targa.trim(), colore.trim(), cilindrata);
		
		return dao.update(id, aggiornata);
	}
	
	//IMPLEMENTAZIONE DELETE PER ID
	public void deleteById(Integer id) throws SQLException {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("ID non valido");
		}
		dao.delete(id);
	}
	
}
