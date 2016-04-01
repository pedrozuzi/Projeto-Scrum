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

/**
 * Classe responsável pela persistênsia de dados do Autor
 * @author hury
 *
 */
public class AutorDaoImpl implements AutorDao {
	private Connection c;

	/**
	 * O construtor inicia uma conexão com o JDBC
	 */
	public AutorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * @param Autor
	 * Inclui um autor no BD a partir dos dados do objeto Autor
	 */
	@Override
	public void inclui(Autor obj) throws GenericException, SQLException {

		String query = "INSERT INTO autor VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
		ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));
		ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
		ps.setString(4, obj.getLocalmorte());

		ps.execute();
		ps.close();

	}

	/**
	 * @param Autor
	 * Pesquisa Autores no banco de dados, de acordo com os parametros de pesquisa
	 * @return Uma lista de Autores
	 */
	@Override
	public List<Autor> pesquisa(Autor obj) throws GenericException, SQLException {
		List<Autor> lista = new ArrayList<Autor>();
		String query = "SELECT * FROM autor"; // where id = ?
		
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

	/**
	 * @param Autor
	 * Altera determinado autor a partir do id
	 */
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

	/**
	 * @param Autor
	 * Exclui determinado Autor a partir do id
	 */
	@Override
	public void exclui(Autor obj) throws GenericException, SQLException {
		String query = "DELETE autor where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();

	}

}
