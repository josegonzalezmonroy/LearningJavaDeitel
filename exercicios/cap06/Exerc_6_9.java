// 6.9 - Arredondando números
//Uma aplicação do método Math.floor é arredondar um valor para o inteiro mais próximo. A instrução y = Math.floor( x + 0.5 ); vai arredondar o número x para o inteiro mais próximo e atribuir o resultado a y. Escreva um aplicativo que lê valores double e utilize a instrução anterior para arredondar cada um dos números para o inteiro mais próximo. Para cada número processado, exiba cada um dos números, o original e o arredondado.
import java.util.Scanner;

public class Exerc_6_9 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o valor: ");
        double x = input.nextDouble();

        double y = Math.floor(x + 0.5);

        System.out.println("Original: " + x);
        System.out.println("Arredondado: " + y);
    }    
}
