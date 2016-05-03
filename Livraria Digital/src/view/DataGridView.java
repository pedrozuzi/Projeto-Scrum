package view;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import control.LivroMB;
import exception.GenericException;
import model.Livro;
import persistence.PesquisaDaoImpl;


@ManagedBean(name = "dataGridView")
//@SessionScoped
@ApplicationScoped
public class DataGridView implements Serializable {
	private static final long serialVersionUID = 7659498095569980364L;

	private List<Livro> livros;
	private Livro selectedLivro;
	private String busca;
	private int categoria;
	private String parametroPesquisa;

	@ManagedProperty("#{livroMB}")
	private LivroMB livromb;

	@PostConstruct
	public void init() {
		// primeira pagina
		try {
			livros = livromb.pesquisar();
		//	System.out.println(livros.size());
		} catch (GenericException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buscarLivro(String parametro) {
		PesquisaDaoImpl p = new PesquisaDaoImpl();
		try {
			if (parametroPesquisa.equalsIgnoreCase("título")) {
				livros = p.pesquisaPorTitulo(parametro);
			}else if (parametroPesquisa.equalsIgnoreCase("autor")) {
				livros = p.pesquisaPorAutor(parametro);
			}else if (parametroPesquisa.equalsIgnoreCase("editora")) {
				livros = p.pesquisaPorEditora(parametro);
			}else if (parametroPesquisa.equalsIgnoreCase("categoria")) {
				livros = p.pesquisaPorCategoria(parametro);
			}else{
				livros = p.pesquisaPorTitulo(parametro);
			}
			
		} catch (GenericException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}



}