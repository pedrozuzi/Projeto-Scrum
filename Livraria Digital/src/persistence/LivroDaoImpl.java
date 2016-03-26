package persistence;

import java.sql.Connection;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Livro;

public class LivroDaoImpl implements LivroDao {
	private Connection c;

	public LivroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Livro obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> pesquisa(Livro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Livro obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Livro obj) {
		// TODO Auto-generated method stub
		
	}

}
