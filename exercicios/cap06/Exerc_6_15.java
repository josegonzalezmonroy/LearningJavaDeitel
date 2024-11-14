// 6.15 - Calculo de hipotenusa
// Defina um método hypotenuse que calcule o comprimento da hipotenusa de um triângulo direito quando o comprimento dos outros dois lados são conhecidos. O método deve receber dois argumentos do tipo double e retornar a hipotenusa como um double. Incorpore esse método a um aplicativo que lê valores para side1 e side2 e realiza o cálculo com o método hypotenuse.
import java.util.Scanner;

public class Exerc_6_15 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do cateto A: ");
        double side1 = input.nextDouble();
        System.out.println("Digite o valor do cateto B: ");
        double side2 = input.nextDouble();

        System.out.println("Hipotenusa: " + hypotenuse(side1, side2));
    }
    
    public static double hypotenuse(double a, double b)
    {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));       
    }
}
