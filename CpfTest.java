package aula.teste;
import programa.teste.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CpfTest {
	
	
		
		public Cpf cpfValido = new Cpf();
		public Cpf cpfInvalido = new Cpf();
	
		

	@Test
	public void testCPFString() {
		
		assertTrue(cpfValido.CPF("23456798750"));
		assertFalse(cpfInvalido.CPF("23456798751"));
		
		
		
		//O comando abaixo irá indicar um erro lógico, para gerar a exception (Um cpf inválido deve retornar Falso/Inválido).
		
		//assertTrue(cpfInvalido.CPF("23456798751"));
		
		
	}

	

}
