package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6477369722466778292L;
	private String fantasia;
	private String razao;
	private String cnpj;
	private String inscricaoEstadual;
	private Endereco endereco;
	private String complemento;
	private String site;


	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco enderecoCasa) {
		this.endereco = enderecoCasa;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public boolean equals(Object object) {
        return (object instanceof Fornecedor) && (getId() != null) 
             ? getId().equals(((Fornecedor) object).getId()) 
             : (object == this);
    }

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
