// 14.9 - Exibindo uma frase com as palavras invertidas 
// Elabore um aplicativo que insere uma linha de texto, tokeniza a linha com o método String split e gera os tokens na ordem inversa. Utilize caracteres de espaço em branco como delimitadores.
import java.util.Scanner;

public class Exerc_14_9 
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

        // Inicializa uma string para armazenar a linha com as palavras na ordem inversa
        String reversedLine = "";

        // Loop que percorre o array de palavras de trás para frente
        for (int i = words.length - 1; i >= 0; i--) 
            // Adiciona cada palavra ao resultado final, separada por espaço
            reversedLine += words[i] + " ";

        // Exibe a linha com as palavras na ordem inversa
        System.out.println("Linha com palavras invertidas:");
        System.out.println(reversedLine.trim()); // Usa trim() para remover o espaço final extra
    }
}
