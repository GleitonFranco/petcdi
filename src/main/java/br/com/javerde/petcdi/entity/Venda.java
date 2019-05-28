package br.com.javerde.petcdi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venda extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4049854825536865007L;
	private Date data;
	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL)
	private List<Pagamento> pagamentos;
	@ManyToOne
	private Cliente cliente;
	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL)
	private List<VendaItem> itens;
	private Double cusTotal;
	private Double venTotal;
	private Double desTotal;
	private Double venTotalLiq;

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getCusTotal() {
		return valorNaoNulo(cusTotal);
	}
	public void setCusTotal(Double cusTotal) {
		this.cusTotal = cusTotal;
	}
	public Double getVenTotal() {
		return valorNaoNulo(venTotal);
	}
	public void setVenTotal(Double venTotal) {
		this.venTotal = venTotal;
	}
	public Double getDesTotal() {
		return valorNaoNulo(desTotal);
	}
	public void setDesTotal(Double desTotal) {
		this.desTotal = desTotal;
	}
	public Double getVenTotalLiq() {
		return valorNaoNulo(venTotalLiq);
	}
	public void setVenTotalLiq(Double venTotalLiq) {
		this.venTotalLiq = venTotalLiq;
	}
	public List<Pagamento> getPagamentos() {
		if(pagamentos == null) {
			pagamentos = new ArrayList<Pagamento>();
		}
		return pagamentos;
	}
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	public List<VendaItem> getItens() {
		if (itens == null) {
			itens = new ArrayList<VendaItem>(); 
		}
		return itens;
	}
	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}

}
