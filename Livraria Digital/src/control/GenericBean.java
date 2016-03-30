package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


abstract class GenericBean<T> implements Serializable{

	private List<T> listaPesquisa = new ArrayList<T>(); 
	private T objAtual;
	private GenericBean<T> dao;
	
	protected GenericBean(List<T> listaPesquisa, T objAtual, GenericBean<T> dao) {
		this.listaPesquisa = listaPesquisa;
		this.objAtual = objAtual;
	}
	
	
}
