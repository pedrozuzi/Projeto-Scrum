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
import exception.GenericException;
import model.Livro;

/**
 * 
 * @author 
 *
 */

public class LivroDaoImpl implements LivroDao {
	private Connection c;

	public LivroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Livro l) throws GenericException, SQLException {

		String query = "INSERT INTO autor VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, l.getIdAutor());
		ps.setInt(2, l.getIdEditora());
		ps.setString(3, l.getTitulo());
		ps.setInt(4, l.getIsbn());
		ps.setInt(5, l.getPaginas());
		ps.setInt(6, l.getEdicao());
		ps.setString(7, l.getTipoCapa());
		ps.setInt(8, l.getAno());
		ps.setString(9, l.getAssunto());
		ps.setString(10, l.getIdioma());
		
		ps.execute();
		ps.close();

	}

	@Override
	public List<Livro> pesquisa(Livro l) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		String query = "SELECT * FROM autor whete id = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setIdAutor(rs.getInt("idautor"));
			li.setIdEditora(rs.getInt("ideditora"));
			li.setTitulo(rs.getString("titulo"));
			li.setIsbn(rs.getInt("isbn"));
			li.setPaginas(rs.getInt("paginas"));
			li.setEdicao(rs.getInt("edicao"));
			li.setTipoCapa(rs.getString("tidocapa"));
			li.setAno(rs.getInt("ano"));
			li.setAssunto(rs.getString("assunto"));
			li.setIdioma(rs.getString("idioma"));
			
			lista.add(l);
		}
		ps.close();

		return lista;
	}

	@Override
	public void altera(Livro l) throws EditoraDaoException, SQLException {
		String sql = "UPDATE livro SET idautor = ?, ideditora = ?, titulo = ?,"
				+ "isbn = ?, paginas = ?, edicao = ?, tipoca = ?, ano = ?,"
				+ "assunto = ?, idioma = ?"
				+ "WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setInt(1, l.getIdAutor());
		ps.setInt(2, l.getIdEditora());
		ps.setString(3, l.getTitulo());
		ps.setInt(4, l.getIsbn());
		ps.setInt(5, l.getPaginas());
		ps.setInt(6, l.getEdicao());
		ps.setString(7, l.getTipoCapa());
		ps.setInt(8, l.getAno());
		ps.setString(9, l.getAssunto());
		ps.setString(10, l.getIdioma());
		ps.setInt(11, l.getId());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Livro l)throws GenericException, SQLException {
		String query = "DELETE livro where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, l.getId());

		ps.execute();
		ps.close();

	}

}
