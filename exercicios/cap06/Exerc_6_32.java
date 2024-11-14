// 6.32 - Distancia emtre pontos
// Escreva um método distance para calcular a distancia entre dois pontos (x1, y1) e (x2, y2). Todos os números e valores de retorno devem ser do tipo double. Incorpore esse método a um aplicativo que permite que o usuário insira as coordenadas de pontos.
import java.util.Scanner;

public class Exerc_6_32 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite as coordenadas do ponto A (X e Y): ");// primeiro ponto
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.println("Agora as coordenadas do ponto B (X e Y): ");// segundo ponto
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.printf("Distancia entre o ponto A e B: %n%.3f", distance(x1, y1, x2, y2));// imprime a distancia
    }

    public static double distance(double x1, double y1, double x2, double y2)// calcula a distancia entre os dois pontos (hipotenusa)
    {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    } 
}
