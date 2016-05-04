package model;

import java.util.Date;

/**
 * Classe que representa o Autor do livro
 * @author hury
 *
 */
public class Autor {
	private int id;
	private String nome;
	private Date datanasc;
	private Date datafale;
	private String localmorte;
	private String biografia;

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public Date getDatafale() {
		return datafale;
	}

	public void setDatafale(Date datafale) {
		this.datafale = datafale;
	}

	public String getLocalmorte() {
		return localmorte;
	}

	public void setLocalmorte(String localmorte) {
		this.localmorte = localmorte;
	}

}
