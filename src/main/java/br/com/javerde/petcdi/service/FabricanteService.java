package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Fabricante;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 15/01/16.
 */
@Path("/services/fabricantes")
@Produces(MediaType.APPLICATION_JSON)
public class FabricanteService extends GenericService<Fabricante> {

	@GET
	public List<Fabricante> obterTodos() {
		return findAll(Fabricante.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Fabricante> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Fabricante.class));
//		PaginaTable<Fabricante> p = new PaginaTable<>(1,5,numero,5,null);
//		return p;
//	}

	@GET
	@Path("{id}")
	public Fabricante obterFabricante(@PathParam("id") Integer id) {
		Fabricante p = findById(id, Fabricante.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Fabricante> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Fabricante> page = getPage(linhasPorPag, pagNum, Fabricante.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarFabricante(Fabricante fabricante) {
		salvarOuAtualizar(fabricante);
	}

	@POST
	@Path("{id}")
	public void removerFabricante(@PathParam("id") Integer id) {
		removeById(id, Fabricante.class);
	}


}
