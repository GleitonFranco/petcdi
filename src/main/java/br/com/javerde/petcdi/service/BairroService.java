package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Bairro;
import br.com.javerde.petcdi.entity.Fornecedor;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 23/09/18.
 */
@Path("/services/bairros")
@Produces(MediaType.APPLICATION_JSON)
public class BairroService extends GenericService<Bairro> {

	@GET
	public List<Bairro> obterTodos() {
		return findAll(Bairro.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Bairro> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Bairro.class));
//		PaginaTable<Bairro> p = new PaginaTable<>(1,5,numero,5,null);
//		return p;
//	}

	@GET
	@Path("{id}")
	public Bairro obterBairro(@PathParam("id") Integer id) {
		Bairro p = findById(id, Bairro.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Bairro> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Bairro> page = getPage(linhasPorPag, pagNum, Bairro.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarBairro(Bairro fornecedor) {
		salvarOuAtualizar(fornecedor);
	}

	@POST
	@Path("{id}")
	public void removerBairro(@PathParam("id") Integer id) {
		removeById(id, Bairro.class);
	}


}
