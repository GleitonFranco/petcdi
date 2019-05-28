package br.com.javerde.petcdi.entity;

public enum FormaPagamento {
	DINHEIRO(0,"DD"),
	CARTAO_DEBITO(1,"DV"),
	CARTAO_CREDITO(2,"CV"),
	CARTAO_CREDITO_PARCELADO(3,"CP"),
	PRAZO(4,"FP"),
	CONVENIO(5,"CO"),
	CHEQUE(6,"CH");
	
	FormaPagamento(int valor, String abrev) {
		this.valor = valor;
		this.abrev = abrev;
	}
	
	private int valor; 
	private String abrev;
	
	public int getValor() {
		return valor;
	}
	
	public String getAbrev() {
		return abrev;
	}
	
	@Override
	public String toString() {
		String s="";
		switch (valor) {
			case 0: s = "DINHEIRO"; break;
			case 1: s = "CARTÃO DE DÉBITO"; break;
			case 2: s = "CARTÃO DE CRÉDITO"; break;
			case 3: s = "CARTÃO DE CRÉDITO PARCELADO"; break;
			case 4: s = "A PRAZO"; break;
			case 5: s = "CONVÊNIO"; break;
			case 6: s = "CHEQUE"; break;
		}
		return s;
	}
}

