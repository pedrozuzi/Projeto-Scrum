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
public abstract class GenericBean<T> implements Serializable {
	
	private static final long serialVersionUID = -8972018181173269695L;

	protected List<T> listaPesquisa;
	protected T objAtual;
	protected GenericDao<T> dao;
	protected T selectedObj;

	abstract public List<T> pesquisar() throws GenericException, SQLException;

	abstract public void inclui() throws GenericException, SQLException;

	abstract public void altera(T selectedObj) throws GenericException, SQLException;

	abstract public void exclui(T selectedObj) throws GenericException, SQLException;

	/*
	 * protected List<T> pesquisar() { try { listaPesquisa =
	 * dao.pesquisa(objAtual); } catch (GenericException | SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * return listaPesquisa; }
	 * 
	 * protected void inclui() { try { dao.inclui(objAtual); } catch
	 * (GenericException | SQLException e) { e.printStackTrace(); } }
	 * 
	 * protected void altera() { try { dao.altera(objAtual); } catch
	 * (GenericException | SQLException e) { e.printStackTrace(); } }
	 * 
	 * protected void exclui() { try { dao.exclui(objAtual); } catch
	 * (GenericException | SQLException e) { e.printStackTrace(); } }
	 */
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

	public T getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(T selectedObj) {
		this.selectedObj = selectedObj;
	}

	public GenericDao<T> getDao() {
		return dao;
	}

	public void setDao(GenericDao<T> dao) {
		this.dao = dao;
	}

}
