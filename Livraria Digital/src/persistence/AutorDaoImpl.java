package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Autor;

public class AutorDaoImpl implements AutorDao {
	private Connection c;

	public AutorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Autor obj)  {

		
		try {
			String query = "INSERT INTO autor VALUES (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(query);
			
			ps.setString(1, obj.getNome());
	        ps.setDate(2, new java.sql.Date(obj.getDatanasc().getTime()));
			ps.setDate(3, new java.sql.Date(obj.getDatafale().getTime()));
			ps.setString(4, obj.getLocalmorte());
	       
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<?> pesquisa(Autor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Autor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exclui(Autor obj) {
		// TODO Auto-generated method stub

	}

}
