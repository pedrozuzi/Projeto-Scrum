package persistence;

import java.sql.SQLException;
import java.util.List;

import exception.GenericException;
import model.Editora;

public interface EditoraDao extends GenericDao<Editora>{

	public Editora pesquisaId(int id)throws GenericException, SQLException;

	public List<Editora> pesquisaNome(String nomeeditora)throws GenericException, SQLException;
	
}
