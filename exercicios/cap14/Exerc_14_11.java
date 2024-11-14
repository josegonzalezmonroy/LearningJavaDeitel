// 14.11 - Pesquisando Strings
// Elabore um aplicativo que insere uma linha de texto e um caractere de pesquisa e utiliza o método String indexOf para determinar o número de ocorrências do caractere no texto.
import java.util.Scanner;

public class Exerc_14_11 
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String line = scanner.nextLine();

        // Solicita ao usuário que insira o caractere de pesquisa
        System.out.println("Digite o caractere de pesquisa:");
        char searchChar = scanner.next().charAt(0);

        // Inicializa o contador de ocorrencias
        int count = 0;

        // Inicializa o índice para começar a pesquisa
        int index = 0;

        // Loop para contar todas as ocorrências do caractere usando indexOf
        while ((index = line.indexOf(searchChar, index)) != -1) 
        {
            // Incrementa o contador de ocorrências
            count++;
            // Atualiza o índice para procurar a próxima ocorrência após a posição atual
            index++;
        }

        // Exibe o numero de ocorrencias do caractere
        System.out.println("Numero de ocorrencias do caractere '" + searchChar + "': " + count);
    }
}
