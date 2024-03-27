package br.com.bukiapi.buki.model.repositores;

import org.springframework.data.repository.CrudRepository;

import br.com.bukiapi.buki.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
