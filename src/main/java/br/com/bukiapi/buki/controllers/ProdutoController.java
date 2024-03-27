package br.com.bukiapi.buki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bukiapi.buki.model.entities.Produto;
import br.com.bukiapi.buki.model.repositores.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public Produto novoProduto(@RequestParam(name = "name") String name) {
		Produto produto = new Produto(name);
		produtoRepository.save(produto);
		return produto;
	}
	
}
