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
import persistence.GenericDao;

@ManagedBean
@ViewScoped
public class EditoraMB implements Serializable, GenericDao<Editora> {
	private static final long serialVersionUID = -2359826975327120781L;
	
	private Editora editoraAtual;
	private EditoraDao eDao;
	
	public EditoraMB() {
		editoraAtual = new Editora();
		eDao = new EditoraDaoImpl();
	}
	
	@Override
	public void inclui(Editora e) throws GenericException, SQLException { //TALVEZ void NÃO FUNCIONE
		String msg="Erro ao cadastrar!";
		try {
			eDao.inclui(e);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (EditoraDaoException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<?> pesquisa(Editora obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Editora e) throws GenericException, SQLException {
		
		String msg="Erro ao Alterar!";
	try{	
		eDao.altera(e);
		msg = "Alteração realizada com sucesso!";
		FacesContext fc= FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));
	}catch(EditoraDaoException ex){	
		ex.printStackTrace();
	 }
	}
	@Override
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
