package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Fabricante;
import br.com.javerde.petcdi.entity.Fornecedor;
import br.com.javerde.petcdi.entity.Produto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by gleiton on 03/05/17.
 */
@XmlRootElement
public class EuOdeioRootNoJson {
	Produto produto;
	Fabricante fabricante;
	Fornecedor fornecedor;

	public EuOdeioRootNoJson() {

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
