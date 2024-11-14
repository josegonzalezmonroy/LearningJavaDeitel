// 6.26 - Invirtiendo dígitos
// Escreva um método que aceita um valor inteiro e retorna o número com seus dígitos invertidos. Por exemplo, dado o número 7.631, o método deve retornar 1.367. Incorpore o método a um aplicativo que lê um valor a partir da entrada fornecida pelo usuário e exibe o resultado.
import java.util.Scanner;

public class Exerc_6_26 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o numero para ser invertido: ");
        int number = input.nextInt();

        System.out.println(numeroInvertido(number));
    }
    
    public static String numeroInvertido(int x)
    {
        String rebmun = "";

        while (x != 0)
        {
            rebmun += x%10;
            x = x/10;
        }
        return rebmun;// retorna o valor invertido
    }
}
