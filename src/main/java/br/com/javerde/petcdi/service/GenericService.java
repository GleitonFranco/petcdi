package br.com.javerde.petcdi.service;

import br.com.javerde.petcdi.entity.AbstractEntity;
import br.com.javerde.petcdi.entity.PaginaTable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;
import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericService<T extends AbstractEntity> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6408530368161321308L;

	@PersistenceContext
	public static EntityManager em;

	@Resource
	private UserTransaction userTransaction;


	public int count(Class<T> modelClass) {
		String sql = "select count(a) from "+modelClass.getName()+" a";
		TypedQuery<Number> q = em.createQuery(sql, Number.class);
		return q.getSingleResult().intValue();
	}

	public int numberOfPages(Integer linhasPorPag, int count) {
		return (int)Math.ceil(count/linhasPorPag);
	}

	public PaginaTable<T> getPage(Integer linhasPorPag, Integer paginaAtual, Class<T> modelClass) {
		return getPageOrderBy(linhasPorPag, paginaAtual, "", "", modelClass);
	}

	public PaginaTable<T> getPageOrderBy(Integer linhasPorPag, Integer paginaAtual,
			String campoOrd, String filtro, Class<T> modelClass) {
		int numberPages = numberOfPages(linhasPorPag, count(modelClass));
		Integer offset = linhasPorPag * (paginaAtual-1);
		String where = (filtro.isEmpty() || filtro.equals("undefined"))?"":" where descricao like \'%"+filtro+"%\'";

		String query = (campoOrd.isEmpty() || campoOrd == null)
				?
					"from "+modelClass.getName()
				:
					"select a from "+modelClass.getName()+" a"+where+" order by "+campoOrd;
		TypedQuery<T> t = em.createQuery(query, modelClass);

		Integer c = t.getResultList().size();
		t.setFirstResult(offset);
		t.setMaxResults(linhasPorPag);
		List<T> lista = t.getResultList();
		PaginaTable<T> page = new PaginaTable<>(paginaAtual,linhasPorPag,numberPages,lista.size(), c,lista, filtro);
		return page;
	}

	public void salvarOuAtualizar(T entidade) {
        T e2 = maiuscula(entidade);
        System.out.println(e2);
		try {
			userTransaction.begin();
		} catch (NotSupportedException notSupportedException) {
			notSupportedException.printStackTrace();
		} catch (SystemException systemException) {
			systemException.printStackTrace();
		} finally {
			if (entidade.getId() == null) {
				em.persist(e2);
			} else {
				em.merge(e2);
			}
			comita();
		}
	}

	protected List<T> findAll(Class<T> modelClass) {
		TypedQuery<T> q = em.createQuery("select a from "+modelClass.getName()+" a",modelClass);
		List<T> lista = q.getResultList();
		return lista;
	}
	
	protected T findById(Integer id,Class<T> modelClass) {
		String sql = "select a from "+modelClass.getName()+" a where a.id=:id";
		TypedQuery<T> q = em.createQuery(sql,modelClass);
		q.setParameter("id", id);
		return q.getSingleResult();
	}

	public void removeById(Integer id, Class<T> modelClass) {
		try {
			T entidade = em.getReference(modelClass, id);
			userTransaction.begin();
			em.remove(entidade);
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} finally {
			comita();
		}
	}

	public void comita() {
		try {
			userTransaction.commit();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public List<T> findLooksLike(String field, String key, Class<T> modelClass) {
		String sql = "select a from "+modelClass.getName()+" a where a."+field
				+" like :key order by "+field;
		TypedQuery<T> q = em.createQuery(sql, modelClass);
		q.setParameter("key", key);
		List<T> lista = q.getResultList();
		return lista;
	}

	public T maiuscula(T entidade) {
	    Class modelClass = entidade.getClass();
        Method[] metodos = modelClass.getDeclaredMethods();
	        for (Method m: metodos) {
            if (m.getName().startsWith("set") && m.getParameterTypes()[0].getName().equals("java.lang.String")) {
                String valor = m.getName().substring(3);
                List<Method> lista = Arrays.stream(metodos).filter( (mm) -> mm.getName().equals("get"+valor))
                        .collect(Collectors.toList());
                Method metodoGet = lista.get(0);
                try {
                	if (metodoGet.invoke(entidade) != null) {
						m.invoke(entidade, metodoGet.invoke(entidade).toString().toUpperCase());
					}
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return entidade;
    }

}
