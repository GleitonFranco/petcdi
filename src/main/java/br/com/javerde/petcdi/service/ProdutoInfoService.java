package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.PaginaTable;
import br.com.javerde.petcdi.entity.Produto;
import br.com.javerde.petcdi.entity.ProdutoInfo;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 08/06/16.
 */
@Path("/services/produtoinfos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoInfoService extends GenericService {

//	@Resource
//	ProdutoService produtoService;

	@GET
	public List<ProdutoInfo> obterTodos() {
		return findAll(ProdutoInfo.class);
	}

//	@GET
//	@Path("{id}")
//	public ProdutoInfo obterProdutoInfo(@PathParam("id") Integer id) {
//		TypedQuery<ProdutoInfo> q = em.createQuery("select a from ProdutoInfo a where a.id = "+id
//				,ProdutoInfo.class);
//		q.setParameter("id", id);
//		return q.getSingleResult();
//		return (ProdutoInfo)findById(produtoService.findById(id, Produto.class).getId(), ProdutoInfo.class);
//	}

	@POST
	public void salvarOuAtualizarProduto(ProdutoInfo produtoInfo) {
		salvarOuAtualizar(produtoInfo);
	}

}