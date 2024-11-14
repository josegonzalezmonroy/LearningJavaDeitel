// 5.22 - Programa de impresão de triangulos moificado
// Moifique a questão 5.15 para combinar seu codigo dos quatro triangulos de asteriscos separados, de modo que todos os quatro padroes sejam impressos lado a lado.
public class Exerc_5_22 
{
    public static void main(String[] args) 
    {
        // (a)
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= i; j++)//a
            {
                System.out.print("*");
            }
            for (int k = 10; k > i; k--)
            {
                System.out.print(" ");
            }
            
            for (int j = 10; j >= i; j--)//b
            {
                System.out.print("*");
            }
            for (int k = 2; k < i*2; k++)
            {
                System.out.print(" ");
            }

            for (int j = 10; j >= i; j--)//c
            {
                System.out.print("*");
            }
            for (int j = 10; j > i; j--)
            {
                System.out.print(" ");
            }
            
            for (int k = 1; k <= i; k++)//d
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }    
}
