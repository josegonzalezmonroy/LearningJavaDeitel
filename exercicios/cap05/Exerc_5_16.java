// 5.16 - Grafico de barras do programa de impressao
// Escreva um aplicativo que leia cinco numeros entre 1 e 30. Para cada numero que é lido, seu programa deve exibir o mesmo numero de asteriscos adjacentes. Exiba as barras dos asteriscos depois de ler os cinco numeros.

import java.util.Scanner;

public class Exerc_5_16 
{
    public static String barra(int number)
    {
        String barra = "";

        for (int i = 1; i <= number; i++)
        {
            barra+="*";
        }
        return barra;
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int number01;
        int number02;
        int number03;
        int number04;
        int number05;

        System.out.print("(5) Digite um inteiro entre 1 e 30: ");
        number01 = input.nextInt();

        System.out.print("(4) Digite um inteiro entre 1 e 30: ");
        number02 = input.nextInt();

        System.out.print("(3) Digite um inteiro entre 1 e 30: ");
        number03 = input.nextInt();

        System.out.print("(2) Digite um inteiro entre 1 e 30: ");
        number04 = input.nextInt();

        System.out.print("(1) Digite um inteiro entre 1 e 30: ");
        number05 = input.nextInt();

        System.out.printf("%n%2d %s%n%2d %s%n%2d %s%n%2d %s%n%2d %s%n", number01, barra(number01), number02, barra(number02), number03, barra(number03), number04, barra(number04), number05, barra(number05));

    }
}
