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
		super.selectedObj = new Autor();

	}

	/**
	 * Realiza a pesquisa de todos os autores
	 */
	@Override
	public List<Autor> pesquisar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			listaPesquisa = dao.pesquisa(objAtual);
			context.addMessage(null, new FacesMessage("Pesquisado, encontrado " + listaPesquisa.size() + " registros"));
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	/**
	 * Pesquisa um determinado autor pelo nome
	 * @return
	 */
	public List<Autor> pesquisaNome() {

		return listaPesquisa;
	}

	/**
	 * Inclui um autor a DB
	 */
	@Override
	public void inclui() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			dao.inclui(objAtual);
			context.addMessage(null, new FacesMessage("Autor Adicionado com sucesso!"));
		} catch (GenericException | SQLException e) {

			context.addMessage(null, new FacesMessage("ERRO"));
			e.printStackTrace();
		}
	}
	
	/**
	 * Altera um determinado autor
	 */
	@Override
	public void altera(Autor selectedObj) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.altera(objAtual);
			context.addMessage(null, new FacesMessage("Autor Alterado com sucesso!"));
			pesquisar();
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Esclui um determinado autor
	 */
	@Override
	public void exclui(Autor selectedObj) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			dao.exclui(selectedObj);
			context.addMessage(null, new FacesMessage("Autor Excluido com sucesso!"));
			pesquisar();
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}

	//getters e setters
	
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

	public Autor getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(Autor selectedObj) {
		this.selectedObj = selectedObj;
	}

}
