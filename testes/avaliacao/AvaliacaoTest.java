package br.com.gilmar;

import static org.junit.Assert.assertEquals;


// Igor Pimenta Araujo - 201905534
// João Pedro Silva Franco - 202204196

// Testes de Unidade

public class AvaliacaoTest {
    @Test
    public void approved() {
        Avaliacao a = new Avaliacao();
        assertEquals("Aprovado.", a.avalia(10, 10, 0, 100));
    }

    @Test
    public void reprovedByAbsence() {
        Avaliacao a = new Avaliacao();
        assertEquals("Reprovado por Falta.", a.avalia(10, 10, 26, 100));
    }

    @Test
    public void reprovedByAverage() {
        Avaliacao a = new Avaliacao();
        assertEquals("Reprovado por Média.", a.avalia(2, 2, 0, 100));
    }

    @Test
    public void extraTest() {
        Avaliacao a = new Avaliacao();
        assertEquals("Prova Extra.", a.avalia(3, 3, 0, 100));
    }

    @Test
    public void invalidValues() {
        Avaliacao a = new Avaliacao();
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(11, 10, 0, 100));
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, 11, 0, 100));
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, 10, 101, 100));
    }

    @Test 
    public void negativeValues(){
        Avaliacao a = new Avaliacao();
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(-1, 10, 0, 100));
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, -1, 0, 100));
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, 10, -1, 100));
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, 10, 0, -1));
    }

    @Test
    public void equalZeroWorkLoad(){
        Avaliacao a = new Avaliacao();
        assertThrows(ValoresInvalidosException.class, () -> a.avalia(10, 10, 0, 0));
    }

}