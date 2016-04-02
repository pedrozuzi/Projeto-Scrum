package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import exception.EditoraDaoException;
import exception.GenericException;
import exception.LivroDaoException;
import model.Autor;
import model.Editora;
import model.Livro;
import persistence.AutorDaoImpl;
import persistence.GenericDao;
import persistence.LivroDao;
import persistence.LivroDaoImpl;

/**
 * 
 * @author Classe responsavel pelo controle do objeto livro
 */

@ManagedBean
@ViewScoped
public class LivroMB extends GenericBean<Livro> {
	private static final long serialVersionUID = -6883059046573310496L;

	public LivroMB() {
		super.listaPesquisa = new ArrayList<Livro>();
		super.objAtual = new Livro();
		super.dao = new LivroDaoImpl();
		super.selectedObj = new Livro();
	}

	@Override
	public void inclui() throws GenericException, SQLException {
		String msg = "Erro ao cadastrar!";
		try {
			dao.inclui(objAtual);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
		} catch (LivroDaoException lx) {
			lx.printStackTrace();
		}
	}

	@Override
	public void altera(Livro selectedObj) throws GenericException, SQLException {

		String msg = "Erro ao Alterar!";
		try {
			dao.altera(objAtual);
			msg = "Alteração realizada com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(msg));
		} catch (EditoraDaoException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Pesquisa Todos os livros na DB
	 */
	@Override
	public List<Livro> pesquisar() throws GenericException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Pesquisa um determinado livro pelo titulo
	 * @return
	 */
	public List<Livro> pesquisarTitulo(){
		
		return null;
	}
	
	/**
	 * Pesquisa uma determinada relação de livros com uma editora
	 * @return
	 */
	
	public List<Livro> pesquisarEditora(){
		
		return null;
	}
	
	/**
	 * Pesquisa livros por categorias
	 * @return
	 */
	public List<Livro> pesquisarCategoria(){
		
		return null;
	}
	
	/**
	 * Pesquisa livros por autores
	 * @return
	 */
	public List<Livro> pesquisarAutor(){
		
		return null;
	}

	/**
	 * Exclui um determinado livro do banco de dados
	 */
	@Override
	public void exclui(Livro selectedObj) throws GenericException, SQLException {
		// TODO Auto-generated method stub

	}

}
