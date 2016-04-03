package persistence;

import java.sql.SQLException;

import exception.GenericException;
import model.Editora;

public interface EditoraDao extends GenericDao<Editora>{

	public Editora pesquisaId(int id)throws GenericException, SQLException;
	
}
