// 6.27 - Maximo divisor comum
// O máximo divisor comum (MDC) de dois inteiros é o maior inteiro que é divisível por cada um dos dois números. Escreva um método mdc que retorna o máximo divisor comum entre dois inteiros. Incorpore o método a aplicativo que lê dois valores do usuário e exibe o resultado.
import java.util.Scanner;

public class Exerc_6_27 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite dois numeros para calcular o MDC:");
        int a = input.nextInt();// primeiro numero
        int b = input.nextInt();// segundo numero

        System.out.println("MDC = " + mcd(a, b));// imprime o MDC   
    }
    
    public static int mcd(int a, int b)// calcula o mdc, com o algoritmo de Euclides
    {
        int result = 1;

        // a = 48; b = 18
        while(a%b != 0)// se a%b for == 0, para o ciclo
        {   
            result = a%b;// 48 % 18 = 12
            a = b;// b = 18 
            b = result;// b = 12
        }  
        return(b);// retorna o valor de b
    }    
}
