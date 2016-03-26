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
public abstract interface GenericCRUD <T> {

	 void inclui(T obj) throws GenericException, SQLException;
	 
	 List<?>pesquisa(T obj);
	 
	 void altera (T obj);
	 
	 void exclui (T obj);

	
}
