// 14.4 - Comparando partes de Strings
// Elabore um aplicativo que utiliza o método String regionMatches para comparar duas entradas de strings pelo usuário. O aplicativo deve inserir o número de caracteres que será comparado e o índice inicial da comparação. O aplicativo deve declarar se as strings são iguais. Ignore a distinção entre maiúsculas e minúsculas dos caracteres ao realizar a comparação.
import java.util.Scanner;

public class Exerc_14_4 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira as duas strings
        System.out.print("Digite a primeira string: ");
        String string1 = scanner.nextLine();

        System.out.print("Digite a segunda string: ");
        String string2 = scanner.nextLine();

        // Solicita o indice inicial e o numero de caracteres para comparar
        System.out.print("Digite o indice inicial para a comparacao: ");
        int startIndex = scanner.nextInt();

        System.out.print("Digite o numero de caracteres que serao comparados: ");
        int numChars = scanner.nextInt();

        // Realiza a comparacao usando regionMatches
        boolean match = string1.regionMatches(true, startIndex, string2, startIndex, numChars);

        // Exibe o resultado da comparacao
        if (match) 
            System.out.println("As regioes das strings sao iguais.");
        else 
            System.out.println("As regioes das strings sao diferentes.");
    }
}