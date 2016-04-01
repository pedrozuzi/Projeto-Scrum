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
public class AutorMB extends GenericBean<Autor>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private List<Autor> listaPesquisa = new ArrayList<Autor>();
	//private Autor autorAtual;
	//private AutorDao autorDao;
 
	
	public AutorMB() {
		super.listaPesquisa = new ArrayList<Autor>();
		super.objAtual = new Autor();
		super.dao = new AutorDaoImpl();

		
		//this.autorAtual = new Autor();
		//this.autorDao = new AutorDaoImpl();
	}

	public List<?> pesquisar() {
			try {
				listaPesquisa = dao.pesquisa(objAtual);
			} catch (GenericException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaPesquisa;
	}
	
	public void inclui(){
		try {
			dao.inclui(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altera(){
		try {
			dao.altera(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exclui(){
		try {
			dao.exclui(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	

}
