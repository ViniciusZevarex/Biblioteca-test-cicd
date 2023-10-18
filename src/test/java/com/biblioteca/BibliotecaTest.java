package com.biblioteca;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void testAdicionarLivro() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        Editora editora = new Editora("Editora de Teste");
        Livro livro = new Livro(autor, editora, "123456", "Livro de Teste", 200);
        biblioteca.AdicionarLivro(livro);

        Assert.assertEquals(1, biblioteca.livros.size());
        Assert.assertTrue(biblioteca.livros.contains(livro));
    }

    @Test
    public void testRemoverLivro() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        Editora editora = new Editora("Editora de Teste");
        Livro livro = new Livro(autor, editora, "123456", "Livro de Teste", 200);
        biblioteca.AdicionarLivro(livro);

        Assert.assertEquals(1, biblioteca.livros.size());
        biblioteca.RemoverLivro(livro);
        
        Assert.assertFalse(biblioteca.livros.contains(livro));
    }

    @Test
    public void testAdicionarAutor() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        biblioteca.AdicionarAutor(autor);

        Assert.assertTrue(biblioteca.autores.contains(autor));
    }

    @Test
    public void testRemoverAutor() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        biblioteca.AdicionarAutor(autor);

        Assert.assertEquals(1, biblioteca.autores.size());
        biblioteca.RemoverAutor(autor);

        Assert.assertEquals(0, biblioteca.autores.size());
        Assert.assertFalse(biblioteca.autores.contains(autor));
    }

    @Test
    public void testAdicionarEditora() {
        Editora editora = new Editora("Editora de Teste");
        biblioteca.AdicionarEditora(editora);

        Assert.assertTrue(biblioteca.editoras.contains(editora));
    }

    @Test
    public void testRemoverEditora() {
        Editora editora = new Editora("Editora de Teste");
        biblioteca.AdicionarEditora(editora);

        Assert.assertEquals(1, biblioteca.editoras.size());
        biblioteca.RemoverEditora(editora);

        Assert.assertFalse(biblioteca.editoras.contains(editora));
    }

    @Test
    public void testAdicionarEstoque() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        Editora editora = new Editora("Editora de Teste");
        Livro livro = new Livro(autor, editora, "123456", "Livro de Teste", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 22.57);
        biblioteca.AdicionarEstoque(livroEstoque);

        Assert.assertTrue(biblioteca.estoque.contains(livroEstoque));
    }

    @Test
    public void testRemoverEstoque() {
        Autor autor = new Autor("Autor de Teste", "Sobrenome de Teste");
        Editora editora = new Editora("Editora de Teste");
        Livro livro = new Livro(autor, editora, "123456", "Livro de Teste", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 22.57);
        biblioteca.AdicionarEstoque(livroEstoque);

        Assert.assertEquals(1, biblioteca.estoque.size());
        biblioteca.RemoverEstoque(livroEstoque);
        
        Assert.assertFalse(biblioteca.estoque.contains(livroEstoque));
    }
}
