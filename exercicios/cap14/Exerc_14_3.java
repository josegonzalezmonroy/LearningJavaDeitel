// 14.3 - Comparando Strings 
// Elabore um aplicativo que utiliza o metodo String compareTo para comparar duas entradas de strings pelo usuário. Crie uma saída informando se a primeira string e menor que, igual a ou maior que a segunda.
import java.util.Scanner;

public class Exerc_14_3 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira as duas strings
        System.out.print("Digite a primeira string: ");
        String string1 = scanner.nextLine();

        System.out.print("Digite a segunda string: ");
        String string2 = scanner.nextLine();

        // Compara as strings usando o metodo compareTo
        int result = string1.compareTo(string2);

        // Exibe o resultado da comparação
        if (result < 0) 
            System.out.println("\"" + string1 + "\" e menor que \"" + string2 + "\".");
        else if (result == 0) 
            System.out.println("\"" + string1 + "\" e igual a \"" + string2 + "\".");
        else 
            System.out.println("\"" + string1 + "\" e maior que \"" + string2 + "\".");
    }
}
