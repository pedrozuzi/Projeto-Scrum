package persistence;

import java.sql.Connection;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Editora;

public class EditoraDaoImpl implements EditoraDao {
	private Connection c;

	public EditoraDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Editora obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> pesquisa(Editora obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Editora obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Editora obj) {
		// TODO Auto-generated method stub
		
	}

}
