// 6.21 - Separando digitos
// Escreva segmentos de programa que realizam cada uma das seguintes tarefas: a) Calcule a parte inteira do quociente quando o inteiro a é dividido pelo número inteiro b. b) Calcule o resto inteiro quando o inteiro a é dividido pelo inteiro b c) Utilize segmentos do programa desenvolvidos nas partes (a) e (b) para escrever o método displayDigits que recebe um inteiro entre 1 e 99999 e o exibe como uma seqüência de dígitos, separando cada par de dígitos por dois espaços. Por exemplo, o inteiro 4562 deve aparecer como 4  5  6  2 d) Incorpore o método desenvolvido na parte (c) a um aplicativo que insere um inteiro e chama displayDigits passando o método que o inteiro inseriu. Exiba os resultados. 
import java.util.Scanner;

public class Exerc_6_21 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um inteiro entre 1 e 99999");
        int number = input.nextInt();// numero inserido pelo usuario

        if (number >= 1 && number <= 99999) // verifica que o numero seja o valido
            displayDigits(number);
        else 
            System.out.println("Digite um inteiro valido entre 1 e 99999");// imprime a mensagem caso o numero inserido seja incorreto
    }

    public static int displayDigits(int x)
    {
        int y = 1;// acumulador
        int digit = 0;// digit deve ser inicializado

        for (int i = x; i >= 10 ; i /= 10) // determina o valor do divisor dependendo do tamnho do numero inserido
        {
            y *= 10;
        }

        while (y > 0)// imprime cada dividendo (digito) por separado
        {
            digit = quociente(x, y);
            System.out.print(digit + "  ");

            x %= y;
            y /= 10;
        }

        return digit;// retorna cada digito individualmete
    }

    public static int quociente(int a, int b)
    {
        return a / b;
    }
}
