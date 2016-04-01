package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import exception.GenericException;
import persistence.GenericDao;
/**
 * 
 * @author hury
 *
 * @param <T>
 */
abstract class GenericBean<T> implements Serializable {
	private static final long serialVersionUID = -8972018181173269695L;

	protected List<T> listaPesquisa;
	protected T objAtual;
	protected GenericDao<T> dao;

	protected List<T> pesquisar() {
		try {
			listaPesquisa = dao.pesquisa(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	protected void inclui() {
		try {
			dao.inclui(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void altera() {
		try {
			dao.altera(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void exclui() {
		try {
			dao.exclui(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

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
