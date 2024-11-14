// 6.6 - Calcula o volume de uma esfera

import java.util.Scanner;

public class Exerc_6_6 
{
    // obtém o raio a partir do usuário e exibe o volume da esfera
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter radius of sphere: ");
        double radius = input.nextDouble();

        System.out.printf("Volume is %f%n", sphereVolume(radius));
    }
    // calcula e retorna volume de esfera
    public static double sphereVolume(double radius)
    {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return volume;
    } // fim do método sphereVolume
}
