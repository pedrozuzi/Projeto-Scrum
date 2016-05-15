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
 * 
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
	 * Pesquisa um autor pelo id
	 * 
	 * @param id
	 * @return
	 * @throws GenericException
	 * @throws SQLException
	 */

	public Autor pesquisaId(int id) throws GenericException, SQLException {
		String query = "SELECT * FROM autor where id = ?";
		Autor a = new Autor();

		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDatanasc(rs.getDate("datanasc"));
			a.setDatafale(rs.getDate("datafale"));
			a.setLocalmorte(rs.getString("localmorte"));
			a.setBiografia(rs.getString("biografia"));
		}
		ps.close();

		return a;

	}

	/**
	 * @param Autor
	 *            Inclui um autor no BD a partir dos dados do objeto Autor
	 */
	@Override
	public void inclui(Autor obj) throws GenericException, SQLException {

		String query = "INSERT INTO autor VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());

		ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));

		String data = String.valueOf(obj.getDatafale()).toString();
		if (data.equalsIgnoreCase("") || data.equalsIgnoreCase("null")) {
			ps.setDate(3, null);
		} else {
			ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
		}

		ps.setString(4, obj.getLocalmorte());
		ps.setString(5, obj.getBiografia());

		ps.execute();
		ps.close();

	}

	/**
	 * @param Autor
	 *            Pesquisa Autores no banco de dados, de acordo com os
	 *            parametros de pesquisa
	 * @return Uma lista de Autores
	 */
	@Override
	public List<Autor> pesquisa(Autor obj) throws GenericException, SQLException {
		List<Autor> lista = new ArrayList<Autor>();
		String query = "SELECT * FROM autor where nome like ?"; // where id = ?

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + obj.getNome() + "%");
		ResultSet rs = ps.executeQuery();

		// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		while (rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDatanasc(rs.getDate("datanasc"));
			a.setDatafale(rs.getDate("datafale"));
			a.setLocalmorte(rs.getString("localmorte"));
			a.setBiografia(rs.getString("biografia"));

			lista.add(a);
		}
		ps.close();

		return lista;
	}

	/**
	 * @param Autor
	 *            Altera determinado autor a partir do id
	 */
	@Override
	public void altera(Autor obj) throws GenericException, SQLException {
		String query = "UPDATE autor SET nome = ?, datanasc = ?, datafale = ?,"
				+ " localmorte = ?, biografia = ?  WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		System.out.println(obj.getNome());

		ps.setString(1, obj.getNome());
		ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));

		String data = String.valueOf(obj.getDatafale()).toString();
		if (data.equalsIgnoreCase("") || data.equalsIgnoreCase("null")) {
			ps.setDate(3, null);
		} else {
			ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
		}

		ps.setString(4, obj.getLocalmorte());
		ps.setString(5, obj.getBiografia());
		ps.setInt(6, obj.getId());

		ps.execute();
		ps.close();

	}

	/**
	 * @param Autor
	 *            Exclui determinado Autor a partir do id
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
