package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public void inclui(Autor obj)  {
		/*
		 * create table autor( id int not null identity, nome varchar(100) not
		 * null, datanasc date not null, datafale date, localmorte varchar(100),
		 * --biografia primary key(id) )
		 */
/**
		String query = "INSERT INTO autor VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
       
		ps.execute();
		ps.close();
		*/
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
