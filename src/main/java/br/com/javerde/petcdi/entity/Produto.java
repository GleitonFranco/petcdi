package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Produto extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1519948752797076281L;
	private String barra;
	private String descricao;
	private String resumo;
	@ManyToOne
	private Fabricante fabricante;
	private String medida;
	private BigDecimal estoque;
	private BigDecimal prCompra;
	private BigDecimal prVenda;
	@ManyToOne
	private Classificacao classificacao;
	@ManyToOne
	private GrupoFisico grupo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date validade;
	private Boolean ativado;

	public String getBarra() {
		return valorNaoNulo(barra);
	}
	public void setBarra(String barra) {
		this.barra = barra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public BigDecimal getPrCompra() {
		return valorNaoNulo(prCompra);
	}
	public void setPrCompra(BigDecimal prCompra) {
		this.prCompra = prCompra;
	}
	public BigDecimal getPrVenda() {
		return valorNaoNulo(prVenda);
	}
	public void setPrVenda(BigDecimal prVenda) {
		this.prVenda = prVenda;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Boolean getAtivado() {
		return ativado;
	}
	public void setAtivado(Boolean ativado) {
		this.ativado = ativado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public BigDecimal getEstoque() {
		return valorNaoNulo(estoque);
	}
	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return ((Produto)obj).getId().equals(this.getId());
	}

}
