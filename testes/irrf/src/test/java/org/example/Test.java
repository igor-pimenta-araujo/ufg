package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class testeIRRF {

    private final TabelaIRRF tabelairrf = new TabelaIRRF();

    @Test
    public void testExemplo(){
        double irrf = TabelaIRRF.calcularIRRF(12997.45,3).doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_UP);
        BigDecimal resultadoEsperado = new BigDecimal(2191.10).setScale(2,RoundingMode.HALF_UP);
        assertEquals(resultadoObtido,resultadoEsperado);
    }

    //Isentos
    @Test
    void testIsento()
    {
        double irrf = tabelairrf.calcularIRRF(
                        2115.533,
                        0).doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(0.0, resultadoObtido.doubleValue());
    }

    @Test
    void testIsentoComDep1()
    {
        double irrf = tabelairrf.calcularIRRF(
                        2326.188,
                        1).doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(0.0, resultadoObtido.doubleValue());
    }

    @Test
    void testIsentoComDep2()
    {
        double irrf = tabelairrf.calcularIRRF(
                2536.844,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(0.0, resultadoObtido.doubleValue());
    }

    @Test
    void testIsentoComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2747.5,
                3
        ).doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testIsentoComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2958.,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 1
    @Test
    void testFaixa1SemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2115.534,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1ComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2326.189,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1ComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2536.845,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1ComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2747.501,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1ComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                2958.157,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1ComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3168.813,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 1 Valor Superior
    @Test
    void testFaixa1SuperiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3140.72,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1SuperiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3351.375,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1SuperiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3562.031,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1SuperiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3772.687,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1SuperiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3983.343,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa1SuperiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4193.999,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 2 Valor Inferior
    @Test
    void testFaixa2InferiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3140.73,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2InferiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3351.385,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2InferiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3562.041,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2InferiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3772.697,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2InferiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                3983.353,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2InferiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4194.009,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(69.20).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 2 Valor Superior
    @Test
    void testFaixa2SuperiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4167.83,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2SuperiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4378.485,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2SuperiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4589.141,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2SuperiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4799.797,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2SuperiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5010.453,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa2SuperiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5221.109,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 3 Valor Inferior
    @Test
    void testFaixa3InferiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4167.84,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3InferiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4378.49,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3InferiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4589.15,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3InferiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                4799.80,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3InferiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5010.46,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3InferiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5221.11,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(207.86).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 3 Valor Superior
    @Test
    void testFaixa3SuperiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5182.97,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3SuperiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5393.62,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3SuperiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5604.28,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3SuperiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5814.93,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3SuperiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                6025.59,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa3SuperiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                6236.24,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Faixa 4 Valor Inferior
    @Test
    void testFaixa4InferiorSemDep()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5182.98,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa4InferiorComDep1()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5393.63,
                1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa4InferiorComDep2()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5604.29,
                2)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa4InferiorComDep3()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                5814.94,
                3)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa4InferiorComDep4()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                6025.60,
                4)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    void testFaixa4InferiorComDep5()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                6236.25,
                5)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(413.42).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Valor negativo
    @Test
    void testValorNegativo()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                -1000,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Valor zero
    @Test
    void testValorZero()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                0,
                0)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    // Dependententes negativos
    @Test
    void testDependentesNegativos()
    {
        double irrf = TabelaIRRF.calcularIRRF(
                1000,
                -1)
                .doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal resultadoEsperado = new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(resultadoEsperado, resultadoObtido);
    }


}