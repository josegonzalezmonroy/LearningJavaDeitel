// 2.14 - Programa de impressão de losangos
// Escreva um aplicativo que imprima a seguinte forma de losango. Você pode utilizar instruções de saída que imprima um único asterisco (*), um único espaço ou um único caractere de nova linha. Maximize sua utilização de repetição (com instruções for aninhadas) e minimize o número de instruções de saída.
public class Exerc_5_24 
{
    public static void main(String[] args) 
    {
        int count = 1; 
        
        for (int i = 1; i <= 9; i+=2)
        {    
            for (int k = 4; count <= k; k--)
            System.out.print(" ");
            count++;
            
            for (int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            
            System.out.println();
        }
        count = 1;
        
        for (int i = 7; i >= 1; i-=2)
        {
            for (int k = 1; count >= k; k++)
            System.out.print(" ");
            count++;

            for (int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }    
}
