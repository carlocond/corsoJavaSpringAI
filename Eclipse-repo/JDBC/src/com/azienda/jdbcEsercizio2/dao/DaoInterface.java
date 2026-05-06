package com.azienda.jdbcEsercizio2.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {
	
	public T insert(T reference) throws SQLException;
	public List<T> read() throws SQLException;
	public T update(Integer id, T reference) throws SQLException;
	public void delete(Integer id) throws SQLException;

}
