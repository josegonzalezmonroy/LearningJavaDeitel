// 14.10 - Exibindo Strings em letras maiúsculas e minúsculas
// Elabore um aplicativo que insere uma linha de texto e gera duas vezes a saída do texto — uma vez em letras maiúsculas e uma vez em letras minúsculas.
import java.util.Scanner;

public class Exerc_14_10 
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String line = scanner.nextLine();

        // Converte a linha para letras maiusculas
        String upperCaseLine = line.toUpperCase();

        // Converte a linha para letras minusculas
        String lowerCaseLine = line.toLowerCase();

        // Exibe a linha em letras maiusculas
        System.out.println("Texto em letras maiusculas:");
        System.out.println(upperCaseLine);

        // Exibe a linha em letras minusculas
        System.out.println("Texto em letras minusculas:");
        System.out.println(lowerCaseLine);
    }
}
