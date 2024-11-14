// 7.29 - Série de Fibonacci 
/* 
A série de Fibonacci 
    0, 1, 1, 2, 3, 5, 8, 13, 21,...
    
inicia com os termos 0 e 1 e tem a propriedade de que cada termo sucessivo éa soma dos dois termos precedentes.

a) Escreva o método fibonacci( n ) que calcula a n-ésimo termo da sériede Fibonacci. Incorpore esse método a um aplicativo que permita ao usuárioinserir o valor de n.
b) Determine o maior número de Fibonacci que pode ser exibido em seu sistema.
c) Modifique o aplicativo que você escreveu na parte (a) para utilizardouble em vez de int para calcular e retornar números de Fibonacci e utilizar esse aplicativo modificado para repetir a parte (b).
*/
import java.util.Scanner;

public class Exerc_7_29 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
/////// Para os calculos com:
/////// int ---> n46 = 1.836.311.903 
/////// double ---> n1476 = 130.698.922.376.339.870.000.000...000

        System.out.println("Serie de Fibonacci\nDigite o valor de 'n'");
        int n = input.nextInt();// numero inserido pelo usuario

        // calcula a serie a partir do numero inserido pelo usuario
        fibonacci(n);
    }
    
    // calcula a serie de Fibonacci
    public static void fibonacci(int n)
    {
        double resultado;
        double valorA = 0;
        double valorB = 1;
        
        for (int i = 0; i <= n; i++)
        {
            if (i == 0)
                resultado = 0;
            else if (i == 1)
                resultado = 1;
            else
            {
                resultado = valorA + valorB;
                valorA = valorB;
                valorB = resultado;
            }

            if (resultado >= Double.MAX_VALUE)// se atingir o valor maximo
            {
                System.out.println("So foi possivel calcular ate aqui");
                break;// fecha o programa
            }

            // imprime o resultado
            System.out.printf("n%d = %,.0f%n", i, resultado);
        }
    }
}
