package com.azienda.esempiojdbc.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.azienda.esempiojdbc.model.Persona;

public class TestJDBC {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		try {
			
			String driverName = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/esempio_jdbc1?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbUser = "root";
			String dbPassword = "root";
			
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			con.setAutoCommit(false);
			
			Persona p = new Persona("Mario", "Rossi");
			insert(p, con);
			
			System.out.println("Connessione effettuata");
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			con.close();
		}
	}
	
	private static void insert(Persona p, Connection con) throws SQLException {
		
		try {
		
			String query = "INSERT INTO persona (nome, cognome) VALUES ('" + p.getNome() + "', '" + p.getCognome() + "')";
			Statement statement = con.createStatement();
			statement.executeUpdate(query);
			
			con.commit();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}
		
	}
	
	private static void insert2(Persona p, Connection con) throws SQLException {
		
		try {
			
			String query = "INSERT INTO persona (nome, cognome) VALUES (?, ?)";
			PreparedStatement prepStatement = con.prepareStatement(query);
			
			prepStatement.setString(1, p.getNome());
			prepStatement.setString(2, p.getCognome());
			prepStatement.executeUpdate(query);
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}
	}

}
