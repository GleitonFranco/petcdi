package br.com.javerde.petcdi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Raca extends AbstractEntity implements Comparable<Raca>  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124604948530305391L;
	private String nome;
	@ManyToOne
	private Especie especie;
	
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
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
        return (object instanceof Raca) && (getId() != null) 
             ? getId().equals(((Raca) object).getId())
             : (object == this);
    }
	@Override
	public int compareTo(Raca raca) {
		return this.getNome().compareToIgnoreCase(raca.getNome());
	}
	
}
