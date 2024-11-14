// 6.18 - Exibindo um quadrado de asteriscos
/*
Escreva um método squareOfAsterisks que exibe um quadrado sólido (o mesmo número de linhas e colunas) de asteriscos cujo lado é especificado no parâmetro inteiro side. Por exemplo, se side for 4, o método deve exibir
					****
					****
					****
					**** 
Incorpore esse método a um aplicativo que lê um valor inteiro para side a partir da entrada fornecida pelo usuário e gera a saída dos asteriscos com o método squareOfAsterisks
*/
import java.util.Scanner;

public class Exerc_6_18 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o tamanho quadrado: ");
        int side = input.nextInt();

        squareOfAsterisks(side);
    }
    
    public static String squareOfAsterisks(int x)
    {
        String asterisk = "* ";

        for (int i = 1; i <= x; i++) 
        {    
            for (int j = 1; j <= x; j++)
            {
                System.out.print(asterisk);    
            }
            System.out.println();
        }
        return asterisk;
    }
}
