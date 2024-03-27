package br.com.bukiapi.buki.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bukiapi.buki.model.entities.Calculadora;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraConttroller {

	@GetMapping(path = "/soma")
	public double getSoma(@RequestParam(name = "a") int a, @RequestParam(name = "") int b) {
		Calculadora soma = new Calculadora(a, b);
		return soma.returnTotal();
	}

	@GetMapping(path = "/subtracao")
	public double getSubtracao(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		double subtracao = a - b;
		return subtracao;
	}

	@GetMapping(path = "/divisao")
	public double getDivisao(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		double divisao = a / b;
		return divisao;
	}

	@GetMapping(path = "/multiplicacao")
	public double getMultiplicacao(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
		double multiplicacao = a * b;
		return multiplicacao;
	}
}