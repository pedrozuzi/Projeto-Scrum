package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import exception.EditoraDaoException;
import exception.GenericException;
import model.Editora;
import persistence.EditoraDao;
import persistence.EditoraDaoImpl;

@ManagedBean
@ViewScoped
public class EditoraMB implements Serializable {
	private static final long serialVersionUID = -2359826975327120781L;
	
	private Editora editoraAtual;
	private EditoraDao eDao;
	
	public EditoraMB() {
		editoraAtual = new Editora();
		eDao = new EditoraDaoImpl();
	}
	
	public void inclui() throws GenericException, SQLException { //TALVEZ void NÃO FUNCIONE
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


	public List<?> pesquisa(Editora obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
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

	public void exclui(Editora obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public Editora getEditoraAtual() {
		return editoraAtual;
	}

	public void setEditoraAtual(Editora editoraAtual) {
		this.editoraAtual = editoraAtual;
	}
	

}
