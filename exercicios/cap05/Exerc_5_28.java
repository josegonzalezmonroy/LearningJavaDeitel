// 5.28 
// Descreva de maneira geral como você removeria qualquer instrução continue de um loop em um programa e a substituiria por alguma equivalente estruturada. Utilize a técnica que você desenvolve aqui para remover a instrução continue do programa na Figura 5.13. [Nota: Nesse caso utiliza count++ dentro do loop para "pular" um número e coloca-se o restante do código dentro de um bloco.]

public class Exerc_5_28 
{
    public static void main(String[] args) 
    {
        
        int count;
        
		for (count = 1; count <= 10; count++)
		{
            if (count != 5)// faz verificação logo no início do loop.
                System.out.printf( "%d ", count); // Se contagem for diferente do número que se quer pular executa-se o código.
		}
		
		System.out.printf( "%nBroke out of loop at count = %d%n", count);
    }  
}
