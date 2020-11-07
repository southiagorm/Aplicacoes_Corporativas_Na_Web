package br.com.aula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 150)
	private String nome;
	@Column(length = 20)
	private String matricula;
	private float salario;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER)
	private List<Telefone> telefones;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Setor> setores;
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private CarteiraTrabalho carteira;

	public Funcionario() {

	}

	public Funcionario(String nome, String matricula, float salario) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}

	public void addSetor(Setor setor) {
		this.setores.add(setor);
	}

	public CarteiraTrabalho getCarteira() {
		return carteira;
	}

	public void setCarteira(CarteiraTrabalho carteira) {
		this.carteira = carteira;
	}

}
