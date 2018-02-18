package programa.teste;
/**
 * 
 * @author Carolina
 * @version 1.0
 */

public class Cpf {
	
	/** Realiza a valida��o do CPF
	 * 
	 * @param strCPF n�mero de CPF a ser validado
	 * @return true se o CPF � v�lido e false se n�o � v�lido
	 * 
	 * Para saber o d�gito de verifica��o do CPF, foi realizada a consulta no site:
	 * http://ghiorzi.org/DVnew.htm
	 */
	
static void CPF()
{}

static public boolean CPF (String strCpf){
	
	int d1, d2;
	int digito1, digito2, resto;
	int digitoCPF;
	String nDigResult;
	
	d1 = d2 = 0;
	digito1 = digito2 = resto = 0;
	
	for(int nCount = 1; nCount < strCpf.length() -1; nCount++){
		
		digitoCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();
		
		//multiplique a �ltima casa por 2 e a seguinte por 3, a seguinte por 4 e assim em diante.
		d1 = d1 + ( 11 - nCount ) * digitoCPF;
		
		//para o segundo d�gito, repita o procedimento incluindo o primeiro d�gito calculado no passo anterior
		d2 = d2 + ( 12 - nCount ) * digitoCPF;
		
		
	};
	
	//Primeiro resto da divis�o por 11.
	resto = d1 % 11;
	
	//Se o resultado for 0 ou 1 o d�gito � 0, caso contr�rio o d�gito � 11 menos o resultado anterior.
	
	if(resto < 2)
		digito1 = 0;
	else
		digito1 = 11 - resto;
	
	d2+= 2 * digito1;
	
	//Segundo resto da divis�o por 11.
	resto = (d2 % 11);
	
	//Se o resultado for 0 ou 1 o digito � 0, caso contr�rio, o d�gito � 11 menos o resultado anterior.
	if (resto < 2)
		digito2 = 0;
	else
		digito2 = 11 - resto;
	
	//Digito verificador do CPF que est� sendo validado.
	String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());
	
	//Concatenando o primeiro resto com o segundo.
	nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	
	//Comparar o d�gito verificador do CPF com o primeiro resto + o segundo resto
	return nDigVerific.equals(nDigResult);
		
}

}
