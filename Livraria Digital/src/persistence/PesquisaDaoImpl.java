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
import model.Editora;
import model.Livro;

public class PesquisaDaoImpl implements PesquisaDao {
	private Connection c;
	
	private AutorDao autorDao;
	private EditoraDao editoraDao;
	private LivroDao livroDao;
	
	public PesquisaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	

	public List<Livro> pesquisaTitulo(Livro livro) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();

		String query = "SELECT * FROM livro WHERE titulo like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + livro.getTitulo() + "%");

		ResultSet rs = ps.executeQuery();

		autorDao = new AutorDaoImpl();
		editoraDao = new EditoraDaoImpl();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(autorDao.pesquisaId(rs.getInt("idautor")));
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
	
	/**
	 * Pesquisa livros a partir de uma editora
	 * @param nomeeditora
	 * @return
	 * @throws GenericException
	 * @throws SQLException
	 */
	
	public List<Livro> pesquisaEditora(String nomeeditora) throws GenericException, SQLException {
		
		editoraDao = new EditoraDaoImpl();
		
	    List<Editora> listaeditoras = new ArrayList<Editora>();
	    listaeditoras = editoraDao.pesquisaNome(nomeeditora);
	    
	    
		
		List<Livro> lista = new ArrayList<Livro>();

		String query = "select liv.id, liv.titulo "
				+ "from livro liv "
				+ "inner join editora ed"
				+ " on liv.ideditora = ed.id "
				+ "where ed.id = ? "
				+ "order by ed.id";

		PreparedStatement ps = c.prepareStatement(query);
		//ps.setString(1, "%" + livro.getTitulo() + "%");

		ResultSet rs = ps.executeQuery();

		autorDao = new AutorDaoImpl();
		editoraDao = new EditoraDaoImpl();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(autorDao.pesquisaId(rs.getInt("idautor")));
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

	
	
	
}
