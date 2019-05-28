package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ProdutoEstoque extends AbstractEntity {

	@OneToOne
	private Produto produto;
	
	private Double estoque;
	
}
