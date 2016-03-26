package persistence;

import java.util.List;

import model.Autor;

public abstract interface GenericCRUD <T> {

	 void inclui(T obj);
	 
	 List<?>pesquisa(T obj);
	 
	 void altera (T obj);
	 
	 void exclui (T obj);

	
}
