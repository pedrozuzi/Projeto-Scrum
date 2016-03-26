package persistence;

import java.sql.Connection;

import connection.ConnectionImpl;
import connection.GenericConnection;

public class EditoraDaoImpl implements EditoraDao {
	private Connection c;

	public EditoraDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

}
