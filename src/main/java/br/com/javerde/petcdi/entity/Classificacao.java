package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Classificacao extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1722622081116411998L;
	@ManyToOne
	private Classificacao pai;
	private String nome;
	public Classificacao getPai() {
		return pai;
	}
	public void setPai(Classificacao pai) {
		this.pai = pai;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
