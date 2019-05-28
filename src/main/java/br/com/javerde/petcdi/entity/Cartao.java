package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Cartao extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2144201436768952875L;
	private String nome;
	private Boolean debito;
	private Double juros;
	private Integer parcelasMax;
	private Integer diaRecebimento;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getDebito() {
		return valorNaoNulo(debito);
	}
	public void setDebito(Boolean debito) {
		this.debito = debito;
	}
	public Double getJuros() {
		return valorNaoNulo(juros);
	}
	public void setJuros(Double juros) {
		this.juros = juros;
	}
	public Integer getParcelasMax() {
		return parcelasMax;
	}
	public void setParcelasMax(Integer parcelasMax) {
		this.parcelasMax = parcelasMax;
	}
	public Integer getDiaRecebimento() {
		return diaRecebimento;
	}
	public void setDiaRecebimento(Integer diaRecebimento) {
		this.diaRecebimento = diaRecebimento;
	}
	@Override
	public boolean equals(Object object) {
        return (object instanceof Cartao) && (getId() != null) 
             ? getId().equals(((Cartao) object).getId()) 
             : (object == this);
    }
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
