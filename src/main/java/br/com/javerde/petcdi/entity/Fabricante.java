package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;

@Entity
public class Fabricante extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8835488744186534640L;
	private String fantasia;
	private String razao;
	private String cnpj;
	private String site;
	
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
