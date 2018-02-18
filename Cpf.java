package programa.teste;
/**
 * 
 * @author Carolina
 * @version 1.0
 */

public class Cpf {
	
	/** Realiza a validação do CPF
	 * 
	 * @param strCPF número de CPF a ser validado
	 * @return true se o CPF é válido e false se não é válido
	 * 
	 * Para saber o dígito de verificação do CPF, foi realizada a consulta no site:
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
		
		//multiplique a última casa por 2 e a seguinte por 3, a seguinte por 4 e assim em diante.
		d1 = d1 + ( 11 - nCount ) * digitoCPF;
		
		//para o segundo dígito, repita o procedimento incluindo o primeiro dígito calculado no passo anterior
		d2 = d2 + ( 12 - nCount ) * digitoCPF;
		
		
	};
	
	//Primeiro resto da divisão por 11.
	resto = d1 % 11;
	
	//Se o resultado for 0 ou 1 o dígito é 0, caso contrário o dígito é 11 menos o resultado anterior.
	
	if(resto < 2)
		digito1 = 0;
	else
		digito1 = 11 - resto;
	
	d2+= 2 * digito1;
	
	//Segundo resto da divisão por 11.
	resto = (d2 % 11);
	
	//Se o resultado for 0 ou 1 o digito é 0, caso contrário, o dígito é 11 menos o resultado anterior.
	if (resto < 2)
		digito2 = 0;
	else
		digito2 = 11 - resto;
	
	//Digito verificador do CPF que está sendo validado.
	String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());
	
	//Concatenando o primeiro resto com o segundo.
	nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
	
	//Comparar o dígito verificador do CPF com o primeiro resto + o segundo resto
	return nDigVerific.equals(nDigResult);
		
}

}
