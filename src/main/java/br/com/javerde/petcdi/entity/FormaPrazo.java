package br.com.javerde.petcdi.entity;

public enum FormaPrazo {
	VISTA(0,"À VISTA"),
	PRAZO(1,"A PRAZO");
	
	FormaPrazo(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	private int valor; 
	private String descricao;
	
	public int getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		String s="";
		switch (valor) {
			case 0: s = "À VISTA"; break;
			case 1: s = "A PRAZO"; break;
		}
		return s;
	}
}
