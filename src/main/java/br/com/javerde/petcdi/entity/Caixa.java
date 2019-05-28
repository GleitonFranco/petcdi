package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Caixa extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3771466484590588464L;
	private Date inicio;
	private Date fim;
	private Boolean fechada;
	private Double fundoCaixa;
	private Double dinheiroIni;
	private Double dinheiroFim;
	private Double cartaoDebitoIni;
	private Double cartaoDebitoFim;
	private Double cartaoVistaIni;
	private Double cartaoVistaFim;
	private Double cartaoPrazoIni;
	private Double cartaoPrazoFim;
	private Double chequeVistaIni;
	private Double chequeVistaFim;
	private Double chequePreIni;
	private Double chequePreFim;
	private Double valeIni;
	private Double valeFim;
	private Double totalEsperado;
	private Double totalReal;
	private Double diferenca;

	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public Boolean getFechada() {
		return fechada;
	}
	public void setFechada(Boolean fechada) {
		this.fechada = fechada;
	}
	public Double getDinheiroIni() {
		return valorNaoNulo(dinheiroIni);
	}
	public void setDinheiroIni(Double dinheiroIni) {
		this.dinheiroIni = dinheiroIni;
	}
	public Double getDinheiroFim() {
		return valorNaoNulo(dinheiroFim);
	}
	public void setDinheiroFim(Double dinheiroFim) {
		this.dinheiroFim = dinheiroFim;
	}
	public Double getCartaoDebitoIni() {
		return valorNaoNulo(cartaoDebitoIni);
	}
	public void setCartaoDebitoIni(Double cartaoDebitoIni) {
		this.cartaoDebitoIni = cartaoDebitoIni;
	}
	public Double getCartaoDebitoFim() {
		return valorNaoNulo(cartaoDebitoFim);
	}
	public void setCartaoDebitoFim(Double cartaoDebitoFim) {
		this.cartaoDebitoFim = cartaoDebitoFim;
	}
	public Double getCartaoVistaIni() {
		return valorNaoNulo(cartaoVistaIni);
	}
	public void setCartaoVistaIni(Double cartaoVistaIni) {
		this.cartaoVistaIni = cartaoVistaIni;
	}
	public Double getCartaoVistaFim() {
		return valorNaoNulo(cartaoVistaFim);
	}
	public void setCartaoVistaFim(Double cartaoVistaFim) {
		this.cartaoVistaFim = cartaoVistaFim;
	}
	public Double getCartaoPrazoIni() {
		return valorNaoNulo(cartaoPrazoIni);
	}
	public void setCartaoPrazoIni(Double cartaoPrazoIni) {
		this.cartaoPrazoIni = cartaoPrazoIni;
	}
	public Double getCartaoPrazoFim() {
		return valorNaoNulo(cartaoPrazoFim);
	}
	public void setCartaoPrazoFim(Double cartaoPrazoFim) {
		this.cartaoPrazoFim = cartaoPrazoFim;
	}
	public Double getChequeVistaIni() {
		return valorNaoNulo(chequeVistaIni);
	}
	public void setChequeVistaIni(Double chequeVistaIni) {
		this.chequeVistaIni = chequeVistaIni;
	}
	public Double getChequeVistaFim() {
		return valorNaoNulo(chequeVistaFim);
	}
	public void setChequeVistaFim(Double chequeVistaFim) {
		this.chequeVistaFim = chequeVistaFim;
	}
	public Double getChequePreIni() {
		return valorNaoNulo(chequePreIni);
	}
	public void setChequePreIni(Double chequePreIni) {
		this.chequePreIni = chequePreIni;
	}
	public Double getChequePreFim() {
		return valorNaoNulo(chequePreFim);
	}
	public void setChequePreFim(Double chequePreFim) {
		this.chequePreFim = chequePreFim;
	}
	public Double getValeIni() {
		return valorNaoNulo(valeIni);
	}
	public void setValeIni(Double valeIni) {
		this.valeIni = valeIni;
	}
	public Double getValeFim() {
		return valorNaoNulo(valeFim);
	}
	public void setValeFim(Double valeFim) {
		this.valeFim = valeFim;
	}
	public Double getTotalReal() {
		return valorNaoNulo(totalReal);
	}
	public void setTotalReal(Double totalReal) {
		this.totalReal = totalReal;
	}
	public Double getFundoCaixa() {
		return valorNaoNulo(fundoCaixa);
	}
	public void setFundoCaixa(Double fundoCaixa) {
		this.fundoCaixa = fundoCaixa;
	}
	public Double getTotalEsperado() {
		return valorNaoNulo(totalEsperado);
	}
	public void setTotalEsperado(Double totalEsperado) {
		this.totalEsperado = totalEsperado;
	}
	public Double getDiferenca() {
		return valorNaoNulo(diferenca);
	}
	public void setDiferenca(Double diferenca) {
		this.diferenca = diferenca;
	}

}
