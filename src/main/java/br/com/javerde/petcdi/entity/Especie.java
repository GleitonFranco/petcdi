package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;

@Entity
public class Especie extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8454607206226407617L;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object object) {
        return (object instanceof Especie) && (getId() != null) 
             ? getId().equals(((Especie) object).getId()) 
             : (object == this);
    }
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
