package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class VendaItem extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4038390551786836202L;
	@ManyToOne
	private Venda venda;
	@ManyToOne
	private Produto produto;
	private Integer qtde;
	private Double prUnit;
	private Double desconto;
	private Double icms;
	private Double custoMedio;
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQtde() {
		return valorNaoNulo(qtde);
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Double getPrUnit() {
		return valorNaoNulo(prUnit);
	}
	public void setPrUnit(Double prUnit) {
		this.prUnit = prUnit;
	}
	public Double getDesconto() {
		return valorNaoNulo(desconto);
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getIcms() {
		return valorNaoNulo(icms);
	}
	public void setIcms(Double icms) {
		this.icms = icms;
	}
	public Double getCustoMedio() {
		return valorNaoNulo(custoMedio);
	}
	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}
	
}
