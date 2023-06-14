package projetoTeste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import src.Identifier;

public class IdentiferTest {
	private Identifier id;
	@Before
	public void setUp() throws Exception {
		id = new Identifier();
	}

	@Test
	public void testaCaractereInicialMaiusculo() {
		Assert.assertEquals(true, id.validateIdentifier("Abcdefgh"));
	}

	@Test
	public void testaCaractereInicialMinusculo() {
		Assert.assertEquals(true, id.validateIdentifier("abcdefgh"));
	}

	@Test
	public void testaCaractereInicialNumero() {
		Assert.assertEquals(false, id.validateIdentifier("1abcdefgh"));
	}

	@Test
	public void testaCaractereInicialEspecial() {
		Assert.assertEquals(false, id.validateIdentifier("!abcdefgh"));
	}

	@Test
	public void testaCarateresEspeciais() {
		Assert.assertEquals(false, id.validateIdentifier("abc!defgh"));
	}

	@Test
	public void testaCarateresEspeciais2() {
		Assert.assertEquals(false, id.validateIdentifier("abc@defgh"));
	}

	@Test
	public void testaTamanhoMenorQue8() {
		Assert.assertEquals(false, id.validateIdentifier("abcdefg"));
	}

	@Test
	public void testaTamanhoMaiorQue12() {
		Assert.assertEquals(false, id.validateIdentifier("abcdefghijklm"));
	}

	@Test
	public void testaTamanhoIgualA8() {
		Assert.assertEquals(true, id.validateIdentifier("abcdefgh"));
	}

	@Test
	public void testaTamanhoIgualA12() {
		Assert.assertEquals(true, id.validateIdentifier("abcdefghijkl"));
	}

	@Test
	public void testaTamanhoEntre8e12() {
		Assert.assertEquals(true, id.validateIdentifier("abcdefghijk"));
	}

	@Test
	public void testaTamanhoEntre8e12_2() {
		Assert.assertEquals(true, id.validateIdentifier("Abcdefghij"));
	}

	@Test
	public void testaTodasAsRegras(){
		Assert.assertEquals(true, id.validateIdentifier("Abcdefghi12"));
	}

	@Test
	public void testaTodasAsRegras2(){
		Assert.assertEquals(true, id.validateIdentifier("abcdefghi12"));
	}

	@Test
	public void testaSenhaApenasNumero(){
		Assert.assertEquals(false, id.validateIdentifier("123456789"));
	}

	@Test
	public void testaTodosCaracteresEspeciais(){
		Assert.assertEquals(false, id.validateIdentifier("!@#$%¨&*()"));
	}

	// Made by Igor Pimenta Araujo - 201905534 - UFG
}
