package br.com.javerde.petcdi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533014734676808057L;

	@Id @GeneratedValue
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	protected Integer valorNaoNulo(Integer valor) {
		return (valor==null) ? 0 : valor;
	}

	protected Double valorNaoNulo(Double valor) {
		return (valor==null) ? 0d : valor;
	}

	protected BigDecimal valorNaoNulo(BigDecimal valor) {
		return (valor==null) ? BigDecimal.ZERO : valor;
	}

	protected Boolean valorNaoNulo(Boolean valor) {
		return (valor==null) ? false : valor;
	}

	protected String valorNaoNulo(String valor) {
		return (valor==null) ? "" : valor;
	}

}
