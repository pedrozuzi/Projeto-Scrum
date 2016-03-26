package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public List<?> pesquisa(Editora e) throws EditoraDaoException, SQLException {
		List<Editora> lista = new ArrayList<Editora>();
		String sql = "SELECT * FROM editora where nome like ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + e.getNome() + "%");
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			Editora ed = new Editora();
			ed.setNome( rs.getString("nome") );
			ed.setEndereco( rs.getString("endereco") );
			ed.setTelefone( rs.getString("telefone") );
			ed.setCnpj( rs.getString( rs.getString("cnpj") ));
			lista.add( ed );
		}
		ps.close();
		return lista;
	}

	@Override
	public void altera(Editora e) throws EditoraDaoException, SQLException {
		String sql = "UPDATE editora set "
				+ "nome = ?,"
				+ "endereco = ?,"
				+ "telefone = ?,"
				+ "cnpj = ? "
				+ "WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getNome());
		ps.setString(2, e.getEndereco());
		ps.setString(3, e.getTelefone());
		ps.setString(4, e.getCnpj());
		//ID
		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Editora e) throws EditoraDaoException, SQLException {
		String query = "DELETE editora " + " where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		//ID ps.setInt(1, e.getId());

		ps.execute();
		ps.close();
		
	}

}
