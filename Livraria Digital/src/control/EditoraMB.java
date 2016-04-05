package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import exception.GenericException;
import model.Editora;
import persistence.EditoraDaoImpl;
/**
 * Classe responsavel pelo controle da Editora
 * @author Gustavo
 *
 */
@ManagedBean(name ="editoraMB")
@ViewScoped
public class EditoraMB extends GenericBean<Editora> implements Serializable {
	
	private static final long serialVersionUID = -2359826975327120781L;
	

	public EditoraMB() {
		super.listaPesquisa = new ArrayList<Editora>();
		super.objAtual = new Editora();
		super.dao = new EditoraDaoImpl();
		super.selectedObj = new Editora();
	}
	
	

	/**
	 * realiza a inclusao da editora.
	 */
	@Override
	public void inclui() {
		//String msg="Erro ao cadastrar!";
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dao.inclui(objAtual);
			fc.addMessage(null, new FacesMessage( "Cadastro concluído com sucesso!" ) );
			System.out.println("Excluido");
		} catch (GenericException | SQLException e) {
			
			fc.addMessage(null, new FacesMessage("ERRO!"));
			e.printStackTrace();
		}
	}
	
	/**
	 * Realiza a pesquisa de todos as editoras
	 */
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
	
	/**
	 * Altera um determinada editora.
	 * 
	 */
	@Override
	public void altera(Editora selectedObj) {
		FacesContext fc= FacesContext.getCurrentInstance();
		try {
			dao.altera(selectedObj);
			fc.addMessage(null,new FacesMessage("Editora alterada com sucesso!"));
			pesquisar();
			System.out.println("Alterado");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Excluir um determinada editora
	 */
	@Override
	public void exclui(Editora selectedObj) {
		FacesContext fc= FacesContext.getCurrentInstance();
		try {
			dao.exclui(selectedObj);
			fc.addMessage(null, new FacesMessage("Exclusão realizada com sucesso!"));
			pesquisar();
			System.out.println("Excluindo");
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
// tabela edits
	
    public void onRowEdit(RowEditEvent event) {
    	altera( (Editora) event.getObject());
    	FacesMessage msg = new FacesMessage("Editora editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Editora Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	
	

	@Override
	public void setListaPesquisa(List<Editora> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	
	@Override
	public List<Editora> getListaPesquisa() {
		return listaPesquisa;
	}

	@Override
	public Editora getObjAtual() {
		return objAtual;
	}

	@Override
	public void setObjAtual(Editora objAtual) {
		this.objAtual = objAtual;
	}
	
	public Editora getSelectedObj() {
		return selectedObj;
	}

	public void setSelectedObj(Editora selectedObj) {
		this.selectedObj = selectedObj;
	}

	
	
	
	

}
