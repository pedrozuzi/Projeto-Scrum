package persistence;

import java.sql.Connection;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Autor;

public class AutorDaoImpl implements AutorDao {
	private Connection c;

	public AutorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Autor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> pesquisa(Autor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Autor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Autor obj) {
		// TODO Auto-generated method stub
		
	}



}
