package br.com.aula.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.aula.exception.QuantidadeNegativaException;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private int qtdePaginas;
	private float preco;
	private int qtde;

	public Livro() {

	}

	public Livro(String titulo, int qtdePaginas, float preco, int qtde) {
		super();
		this.titulo = titulo;
		this.qtdePaginas = qtdePaginas;
		this.preco = preco;
		this.qtde = qtde;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQtdePaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public void calcularQuantidade(int valor) throws QuantidadeNegativaException {
		if (valor <= this.qtde) {
			this.qtde -= valor;
		} else {
			throw new QuantidadeNegativaException("A quantidade de livros não pode ficar negativa");
		}

	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", qtdePaginas=" + qtdePaginas + "]";
	}

}
