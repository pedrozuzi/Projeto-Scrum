package control;

import java.io.Serializable;
import java.util.List;
import persistence.GenericDao;


abstract class GenericBean<T> implements Serializable{
	private static final long serialVersionUID = -8972018181173269695L;
	
	
	protected List<T> listaPesquisa; 
	protected T objAtual;
	protected GenericDao<T> dao;
	
	public List<T> getListaPesquisa() {
		return listaPesquisa;
	}
	public void setListaPesquisa(List<T> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}
	public T getObjAtual() {
		return objAtual;
	}
	public void setObjAtual(T objAtual) {
		this.objAtual = objAtual;
	}
	
	
}
