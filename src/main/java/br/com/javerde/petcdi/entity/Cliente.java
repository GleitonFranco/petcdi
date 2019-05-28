package br.com.javerde.petcdi.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7449516023648514859L;
	private String nome;
	private Endereco endereco;
	private String complemento;
	private Double limiteCredito;
	private Double credito;
	private Date   dataCadastro;
	private Date   dataUltPag;
	private Date   dataUltCom;
	@OneToMany
	private List<Animal> animais = new ArrayList<>();
	@ElementCollection
	private List<String> fones;
	@ElementCollection
	private List<String> emails;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataUltPag() {
		return dataUltPag;
	}
	public void setDataUltPag(Date dataUltPag) {
		this.dataUltPag = dataUltPag;
	}
	public Date getDataUltCom() {
		return dataUltCom;
	}
	public void setDataUltCom(Date dataUltCom) {
		this.dataUltCom = dataUltCom;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Animal> getAnimais() {
		return (animais==null?new ArrayList<Animal>():animais);
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<String> getFones() {
		return fones;
	}

	public void setFones(List<String> fones) {
		this.fones = fones;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
}
