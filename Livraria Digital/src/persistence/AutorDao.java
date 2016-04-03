package persistence;

import java.sql.SQLException;

import exception.GenericException;
import model.Autor;

public interface AutorDao extends GenericDao<Autor>{

	public Autor pesquisaId(int id)throws GenericException, SQLException;

}
