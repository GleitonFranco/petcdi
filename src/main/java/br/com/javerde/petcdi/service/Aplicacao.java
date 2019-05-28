package br.com.javerde.petcdi.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gleiton on 15/01/16.
 */
//@ApplicationPath("services")
public class Aplicacao extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ProdutoService.class);
        classes.add(FabricanteService.class);
        classes.add(FornecedorService.class);
        classes.add(VendaService.class);
        classes.add(ProdutoInfoService.class);
        classes.add(BairroService.class);
        classes.add(EnderecoService.class);
        classes.add(ClienteService.class);
        return classes;
    }
}
