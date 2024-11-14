// 14.14 - Tokenizando e comparando Strings
// Elabore um aplicativo que le uma linha de texto, tokeniza essa linha utilizando caracteres de espaço em branco como delimitadores e gera a saída apenas daquelas palavras que terminem com as letras "ED".
import java.util.Scanner;

public class Exerc_14_14 
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String line = scanner.nextLine();

        // Tokeniza a linha usando espaço como delimitador
        String[] words = line.split(" ");

        // Exibe as palavras que terminam com "ED"
        System.out.println("Palavras que terminam com 'ed':");
        for (String word : words) 
            // Verifica se a palavra não está vazia e termina com "ED"
            if (word.toLowerCase().endsWith("ed")) 
                System.out.println(word);
    }
}
