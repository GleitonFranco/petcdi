package br.com.javerde.petcdi.entity;

import java.util.List;

/**
 * Created by gleiton on 29/02/16.
 */
public class PaginaTable<T> {
	public Integer pagNum;
	public Integer linhasPorPag;
	public Integer numPags;
	public Integer numLinhas;
	public Integer count;
	public List<T> linhas;
	public String filtro;

	public PaginaTable(Integer pagNum, Integer linhasPorPag, Integer numPags, Integer numLinhas, Integer count, List<T> linhas, String filtro) {
		this.pagNum = pagNum;
		this.linhasPorPag = linhasPorPag;
		this.numPags = numPags;
		this.numLinhas = numLinhas;
		this.count = count;
		this.linhas = linhas;
		this.filtro = filtro;
	}
}
