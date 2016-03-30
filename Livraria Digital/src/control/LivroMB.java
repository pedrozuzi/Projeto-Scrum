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
import exception.LivroDaoException;
import model.Editora;
import model.Livro;
import persistence.GenericDao;
import persistence.LivroDao;
import persistence.LivroDaoImpl;

@ManagedBean
@ViewScoped
public class LivroMB implements Serializable {
	private static final long serialVersionUID = -6883059046573310496L;
	private Livro  livroAtual;
	private LivroDao lDao;
	
	
	
	public LivroMB(){
		livroAtual = new Livro();
		lDao = new LivroDaoImpl();
	}
	
	public void inclui()throws GenericException, SQLException{
		String msg="Erro ao cadastrar!";
		try {
			lDao.inclui(livroAtual);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (LivroDaoException lx) {
			lx.printStackTrace();
		}
	}
	
	
	public List<?> pesquisa(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void altera() throws GenericException, SQLException {
		
		String msg="Erro ao Alterar!";
	try{	
		lDao.altera(livroAtual);
		msg = "Alteração realizada com sucesso!";
		FacesContext fc= FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));
	}catch(EditoraDaoException ex){	
		ex.printStackTrace();
	 }
	}

	public void exclui(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public Livro getLivroAtual() {
		return livroAtual;
	}

	public void setLivroAtual(Livro livroatual) {
		this.livroAtual = livroatual;
	}

}
