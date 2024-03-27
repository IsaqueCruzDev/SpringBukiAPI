package br.com.bukiapi.buki.model.entities;

public class Calculadora {

	public int a;
	public int b;
	public double total;
	
	public Calculadora(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public double returnTotal() {
		return a + b;
	}
}
