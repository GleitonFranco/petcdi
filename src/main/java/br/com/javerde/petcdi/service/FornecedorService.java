package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Fornecedor;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 15/01/16.
 */
@Path("/services/fornecedors")
@Produces(MediaType.APPLICATION_JSON)
public class FornecedorService extends GenericService<Fornecedor> {

	@GET
	public List<Fornecedor> obterTodos() {
		return findAll(Fornecedor.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Fornecedor> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Fornecedor.class));
//		PaginaTable<Fornecedor> p = new PaginaTable<>(1,5,numero,5,null);
//		return p;
//	}

	@GET
	@Path("{id}")
	public Fornecedor obterFornecedor(@PathParam("id") Integer id) {
		Fornecedor p = findById(id, Fornecedor.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Fornecedor> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Fornecedor> page = getPage(linhasPorPag, pagNum, Fornecedor.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarFornecedor(Fornecedor fornecedor) {
		salvarOuAtualizar(fornecedor);
	}

	@POST
	@Path("{id}")
	public void removerFornecedor(@PathParam("id") Integer id) {
		removeById(id, Fornecedor.class);
	}


}
