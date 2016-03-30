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
import model.Livro;
import persistence.GenericDao;
import persistence.LivroDao;
import persistence.LivroDaoImpl;

@ManagedBean
@ViewScoped
public class LivroMB implements Serializable, GenericDao<Livro> {
	private static final long serialVersionUID = -6883059046573310496L;
	private Livro  livroatual;
	private LivroDao lDao;
	
	
	
	public LivroMB(){
		livroatual = new Livro();
		lDao = new LivroDaoImpl();
	}
	

	@Override
	public void inclui(Livro l) throws GenericException, SQLException {
		String msg="Erro ao cadastrar!";
		try {
			lDao.inclui(l);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
		} catch (LivroDaoException lx) {
			lx.printStackTrace();
		}
	}

	@Override
	public List<?> pesquisa(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
