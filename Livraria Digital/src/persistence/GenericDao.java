package persistence;

import java.sql.SQLException;
import java.util.List;
import exception.GenericException;
/**
 * 
 * @author hury
 *
 * @param <T>
 */
public abstract interface GenericDao <T> {

	 void inclui(T obj) throws GenericException, SQLException;
	 
	 List<T>pesquisa(T obj) throws GenericException, SQLException;
	 
	 void altera (T obj) throws GenericException, SQLException;
	 
	 void exclui (T obj) throws GenericException, SQLException;
	 
}
