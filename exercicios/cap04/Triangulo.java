// 4.35 - Lados de um triangulo
import java.util.Scanner;

public class Triangulo 
{
    public static void main(String[] args) 
    {  
       Scanner input = new Scanner(System.in);

       System.out.print("Digite o lado A do triangulo: ");
       int a = input.nextInt();

       System.out.print("Digite o lado B do triangulo: ");
       int b = input.nextInt();

       System.out.print("Digite o lado C do triangulo: ");
       int c = input.nextInt();

       if (a + b > c && b + c > a && c + a > b)
        {
            System.out.print("\nOs valores PODEM representar os lados de um triangulo");
        }
        else
        {
            System.out.print("\nOs valores NAO podem representar os lados de um triangulo");   
        }
    }    
}
