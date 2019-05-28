package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Endereco extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6336709190418100065L;
	private String tipo	;
	private String logradouro;
	@ManyToOne
	private Bairro bairro;
	private String numero;
	private String cep;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
