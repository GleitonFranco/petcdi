package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pagamento extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5824886264689116801L;
	@ManyToOne
	private Venda venda;
	@ManyToOne
	private Caixa caixa;
	private Date dataPagamento;
	private FormaPrazo formaPrazo;
	private FormaPagamento formaPagamento;
	@ManyToOne
	private Cartao cartao;
	private Integer numeroParcelas;
	private Boolean pago;
	private Double valor;

	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public FormaPrazo getFormaPrazo() {
		return formaPrazo;
	}
	public void setFormaPrazo(FormaPrazo formaPrazo) {
		this.formaPrazo = formaPrazo;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
