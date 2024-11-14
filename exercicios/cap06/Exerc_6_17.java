// 6.17 - Par ou impar
// Escreva um método isEven que utiliza o operador de resto (%) para determinar se um inteiro é par. O método deve aceitar um argumento inteiro e retornar true se o inteiro for par e false se o contrário. Incorpore esse método a um aplicativo que insere uma sequência de inteiros (um por vez) e determina se cada um é par ou ímpar.
import java.util.Scanner;

public class Exerc_6_17 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o inteiro: ");
        int number = input.nextInt();

        if (isEven(number) == true)
            System.out.printf("%d e par", number);
        else 
            System.out.printf("%d e impar", number);
    }
    
    public static boolean isEven(int a)
    {
        return a % 2 == 0;
    }
}
