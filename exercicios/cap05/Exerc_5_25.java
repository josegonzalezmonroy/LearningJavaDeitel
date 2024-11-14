// 5.25 - Programa de impressao de losangos modificado
// Modifique o aplicativo que você escreveu no Exercício 5.24 para ler um número ímpar no intervalo 1 a 19 para especificar o número de linhas no losango. Seu programa então deve exibir um losango do tamanho apropriado.
import java.util.Scanner;

public class Exerc_5_25 
{
    public static void main(String[] args) 
    {
    
        int count = 1;
        int number; 

        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero impar (1 - 19): ");
        number = input.nextInt();

        
        for (int i = 1; i <= number; i+=2)
        {    
            for (int k = (number - 1)/2 ; count <= k; k--)
                System.out.print(" ");

            count++;
            
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            
            System.out.println();
        }
        count = 1;

        for (int i = number - 2; i >= 1; i -= 2)
        {
            for (int k = 1; count >= k; k++)
                System.out.print(" ");

            count++;

            for (int j = 1; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
    }    
    
}
