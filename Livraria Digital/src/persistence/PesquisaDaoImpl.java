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

	public PesquisaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}


	public List<Livro> pesquisaPorTitulo(String titulo) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		LivroDaoImpl lDao = new LivroDaoImpl();
		
		String query = "SELECT * FROM livro WHERE titulo like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + titulo + "%");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(lDao.pesquisaInnerAutor(li));
			li.setEditora(pesquisaEditora(li));
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
		ps.close();

		return lista;
	}

	private Editora pesquisaEditora(Livro l) throws SQLException {
		Editora e = new Editora();
		
		String query = "select editora.id, editora.nome, editora.tel, editora.cnpj, editora.cep, editora.uf,"
						+ " editora.cidade, editora.bairro, editora.rua, editora.numero, editora.compl "
						 + "from editora "
						+ "inner join livro "
						+ "on editora.id = livro.id "
						+ "where livro.id = ? "
						+ "order by editora.id, editora.nome, editora.tel, editora.cnpj, editora.cep, editora.uf, "
						+ " editora.cidade, editora.bairro, editora.rua, editora.numero, editora.compl";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, l.getId());
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			e.setId( rs.getInt("id"));
			e.setNome( rs.getString("nome") );
			e.setTelefone( rs.getString("tel") );
			e.setCnpj( rs.getString("cnpj"));
			e.setCep( rs.getString("cep") );
			e.setUf( rs.getString("uf") );
			e.setCidade( rs.getString("cidade") );
			e.setBairro( rs.getString("bairro") );
			e.setRua( rs.getString("rua") );
			e.setNumero( rs.getInt("numero") );
			e.setCompl( rs.getString("compl") );
		}
		
		return e;
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
		LivroDaoImpl lDao = new LivroDaoImpl();
		String query = "select * from v_pesquisaPorEditora where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + editora + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(lDao.pesquisaInnerAutor(li));
			li.setEditora(pesquisaEditora(li));
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
		ps.close();
		return lista;
	}

	public List<Livro> pesquisaPorAutor(String autor) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		LivroDaoImpl lDao = new LivroDaoImpl();
		
		String query = "select * from v_pesquisaPorAutor where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + autor + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(lDao.pesquisaInnerAutor(li));
			li.setEditora(pesquisaEditora(li));
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
		ps.close();
		return lista;
	}
	
	public List<Livro> pesquisaPorCategoria(String categoria) throws GenericException, SQLException {
		List<Livro> lista = new ArrayList<Livro>();
		LivroDaoImpl lDao = new LivroDaoImpl();
		String query = "select * from v_pesquisaPorCategoria where nome like ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + categoria + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Livro li = new Livro();
			li.setId(rs.getInt("id"));
			li.setAutor(lDao.pesquisaInnerAutor(li));
			li.setEditora(pesquisaEditora(li));
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
		ps.close();
		return lista;
	}

}
