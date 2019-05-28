package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.PaginaTable;
import br.com.javerde.petcdi.entity.Venda;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 15/01/16.
 */
@Path("/services/vendas")
@Produces(MediaType.APPLICATION_JSON)
public class VendaService extends GenericService<Venda> {

	@GET
	public List<Venda> obterTodos() {
		return findAll(Venda.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Venda> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Venda.class));
//		PaginaTable<Venda> p = new PaginaTable<>(1,5,numero,5,null, count(Venda.class));
//		return p;
//		return Math.ceil(count(Venda.class)/linhasPorPag);
//	}

	@GET
	@Path("{id}")
	public Venda obterVenda(@PathParam("id") Integer id) {
		Venda p = findById(id, Venda.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Venda> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Venda> page = getPage(linhasPorPag, pagNum, Venda.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarVenda(EuOdeioRootNoJson euOdeioRootNoJson) {
//		Venda fornecedor = euOdeioRootNoJson.venda;
//		salvarOuAtualizar(fornecedor);
	}

	@POST
	@Path("{id}")
	public void removerVenda(@PathParam("id") Integer id) {
		removeById(id, Venda.class);
	}


}
