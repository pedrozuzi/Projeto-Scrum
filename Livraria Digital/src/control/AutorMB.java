package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.eclipse.jdt.internal.compiler.ast.SuperReference;

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
public class AutorMB extends GenericBean<Autor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private List<Autor> listaPesquisa = new ArrayList<Autor>();
	// private Autor autorAtual;
	// private AutorDao autorDao;

	public AutorMB() {
		super.listaPesquisa = new ArrayList<Autor>();
		super.objAtual = new Autor();
		super.dao = new AutorDaoImpl();

		// this.autorAtual = new Autor();
		// this.autorDao = new AutorDaoImpl();
	}

	@Override
	public List<Autor> pesquisar() {
		try {
			listaPesquisa = dao.pesquisa(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	@Override
	public void inclui() {
		try {
			dao.inclui(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void altera() {
		try {
			dao.altera(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void exclui() {
		try {
			dao.exclui(objAtual);
		} catch (GenericException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Autor> getListaPesquisa() {
		// TODO Auto-generated method stub
		return listaPesquisa;
	}

	@Override
	public void setListaPesquisa(List<Autor> listaPesquisa) {
		// TODO Auto-generated method stub
		this.listaPesquisa = listaPesquisa;
	}

	@Override
	public Autor getObjAtual() {
		// TODO Auto-generated method stub
		return objAtual;
	}

	@Override
	public void setObjAtual(Autor objAtual) {
		// TODO Auto-generated method stub
		this.objAtual = objAtual;
	}

}
