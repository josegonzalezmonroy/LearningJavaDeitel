// 4.36 - Triangulo direito

import java.util.Scanner;

public class TrianguloDireito 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o lado A do triangulo: ");
        double a = input.nextDouble();
        
        System.out.print("Digite o lado B do triangulo: ");
        double b = input.nextDouble();
        
        System.out.print("Digite o lado C do triangulo: ");double c = input.nextDouble();
        
        if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2))// c² = a² + b²
        {
            System.out.print("\nOs valores PODEM representar os lados de um triangulo direito");
        }
        else
        {
            System.out.print("\nOs valores NAO podem representar os lados de um triangulo direito");   
        }    
    }    
}
