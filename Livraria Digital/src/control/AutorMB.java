package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import exception.GenericException;
import model.Autor;
import persistence.AutorDao;
import persistence.AutorDaoImpl;
import persistence.GenericDao;

/**
 * Classe reponsável pelo controle do Autor
 * 
 * @author hury
 *
 */

@ManagedBean(name = "autorMB")
@ViewScoped
public class AutorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<?> listaPesquisa = new ArrayList<Autor>();
	private Autor autorAtual;
	private AutorDao autorDao;
 
	
	public AutorMB() {
		//super();
		this.autorAtual = new Autor();
		this.autorDao = new AutorDaoImpl();
	}

	public List<?> pesquisar() {
			try {
				listaPesquisa = autorDao.pesquisa(autorAtual);
			} catch (GenericException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaPesquisa;
	}
	
	public void inclui(){
		try {
			autorDao.inclui(autorAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altera(){
		try {
			autorDao.altera(autorAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exclui(){
		try {
			autorDao.exclui(autorAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<?> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<Autor> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public Autor getAutorAtual() {
		return autorAtual;
	}

	public void setAutorAtual(Autor autorAtual) {
		this.autorAtual = autorAtual;
	}

	public AutorDao getAutorDao() {
		return autorDao;
	}

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

}
