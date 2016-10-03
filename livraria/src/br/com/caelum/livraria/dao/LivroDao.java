package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Livro;

public class LivroDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	private DAO<Livro> dao;

	@PostConstruct
	void init() {
		this.dao = new DAO<Livro>(this.em, Livro.class);
	}

	public List<Livro> listaTodos() {
		return dao.listaTodos();
	}

	public Livro buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public void adiciona(Livro livro) {
		dao.adiciona(livro);
	}

	public void atualiza(Livro livro) {
		dao.atualiza(livro);
	}

	public void remove(Livro livro) {
		dao.remove(livro);
	}

	public int quantidadeDeElementos() {
		return dao.quantidadeDeElementos();
	}

	public List<Livro> listaTodosPaginada(int inicio, int quantidade, String string, String titulo) {
		return dao.listaTodosPaginada(inicio, quantidade, string, titulo);
	}

}
