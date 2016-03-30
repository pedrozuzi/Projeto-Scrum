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
public class LivroMB implements Serializable {
	private static final long serialVersionUID = -6883059046573310496L;
	private Livro  livroatual;
	private LivroDao lDao;
	
	
	
	public LivroMB(){
		livroatual = new Livro();
		lDao = new LivroDaoImpl();
	}
	
	
	

}
