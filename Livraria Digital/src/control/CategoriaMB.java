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
import model.Categoria;
import model.Editora;
import persistence.CategoriaDaoImpl;

@ManagedBean
@ViewScoped
public class CategoriaMB extends GenericBean<Categoria> implements Serializable{
	private static final long serialVersionUID = 1949986787432773393L;
	
	public CategoriaMB() {
		super.listaPesquisa = new ArrayList<Categoria>();
		super.objAtual = new Categoria();
		super.dao = new CategoriaDaoImpl();
	}

	@Override
	public List<Categoria> pesquisar() throws GenericException, SQLException {
		String msg = "Erro";
		try {
			listaPesquisa = dao.pesquisa(objAtual);
			msg = "Foram encontradas " + listaPesquisa.size() + " categorias";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}

		return listaPesquisa;
	}

	@Override
	public void inclui() throws GenericException, SQLException {
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
	public void altera(Categoria selectedObj) throws GenericException, SQLException {
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
	public void exclui(Categoria selectedObj) throws GenericException, SQLException {
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
	public List<Categoria> getListaPesquisa() {
		return listaPesquisa;
	}

	@Override
	public void setListaPesquisa(List<Categoria> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	@Override
	public Categoria getObjAtual() {
		return objAtual;
	}

	@Override
	public void setObjAtual(Categoria objAtual) {
		this.objAtual = objAtual;
	}

}
