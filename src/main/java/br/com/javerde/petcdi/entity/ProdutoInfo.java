package br.com.javerde.petcdi.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ProdutoInfo extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2912114317430137848L;
	@OneToOne(cascade = CascadeType.ALL)
	private Produto produto;
	@ManyToOne
	private Fornecedor fornecedor;
	private String abcEstoque;
	private BigDecimal abcEstoqueValor;
	private String abcVenda;
	private BigDecimal abcVendaValor;
	private BigDecimal estoqueMin;
	private BigDecimal estoqueMax;
	private BigDecimal estoqueMed;
	private BigDecimal custoMedio;
	private BigDecimal margem;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltCompra;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltVenda;
	private BigDecimal consumoMedioMensal;
	private String ncmClassFiscal;
	private BigDecimal aliqIcms;
	private BigDecimal aliqIpi;

	public Produto getProduto() { return this.produto; }

	public void setProduto(Produto produto) { this.produto = produto; }

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(BigDecimal estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	public BigDecimal getEstoqueMax() {
		return estoqueMax;
	}

	public void setEstoqueMax(BigDecimal estoqueMax) {
		this.estoqueMax = estoqueMax;
	}

	public BigDecimal getEstoqueMed() {
		return estoqueMed;
	}

	public void setEstoqueMed(BigDecimal estoqueMed) {
		this.estoqueMed = estoqueMed;
	}

	public BigDecimal getCustoMedio() {
		return custoMedio;
	}

	public void setCustoMedio(BigDecimal custoMedio) {
		this.custoMedio = custoMedio;
	}

	public BigDecimal getMargem() {
		return margem;
	}

	public void setMargem(BigDecimal margem) {
		this.margem = margem;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataUltCompra() {
		return dataUltCompra;
	}

	public void setDataUltCompra(Date dataUltCompra) {
		this.dataUltCompra = dataUltCompra;
	}

	public Date getDataUltVenda() {
		return dataUltVenda;
	}

	public void setDataUltVenda(Date dataUltVenda) {
		this.dataUltVenda = dataUltVenda;
	}

	public BigDecimal getConsumoMedioMensal() {
		return consumoMedioMensal;
	}

	public void setConsumoMedioMensal(BigDecimal consumoMedioMensal) {
		this.consumoMedioMensal = consumoMedioMensal;
	}

	public String getNcmClassFiscal() {
		return ncmClassFiscal;
	}

	public void setNcmClassFiscal(String ncmClassFiscal) {
		this.ncmClassFiscal = ncmClassFiscal;
	}

	public BigDecimal getAliqIcms() {
		return aliqIcms;
	}

	public void setAliqIcms(BigDecimal aliqIcms) {
		this.aliqIcms = aliqIcms;
	}

	public BigDecimal getAliqIpi() {
		return aliqIpi;
	}

	public void setAliqIpi(BigDecimal aliqIpi) {
		this.aliqIpi = aliqIpi;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAbcEstoque() {
		return abcEstoque;
	}

	public void setAbcEstoque(String abcEstoque) {
		this.abcEstoque = abcEstoque;
	}

	public BigDecimal getAbcEstoqueValor() {
		return abcEstoqueValor;
	}

	public void setAbcEstoqueValor(BigDecimal abcEstoqueValor) {
		this.abcEstoqueValor = abcEstoqueValor;
	}

	public String getAbcVenda() {
		return abcVenda;
	}

	public void setAbcVenda(String abcVenda) {
		this.abcVenda = abcVenda;
	}

	public BigDecimal getAbcVendaValor() {
		return abcVendaValor;
	}

	public void setAbcVendaValor(BigDecimal abcVendaValor) {
		this.abcVendaValor = abcVendaValor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return ((ProdutoInfo)obj).getId().equals(this.getId());
	}

}
