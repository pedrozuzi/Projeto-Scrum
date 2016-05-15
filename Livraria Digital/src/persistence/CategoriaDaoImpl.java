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
import model.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {
	
	private static Connection c;
	
	public CategoriaDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Categoria obj) throws GenericException, SQLException {
		String sql = "INSERT INTO categoria VALUES ( ?, ? )";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, obj.getNome());
		ps.setString(2, obj.getDescricao());
		ps.execute();
		ps.close();
	}

	@Override
	public List<Categoria> pesquisa(Categoria obj) throws GenericException, SQLException {
		List<Categoria> lista = new ArrayList<Categoria>();
		String sql = "SELECT * FROM categoria where nome like ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + obj.getNome() + "%");
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			Categoria cat = new Categoria();
			cat.setId( rs.getInt("id") );
			cat.setNome( rs.getString("nome") );
			cat.setDescricao( rs.getString("descricao"));
			lista.add(cat);
		}
		ps.close();
		return lista;
	}

	@Override
	public void altera(Categoria obj) throws GenericException, SQLException {
		String sql = "UPDATE categoria SET nome = ?, descricao = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, obj.getNome());
		ps.setString(2, obj.getDescricao());
		ps.setInt( 3, obj.getId() );
		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Categoria obj) throws GenericException, SQLException {
		String query = "DELETE categoria WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, obj.getId());
		ps.execute();
		ps.close();
	}

}
