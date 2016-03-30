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
		String sql = "INSERT INTO editora VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getNome());
		ps.setString(2, e.getCep());
		ps.setString(3, e.getUf());
		ps.setString(4, e.getCidade());
		ps.setString(5, e.getBairro());
		ps.setString(6, e.getRua());
		ps.setInt(7, e.getNumero());
		ps.setString(8, e.getCompl());
		ps.setString(9, e.getTelefone());
		ps.setString(10, e.getCnpj());
		
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
			ed.setId( rs.getInt("id"));
			ed.setNome( rs.getString("nome") );
			ed.setCep( rs.getString("cep") );
			ed.setUf( rs.getString("uf") );
			ed.setCidade( rs.getString("cidade") );
			ed.setBairro( rs.getString("bairro") );
			ed.setRua( rs.getString("rua") );
			ed.setNumero( rs.getInt("numero") );
			ed.setCompl( rs.getString("compl") );
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
				+ "cep = ?,"
				+ "uf = ?,"
				+ "cidade = ?,"
				+ "bairro = ?,"
				+ "rua = ?,"
				+ "numero = ?,"
				+ "compl = ?,"
				+ "telefone = ?,"
				+ "cnpj = ? "
				+ "WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getNome());
		ps.setString(2, e.getCep());
		ps.setString(3, e.getUf());
		ps.setString(4, e.getCidade());
		ps.setString(5, e.getBairro());
		ps.setString(6, e.getRua());
		ps.setInt(7, e.getNumero());
		ps.setString(8, e.getCompl());
		ps.setString(9, e.getTelefone());
		ps.setString(10, e.getCnpj());
		ps.setInt( 11, e.getId() );
		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Editora e) throws EditoraDaoException, SQLException {
		String query = "DELETE editora " + " where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, e.getId());

		ps.execute();
		ps.close();
		
	}

}
