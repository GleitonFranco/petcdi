package br.com.javerde.petcdi.entity;

import javax.persistence.ManyToOne;

public class EnderecoCasa extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554281131666694416L;
//	@ManyToOne
	private Endereco endereco;
	private String complemento;
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
