// 5.26
// Uma crítica à instrução break e a instrução continue e que elas não são estruturadas. De fato, instruções break e instruções continue podem sempre ser substituídas por instruções estruturadas, embora isso possa ser inconveniente. Descreva de maneira geral como você removeria qualquer  instrução break de um loop em um programa e substituiria essa instrução por alguma equivalente estruturada. [Dica: A instrução break sai de um loop do corpo do loop. A outra maneira de sair de um loop é falhando no teste de continuação do loop. Considere a possibilidade de utilizar no teste de continuação do loop um segundo teste que indica 'saída prévia por causa de uma condição 'break'.] Utiliza a técnica que você desenvolve aqui para remover a instrução break do aplicativo na Figura 5.12. [Nota: Colocar uma atribuição acima do ponto de falha do loop em count forçando a falha.]
public class Exerc_5_26 
{
    public static void main( String args[] )
	{
		int count;
        int i = 0; 

		for (count = 1; count <= 10; count++)
		{
            System.out.printf( "%d ", count);
            
            i = count;
            if (count == 5) // se contagem for 5,
                count = 11;   // força a falha do loop
		}
		
		System.out.printf( "%nBroke out of loop at count = %d%n", i);
	}  
}
