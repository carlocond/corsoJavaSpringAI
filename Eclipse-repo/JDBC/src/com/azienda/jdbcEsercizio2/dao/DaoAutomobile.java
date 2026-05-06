package com.azienda.jdbcEsercizio2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.azienda.jdbcEsercizio2.model.Automobile;

public class DaoAutomobile implements DaoInterface<Automobile>{
	
	private Connection con;
	
	public DaoAutomobile(Connection con) {
		this.con = con;
	}
	
	public boolean existsDuplicate(Automobile reference) throws SQLException {
		String query = 
				"SELECT COUNT(*) FROM automobile WHERE marca = ? AND modello = ? AND targa = ? AND colore = ? AND cilindrata = ?";
		PreparedStatement prepStatement = con.prepareStatement(query);
		
		prepStatement.setString(1, reference.getMarca());
		prepStatement.setString(2, reference.getModello());
		prepStatement.setString(3, reference.getTarga());
		prepStatement.setString(4, reference.getColore());
		prepStatement.setFloat(5, reference.getCilindrata());
			
		ResultSet rs = prepStatement.executeQuery();
		if (rs.next()) {
			return rs.getInt(1) > 0;
		}	
		return false;
	}
	
	public int getNextId() throws SQLException{
		//COALESCE controlla una lista, e restituisce il primo valore non null che trova.
		//Se tutti sono null, restituisce null.
		String query = "SELECT COALESCE(MAX(id), 0) + 1 FROM automobile";
		PreparedStatement prepStatement = con.prepareStatement(query);
		ResultSet rs = prepStatement.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public Automobile insert(Automobile reference) throws SQLException {
		String query = "INSERT INTO automobile (id, marca, modello, targa, colore, cilindrata) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setInt(1, reference.getId());
		prepStatement.setString(2, reference.getMarca());
		prepStatement.setString(3, reference.getModello());
		prepStatement.setString(4, reference.getTarga());
		prepStatement.setString(5, reference.getColore());
		prepStatement.setFloat(6, reference.getCilindrata());
		prepStatement.executeUpdate();
		return null;
	}

	@Override
	public List<Automobile> read() throws SQLException {
		
		String query = "SELECT * FROM automobile";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		List<Automobile> automobili = new ArrayList<>();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String marca = rs.getString("marca");
			String modello = rs.getString("modello");
			String targa = rs.getString("targa");
			String colore = rs.getString("colore");
			Float cilindrata = rs.getFloat("cilindrata");
			
			Automobile a = new Automobile(id, marca, modello, targa, colore, cilindrata);
			automobili.add(a);
		}
		return automobili;
	}

	@Override
	public Automobile update(Integer id, Automobile reference) throws SQLException {
		String query = 
				"UPDATE automobile SET marca = ?, modello = ?, targa = ?, colore = ?, cilindrata = ? WHERE id = ?";
		
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setString(1, reference.getMarca());
		prepStatement.setString(2, reference.getModello());
		prepStatement.setString(3, reference.getTarga());
		prepStatement.setString(4, reference.getColore());
		prepStatement.setFloat(5, reference.getCilindrata());
		prepStatement.executeUpdate();
		
		return null;
	}

	@Override
	public void delete(Integer id) throws SQLException {
		String query = "DELETE FROM automobile WHERE id = ?";
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setInt(1, id);
		prepStatement.executeUpdate();
	}
	
	public void deleteByMarca(String prefissoMarca) throws SQLException {
		String query = "DELETE FROM automobile WHERE marca LIKE ?";
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setString(1, prefissoMarca + "%");
		prepStatement.executeUpdate();
	}
	
	public void updateTargaByMarca(String prefissoMarca, String nuovaTarga) throws SQLException{
		String query = "UPDATE automobile SET targa = ? WHERE marca LIKE ?";
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setString(1, nuovaTarga);
		prepStatement.setString(2, prefissoMarca + "%");
		prepStatement.executeUpdate();
	}
	
	

}
