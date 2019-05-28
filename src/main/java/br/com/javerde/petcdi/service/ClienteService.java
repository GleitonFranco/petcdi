package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Cliente;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 23/09/18.
 */
@Path("/services/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteService extends GenericService<Cliente> {

	@GET
	public List<Cliente> obterTodos() {
		return findAll(Cliente.class);
	}

	@GET
	@Path("{id}")
	public Cliente obterCliente(@PathParam("id") Integer id) {
		Cliente p = findById(id, Cliente.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Cliente> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Cliente> page = getPage(linhasPorPag, pagNum, Cliente.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarCliente(Cliente fornecedor) {
		salvarOuAtualizar(fornecedor);
	}

	@POST
	@Path("{id}")
	public void removerCliente(@PathParam("id") Integer id) {
		removeById(id, Cliente.class);
	}


}
