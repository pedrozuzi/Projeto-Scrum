package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import exception.GenericException;
import model.Autor;

public class AutorDaoImpl implements AutorDao {
	private Connection c;

	public AutorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Autor obj) throws GenericException, SQLException {

		String query = "INSERT INTO autor VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
		ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));
		ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
		ps.setString(4, obj.getLocalmorte());

		ps.execute();
		ps.close();

	}

	@Override
	public List<?> pesquisa(Autor obj) throws GenericException, SQLException {
		List<Autor> lista = new ArrayList<Autor>();
		String query = "SELECT * FROM autor"; /// whete id = ?
		
		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDatanasc(rs.getDate("datanasc"));
			a.setDatafale(rs.getDate("datafale"));
			a.setLocalmorte(rs.getString("localmorte"));
			
			lista.add(a);
		}
		ps.close();

		return lista;
	}

	@Override
	public void altera(Autor obj) throws GenericException, SQLException {
		String query = "UPDATE autor SET nome = ?, datanasc = ?, datafale = ?,"
				+ " localmorte = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		
		ps.setString(1, obj.getNome());
		ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));
		ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
		ps.setString(4, obj.getLocalmorte());
		ps.setInt(5, obj.getId());
		
		ps.execute();
		ps.close();

	}

	@Override
	public void exclui(Autor obj) throws GenericException, SQLException {
		String query = "DELETE autor where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();

	}

}
