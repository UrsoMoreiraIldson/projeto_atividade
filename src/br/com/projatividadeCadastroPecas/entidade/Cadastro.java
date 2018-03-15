
package br.com.projatividadeCadastroPecas.entidade;

public class Cadastro {
	private int id;
	private String nome;
	private Double peso;
	private String tipo;
	private String datacadastro;
	private Double valor;
	
	public Cadastro() {
	}
	
	public Cadastro(int id, String nome, Double peso, String tipo, String datacadastro, Double valor) {
		this.id = id;
		this.peso = peso;
		this.tipo = tipo;
		this.datacadastro = datacadastro;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(String datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
	
	