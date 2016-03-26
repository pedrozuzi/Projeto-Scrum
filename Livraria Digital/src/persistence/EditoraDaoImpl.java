package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import exception.EditoraDaoException;
import model.Editora;

public class EditoraDaoImpl implements EditoraDao {
	private Connection c;

	public EditoraDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Editora e) throws EditoraDaoException, SQLException{
		String sql = "INSERT INTO editora VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getNome());
		ps.setString(2, e.getEndereco());
		ps.setString(3, e.getTelefone());
		ps.setString(4, e.getTelefone());
		
		ps.execute();
		ps.close();
		
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
