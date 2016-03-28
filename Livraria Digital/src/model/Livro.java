package model;

import java.util.Date;

public class Livro {

	private String isbn;
	private String titulo;
	private Date dataPublicacao;
	private String tipoCapa;
	private String edicao;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getTipoCapa() {
		return tipoCapa;
	}
	public void setTipoCapa(String tipoCapa) {
		this.tipoCapa = tipoCapa;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	
}
