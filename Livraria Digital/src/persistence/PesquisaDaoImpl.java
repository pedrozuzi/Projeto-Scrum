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
import model.Categoria;
import model.Editora;
import model.Livro;

public class PesquisaDaoImpl implements PesquisaDao {
	private Connection c;

	public PesquisaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}


	public List<Livro> pesquisaPorTitulo(String titulo) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();

		String query = "SELECT * FROM livro WHERE titulo like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + titulo + "%");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
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

	/**
	 * Pesquisa livros a partir de uma editora
	 * @param editora
	 * @return
	 * @throws GenericException
	 * @throws SQLException
	 */

	public List<Livro> pesquisaPorEditora(String editora) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		String query = "select * from v_pesquisaPorEditora where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + editora + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			Editora e = new Editora();
			li.setId(rs.getInt("id"));
			e.setNome(rs.getString("nome"));
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

	public List<Livro> pesquisaPorAutor(String autor) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		String query = "select * from v_pesquisaPorAutor where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + autor + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			Autor a = new Autor();
			li.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
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
	
	public List<Livro> pesquisaPorCategoria(String categoria) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		String query = "select * from v_pesquisaPorCategoria where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + categoria + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			Categoria c = new Categoria();
			li.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
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

}
