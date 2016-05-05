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
import model.Autor;
import model.Livro;

/**
 * 
 * @author Hury
 *
 */

public class LivroDaoImpl implements LivroDao {
	private Connection c;
	private AutorDao autorDao;
	private EditoraDao editoraDao;

	public LivroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Livro l) throws GenericException, SQLException {

		String query = "INSERT INTO autor VALUES (?,?,?,?,?,?,?,?,?,?,?)"; // ?
		PreparedStatement ps = c.prepareStatement(query);

		// ps.setInt(1, l.getAutor().getId());
		ps.setInt(1, l.getEditora().getId());
		ps.setString(2, l.getTitulo());
		ps.setString(3, l.getIsbn());
		ps.setInt(4, l.getPaginas());
		ps.setInt(5, l.getEdicao());
		ps.setString(6, l.getTipoCapa());
		ps.setInt(7, l.getAno());
		ps.setString(8, l.getAssunto());
		ps.setString(9, l.getIdioma());
		ps.setDouble(10, l.getPreco());
		ps.setString(11, l.getImagem());
		ps.execute();
		ps.close();

	}

	@Override
	public List<Livro> pesquisa(Livro l) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		String query = "SELECT * FROM livro";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		autorDao = new AutorDaoImpl();
		editoraDao = new EditoraDaoImpl();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(pesquisaInnerAutor(li));
			li.setEditora(editoraDao.pesquisaId(rs.getInt("ideditora")));
			li.setTitulo(rs.getString("titulo"));
			li.setIsbn(rs.getString("isbn"));
			li.setPaginas(rs.getInt("paginas"));
			li.setEdicao(rs.getInt("edicao"));
			li.setTipoCapa(rs.getString("tipocapa"));
			li.setAno(rs.getInt("ano"));
			li.setAssunto(rs.getString("assunto"));
			li.setIdioma(rs.getString("idioma"));
			li.setPreco(rs.getDouble("preco"));
			li.setImagem(rs.getString("imagem"));
			li.setResumo(rs.getString("resumo"));
			li.setSumario(rs.getString("sumario"));

			lista.add(li);
		}
		System.out.println("pesquisados livros");
		ps.close();

		return lista;
	}

	public List<Autor> pesquisaInnerAutor(Livro li) throws SQLException {

		List<Autor> lista = new ArrayList<Autor>();
		String query = "SELECT livro.id, livro.titulo, autor.id as idautor, autor.nome as nome, autor.datanasc as nasc, autor.biografia "
				+ "from livro "
				+ "inner join livroautor "
				+ "on livro.id = livroautor.idlivro "
				+ "inner join autor "
				+ "on autor.id = livroautor.idautor "
				+ "where livro.id = ? "
				+ "order by livro.id" ;

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, li.getId());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Autor aut = new Autor();
			aut.setId(rs.getInt("idautor"));
			aut.setNome(rs.getString("nome"));
			aut.setDatanasc(rs.getDate("nasc"));
			aut.setBiografia(rs.getString("biografia"));
			lista.add(aut);
		}

		ps.close();
//
//		List<Autor> lista2 = new ArrayList<Autor>();
//		for (Autor autor : lista) {
//			query = "SELECT * FROM autor WHERE id = ?";
//
//			ps = c.prepareStatement(query);
//			ps.setInt(1, autor.getId());
//			rs = ps.executeQuery();
//			rs.next();
//
//			autor.setNome(rs.getString("nome"));
//			autor.setDatanasc(rs.getDate("datanasc"));
//			autor.setDatafale(rs.getDate("datafale"));
//			autor.setLocalmorte(rs.getString("localmorte"));
//
//			lista2.add(autor);
//		}
//		ps.close();
		return lista;
	}

	public List<Livro> pesquisaEditora(Livro livro) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();

		String query = "select liv.id, liv.titulo " + "from livro liv " + "inner join editora ed"
				+ " on liv.ideditora = ed.id " + "where ed.id = ? " + "order by ed.id";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + livro.getTitulo() + "%");

		ResultSet rs = ps.executeQuery();

		autorDao = new AutorDaoImpl();
		editoraDao = new EditoraDaoImpl();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			// li.setAutor(autorDao.pesquisaId(rs.getInt("idautor")));
			li.setEditora(editoraDao.pesquisaId(rs.getInt("ideditora")));
			li.setTitulo(rs.getString("titulo"));
			li.setIsbn(rs.getString("isbn"));
			li.setPaginas(rs.getInt("paginas"));
			li.setEdicao(rs.getInt("edicao"));
			li.setTipoCapa(rs.getString("tipocapa"));
			li.setAno(rs.getInt("ano"));
			li.setAssunto(rs.getString("assunto"));
			li.setIdioma(rs.getString("idioma"));
			li.setPreco(rs.getDouble("preco"));
			li.setImagem(rs.getString("imagem"));

			lista.add(li);
		}
		ps.close();

		return lista;
	}
	// pesquisaCategoria
	// pesquisaAutor

	@Override
	public void altera(Livro l) throws EditoraDaoException, SQLException {
		String sql = "UPDATE livro SET idautor = ?, ideditora = ?, titulo = ?,"
				+ "isbn = ?, paginas = ?, edicao = ?, tipoca = ?, ano = ?," + "assunto = ?, idioma = ?, preco = ?"
				+ "WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(sql);

		// ps.setInt(1, l.getAutor().getId());
		ps.setInt(2, l.getEditora().getId());
		ps.setString(3, l.getTitulo());
		ps.setString(4, l.getIsbn());
		ps.setInt(5, l.getPaginas());
		ps.setInt(6, l.getEdicao());
		ps.setString(7, l.getTipoCapa());
		ps.setInt(8, l.getAno());
		ps.setString(9, l.getAssunto());
		ps.setString(10, l.getIdioma());
		ps.setDouble(11, l.getPreco());
		ps.setInt(12, l.getId());

		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Livro l) throws GenericException, SQLException {
		String query = "DELETE livro where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, l.getId());

		ps.execute();
		ps.close();

	}

}
