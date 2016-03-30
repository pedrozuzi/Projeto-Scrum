package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import exception.GenericException;
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
	public void inclui(Livro obj) throws GenericException, SQLException {
		// TODO Auto-generated method stub
		
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
