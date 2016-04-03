package view;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import control.LivroMB;
import exception.GenericException;
import model.Livro;


@ManagedBean(name = "dataGridView")
@SessionScoped
// @ViewScoped
public class DataGridView implements Serializable {
	private static final long serialVersionUID = 7659498095569980364L;

	private List<Livro> livros;

	private Livro selectedLivro;

	private String busca;

	private int categoria;

	@ManagedProperty("#{livroMB}")
	private LivroMB livromb;

	@PostConstruct
	public void init() {
		// primeira pagina
		try {
			livros = livromb.pesquisar();
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String pagPrincipal() {
		try {
			livros = livromb.pesquisar();
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
		return "index";
	}
	

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getSelectedLivro() {
		return selectedLivro;
	}

	public void setSelectedLivro(Livro selectedLivro) {
		this.selectedLivro = selectedLivro;
	}

	public LivroMB getLivromb() {
		return livromb;
	}

	public void setLivromb(LivroMB livromb) {
		this.livromb = livromb;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



}