package br.com.caelum.livraria.testePessoal;

import java.util.List;

import br.com.caelum.livraria.bean.LivroBean;
import br.com.caelum.livraria.modelo.Livro;

public class TesteDAOLivro {
	
	public static void main(String[] args) {
//		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		List<Livro> livros = new LivroBean().getLivros();
		
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo());
		}
	}

}
