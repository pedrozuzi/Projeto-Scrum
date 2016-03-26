package persistence;

import java.sql.Connection;

import connection.ConnectionImpl;
import connection.GenericConnection;

public class LivroDaoImpl implements LivroDao {
	private Connection c;

	public LivroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

}
