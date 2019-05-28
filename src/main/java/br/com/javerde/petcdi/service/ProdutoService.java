package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.PaginaTable;
import br.com.javerde.petcdi.entity.Produto;
import br.com.javerde.petcdi.entity.ProdutoInfo;

import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gleiton on 15/01/16.
 */
@Path("/services/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoService extends GenericService {

	@GET
	public List<Produto> obterTodos() {
		return findAll(Produto.class);
	}

//	@GET
//	@Path("paginas/{linhasPorPag}")
//	public PaginaTable<Produto> numeroPaginas(@PathParam("linhasPorPag") Integer linhasPorPag) {
//		int numero = numberOfPages(linhasPorPag, count(Produto.class));
//		PaginaTable<Produto> p = new PaginaTable<>(1,5,numero,5,null);
//		return p;
//	}

	@GET
	@Path("{id}")
	public Produto obterProduto(@PathParam("id") Integer id) {
		Produto p = (Produto)findById(id, Produto.class);
		return p;
	}

	@GET
	@Path("{pagNum}/{linhasPorPag}")
	public PaginaTable<Produto> obterPaginaOrdenada(@PathParam("pagNum") Integer pagNum, @PathParam("linhasPorPag") Integer linhasPorPag
	, @QueryParam("filtro") String filtro) {//, Integer pagTot, Integer linhas

		PaginaTable<Produto> page = null;
		System.out.println("***** Filtro:"+filtro);
		if (filtro == null) filtro = "";
		page = getPageOrderBy(linhasPorPag, pagNum, "descricao", filtro, Produto.class);
		return page;
	}

	@GET
	@Path("barra/{barra}")
	public List<Produto> filterByBarra(@PathParam("barra") String barra) {
		String sql = "select a from "+Produto.class +" a where a.barra='"+barra+"'";
		TypedQuery<Produto> q = em.createQuery(sql,Produto.class);
		return q.getResultList();
	}

	@GET
	@Path("barraunico/{barra}")
	public Produto findByBarra(@PathParam("barra") String barra) {
		String sql = "select a from "+Produto.class +" a where a.barra='"+barra+"'";
		TypedQuery<Produto> q = em.createQuery(sql,Produto.class);
		return q.getSingleResult();
	}

	@GET
	@Path("look/{field}/{key}")
	public List<Produto> filterByNome(@PathParam("key") String key, @PathParam("field") String field) {
		List<Produto> lista = findLooksLike(field, key+"%", Produto.class);
		return lista;
	}

	@POST
	public void salvarOuAtualizarProduto(Produto produto) {
		salvarOuAtualizar(produto);
	}

	@POST
	@Path("{id}")
	public void removerProduto(@PathParam("id") Integer id) {
		removeById(id, Produto.class);
	}

	@GET
	@Path("info/{id}")
	public ProdutoInfo obterProdutoInfo(@PathParam("id") Integer id) {
//		Produto p = obterProduto(id);
		TypedQuery<ProdutoInfo> q = em.createQuery("select a from ProdutoInfo a where a.produto.id = :id"
				,ProdutoInfo.class);
		q.setParameter("id", id);
		return q.getSingleResult();
	}

}
