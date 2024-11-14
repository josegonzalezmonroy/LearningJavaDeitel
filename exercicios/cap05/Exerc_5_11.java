// 5.11 - Menor valor 
// Escreva um aplicativo que localiza o menor de varios numeros inteiros. Suponha que o primeiro valor lido especifica o numero de valores a serem inseridos pelo usuario

import java.util.Scanner;

public class Exerc_5_11
{
    public static void main(String[] args) 
    {
        int valorMenor = 0;
        int valorNovo;

        Scanner input = new Scanner(System.in);

        System.out.printf("Digite um inteiro positivo: ");
        int counter = input.nextInt();
        valorMenor = counter;

        while (counter > 1) 
        {
            System.out.printf("(%d) Digite um inteiro positivo: ", counter-1);
            valorNovo = input.nextInt();

            if (valorNovo < valorMenor)
                valorMenor = valorNovo;

            counter--; 
        }

        System.out.printf("%nO menor inteiro inserido foi: %d", valorMenor);
    }    
}
