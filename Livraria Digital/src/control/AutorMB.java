package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

	private static final long serialVersionUID = 1L;

	public AutorMB() {
		super.listaPesquisa = new ArrayList<Autor>();
		super.objAtual = new Autor();
		super.dao = new AutorDaoImpl();

	}

	@Override
	public List<Autor> pesquisar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			listaPesquisa = dao.pesquisa(objAtual);
			 context.addMessage(null, new FacesMessage("Pesquisado, encontrado "+listaPesquisa.size()+" registros") );
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	@Override
	public void inclui() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			dao.inclui(objAtual);
	        context.addMessage(null, new FacesMessage("Autor Adicionado com sucesso!") );
		} catch (GenericException | SQLException e) {
			
			context.addMessage(null, new FacesMessage("ERRO") );
			e.printStackTrace();
		}
	}

	@Override
	public void altera() {
		try {
			dao.altera(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exclui() {
		try {
			dao.exclui(objAtual);
		} catch (GenericException | SQLException e) {
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
