package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import exception.EditoraDaoException;
import exception.GenericException;
import model.Autor;
import model.Editora;
import persistence.EditoraDao;
import persistence.EditoraDaoImpl;

@ManagedBean
@ViewScoped
public class EditoraMB extends GenericBean<Editora> implements Serializable {
	private static final long serialVersionUID = -2359826975327120781L;
	
	public EditoraMB() {
		super.listaPesquisa = new ArrayList<Editora>();
		super.objAtual = new Editora();
		super.dao = new EditoraDaoImpl();
	}
	
	@Override
	public void inclui() {
		try {
			dao.inclui(objAtual);
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Editora> getListaPesquisa() {
		return listaPesquisa;
	}

	@Override
	public void setListaPesquisa(List<Editora> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	@Override
	public Editora getObjAtual() {
		return objAtual;
	}

	@Override
	public void setObjAtual(Editora objAtual) {
		this.objAtual = objAtual;
	}
/*
	private List<Editora> lista = new ArrayList<Editora>();
	private Editora editoraAtual;
	private EditoraDao eDao;

	public EditoraMB() {
		editoraAtual = new Editora();
		eDao = new EditoraDaoImpl();
	}


	public void inclui() throws GenericException, SQLException {
		String msg="Erro ao cadastrar!";
		try {
			eDao.inclui(editoraAtual);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (EditoraDaoException ex) {
			ex.printStackTrace();
		}

	}

	public void altera() throws GenericException, SQLException {
		String msg="Erro ao Alterar!";
		try{	
			eDao.altera(editoraAtual);
			msg = "Alteração realizada com sucesso!";
			FacesContext fc= FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
		}catch(EditoraDaoException ex){	
			ex.printStackTrace();
		}
	}
	
	public void exclui()throws GenericException, SQLException {
		String msg="Erro ao Excluir!";
		
		try{	
			eDao.exclui(editoraAtual);
			msg = "Exclusão realizada com sucesso!";
			FacesContext fc= FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
		}catch(EditoraDaoException ex){	
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public String pesquisar() throws GenericException, SQLException {
		String msg = "Erro";
		try {
			lista = (List<Editora>) eDao.pesquisa(editoraAtual);
			msg = "Foram encontradas " + lista.size() + " editoras";
		} catch (EditoraDaoException ex) {
			ex.printStackTrace();
		}
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage( msg ) );
		return "index.xhtml";
	}

	public Editora getEditoraAtual() {
		return editoraAtual;
	}

	public void setEditoraAtual(Editora editoraAtual) {
		this.editoraAtual = editoraAtual;
	}


	public List<Editora> getLista() {
		return lista;
	}


	public void setLista(List<Editora> lista) {
		this.lista = lista;
	}
*/

}
