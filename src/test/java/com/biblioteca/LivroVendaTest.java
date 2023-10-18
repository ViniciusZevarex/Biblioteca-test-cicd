package com.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LivroVendaTest {

    private LivroEstoque livroEstoque;
    private LivroVenda livroVenda;

    @Before
    public void setUp() {
        Livro livro = new Livro(new Autor("Autor de Teste", "Sobrenome de Teste"),
                new Editora("Editora de Teste"), "123456", "Livro de Teste", 200);
        livroEstoque = new LivroEstoque(livro, 10, 25.5);
        livroVenda = new LivroVenda(livroEstoque, 5);
    }

    @Test
    public void testIncrementarQuantidade() {
        livroVenda.IncrementarQuantidade();

        assertEquals(6, livroVenda.quantidade);
    }

    @Test
    public void testIncrementarQuantidadeComQuantidade() {
        livroVenda.IncrementarQuantidade(3);

        assertEquals(8, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidade() {
        boolean result = livroVenda.DecrementarQuantidade();

        assertTrue(result);
        assertEquals(4, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComQuantidade() {
        boolean result = livroVenda.DecrementarQuantidade(3);

        assertTrue(result);
        assertEquals(2, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComQuantidadeMaiorQueDisponivel() {
        boolean result = livroVenda.DecrementarQuantidade(7);

        assertFalse(result);
        assertEquals(5, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeAteZero() {
        boolean result = livroVenda.DecrementarQuantidade(5);

        assertTrue(result);
        assertEquals(0, livroVenda.quantidade);

        result = livroVenda.DecrementarQuantidade();

        assertFalse(result);
        assertEquals(0, livroVenda.quantidade);
    }
}
