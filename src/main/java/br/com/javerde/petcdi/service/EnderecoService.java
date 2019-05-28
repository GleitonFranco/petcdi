package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.Bairro;
import br.com.javerde.petcdi.entity.Endereco;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 23/09/18.
 */
@Path("/services/enderecos")
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoService extends GenericService<Endereco> {

	@GET
	public List<Endereco> obterTodos() {
		return findAll(Endereco.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Endereco> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Endereco.class));
//		PaginaTable<Endereco> p = new PaginaTable<>(1,5,numero,5,null);
//		return p;
//	}

	@GET
	@Path("{id}")
	public Endereco obterEndereco(@PathParam("id") Integer id) {
		Endereco p = findById(id, Endereco.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Endereco> obterPagina(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag) {
		PaginaTable<Endereco> page = getPage(linhasPorPag, pagNum, Endereco.class);
		return page;
	}

	@POST
	public void salvarOuAtualizarEndereco(Endereco fornecedor) {
		salvarOuAtualizar(fornecedor);
	}

	@POST
	@Path("{id}")
	public void removerEndereco(@PathParam("id") Integer id) {
		removeById(id, Endereco.class);
	}

}
