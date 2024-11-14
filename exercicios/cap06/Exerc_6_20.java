// 6.20 - Area de circulo
// Escreva um aplicativo que solicita ao usuário o raio de um círculo e utiliza um método chamado circleArea para calcular a área do círculo.
import java.util.Scanner;

public class Exerc_6_20 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor do raio: ");
        double raio = input.nextDouble(); 

        System.out.printf("Area do circulo: %.2f", circleArea(raio));
    }
    
    public static double circleArea(double x)
    {
        return Math.PI * Math.pow(x, 2);
    }
}
