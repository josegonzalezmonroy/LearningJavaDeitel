// 14.13 - Tokenizando e comparando Strings
// Elabore um aplicativo que le uma linha de texto, tokeniza essa linha utilizando caracteres de espaco em branco como delimitadores e gera a saída apenas daquelas palavras que iniciam com a letra "b".
import java.util.Scanner;

public class Exerc_14_13 
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String line = scanner.nextLine();

        // Tokeniza a linha usando espaco como delimitador
        String[] words = line.split(" ");

        // Exibe as palavras que comecam com a letra 'b'
        System.out.println("Palavras que comecam com 'b':");
        for (String word : words) 
            // Verifica se a palavra não está vazia e comeca com a letra 'b'
            if (word.toLowerCase().startsWith("b"))
                System.out.println(word);
    }
}
