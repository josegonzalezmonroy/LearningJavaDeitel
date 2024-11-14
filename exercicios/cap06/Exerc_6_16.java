// 6.6 - Multiplos
// Escreva um método multiple que determina um par de inteiros se o segundo inteiro for múltiplo do primeiro. O método deve aceitar dois argumentos inteiros e retornar true se o segundo for múltiplo do primeiro e false se o contrário. Incorpore esse método a um aplicativo que insere uma série de pares inteiros (um par por vez) e determina se o segundo valor em cada par é múltiplo do primeiro.
import java.util.Scanner;

public class Exerc_6_16 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite dois valores para saber se sao multiplos: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        if (isMultiple(number1, number2) == true)
            System.out.printf("%d e multiplo de %d", number1, number2);
        else 
            System.out.printf("%d nao e multiplo de %d", number1, number2);
    }
    
    public static boolean isMultiple(int a, int b)
    {
        return a % b == 0;
    }
}
