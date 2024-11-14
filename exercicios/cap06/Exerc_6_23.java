// 6.23 - Localize o numero
// Escreva um método minimum3 que retorna o menor de três números de ponto flutuante. Utilize o método Math.min para implementar minimun3. Incorpore o método a um aplicativo que lê três valores do usuário, determina o menor valor e exibe o resultado.
import java.util.Scanner;

public class Exerc_6_23 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite 3 valores para calcular o minimo: ");        
        double x = input.nextDouble();// valor 1
        double y = input.nextDouble();// valor 2
        double z = input.nextDouble();// valor 3

        System.out.println("O valor minimo e: " + minimum3(x, y, z));// exibe o valor minimo
    }
    
    public static double minimum3(double a, double b, double c)// determina o valor minimo
    {
        return Math.min(Math.min(a, b), c);
    }
}
