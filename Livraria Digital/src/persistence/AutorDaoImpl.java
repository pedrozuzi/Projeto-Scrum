package persistence;

import java.sql.Connection;

import connection.ConnectionImpl;
import connection.GenericConnection;

public class AutorDaoImpl implements AutorDao {
	private Connection c;

	public AutorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

}
