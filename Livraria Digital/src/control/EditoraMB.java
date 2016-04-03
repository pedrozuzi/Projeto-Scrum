package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import exception.GenericException;
import model.Editora;
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
		String msg="Erro ao cadastrar!";
		try {
			dao.inclui(objAtual);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Editora> pesquisar() {
		String msg = "Erro";
		try {
			listaPesquisa = dao.pesquisa(objAtual);
			msg = "Foram encontradas " + listaPesquisa.size() + " editoras";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	@Override
	public void altera(Editora selectedObj) {
		String msg="Erro ao Alterar!";
		try {
			dao.altera(objAtual);
			msg = "Alteração realizada com sucesso!";
			FacesContext fc= FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void exclui(Editora selectedObj) {
		String msg="Erro ao Excluir!";
		try {
			dao.exclui(objAtual);
			msg = "Exclusão realizada com sucesso!";
			FacesContext fc= FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
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

}
