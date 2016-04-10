package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import exception.GenericException;
import model.Categoria;
import persistence.CategoriaDaoImpl;

@ManagedBean
@ApplicationScoped
public class CategoriaMB extends GenericBean<Categoria> implements Serializable{
	private static final long serialVersionUID = 1949986787432773393L;
	
	public CategoriaMB() {
		super.listaPesquisa = new ArrayList<Categoria>();
		super.objAtual = new Categoria();
		super.dao = new CategoriaDaoImpl();
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
	public void altera(Categoria selectedObj) {
		String msg="Erro ao Alterar!";
		try {
			dao.altera(selectedObj);
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
			dao.exclui(selectedObj);
			msg = "Exclusão realizada com sucesso!";
			FacesContext fc= FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
			pesquisar();
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    public void onRowEdit(RowEditEvent event) {
    	altera( (Categoria) event.getObject());
    	FacesMessage msg = new FacesMessage("Categoria editada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Categoria Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
