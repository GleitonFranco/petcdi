package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;

@Entity
public class Bairro extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1937866513045750913L;
	private String nome;
	private String cidade;
	private String uf;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
