package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


abstract class GenericBEAN <T> implements Serializable{

	private List<T> listaPesquisa = new ArrayList<T>(); 
	private T objAtual;
	
	protected GenericBEAN(List<T> listaPesquisa, T objAtual) {
		this.listaPesquisa = listaPesquisa;
		this.objAtual = objAtual;
	}
	
	
}
