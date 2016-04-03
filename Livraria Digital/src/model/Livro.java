package model;

import java.util.List;

/**
 * 
 * @author 
 *
 */

public class Livro {

	private int id;
	private List<Autor> autor;
	private List<Editora> editora;
	private String titulo;
	private int isbn;
	private int paginas;
	private int edicao;
	private String tipoCapa;
	private int ano;
	private String assunto;
	private String idioma;
	private String imagem;
	private Double preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getTipoCapa() {
		return tipoCapa;
	}
	public void setTipoCapa(String tipoCapa) {
		this.tipoCapa = tipoCapa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<Autor> getAutor() {
		return autor;
	}
	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	public List<Editora> getEditora() {
		return editora;
	}
	public void setEditora(List<Editora> editora) {
		this.editora = editora;
	}
	
	
}
