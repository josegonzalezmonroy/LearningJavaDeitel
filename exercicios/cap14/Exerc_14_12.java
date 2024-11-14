// 14.12 - Pesquisando Strings
// Elabore um aplicativo baseado no aplicativo da Questão 14.11 que insere uma linha de texto e utiliza o método String indexOf para determinar o número total de ocorrências de cada letra do alfabeto no texto. As letras minúsculas e maiúsculas devem ser contadas juntas. Armazene os totais para cada letra em um array e imprima os valores em formato tabular depois que os totais foram determinados.
import java.util.Scanner;

public class Exerc_14_12 
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner input = new Scanner(System.in);

        // Solicita ao usuário que insira uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String line = input.nextLine();

        // Exibe o cabeçalho para a contagem de ocorrências
        System.out.println("\nOcorrencias");

        // Loop para percorrer todas as letras do alfabeto
        for (int i = 0; i < ALFABETO.length; i++)
        {
            // Adiciona uma quebra de linha a cada 4 letras para melhorar a visualização
            if (i % 4 == 0)
                System.out.println();

            // Exibe a contagem de ocorrências para cada letra do alfabeto
            // Usa "-" se não houver ocorrências, ou o número de ocorrências se for maior que 0
            System.out.printf(
                "%s: " + (ocorrencias(line, ALFABETO[i]) == 0 ? "-" : "%d") + "   ", 
                String.valueOf(ALFABETO[i]).toUpperCase(), ocorrencias(line, ALFABETO[i]));
        }
    }
    
    // Array final contendo todas as letras do alfabeto em minúsculas
    private static final char[] ALFABETO = 
    {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    }; 
    
    // Método para contar as ocorrências de um caractere específico na linha de texto
    public static int ocorrencias(String line, char character)
    {
        // Inicializa o contador de ocorrências
        int count = 0;
        
        // Inicializa o índice para começar a pesquisa
        int index = 0;
        
        // Loop para contar todas as ocorrências do caractere usando indexOf
        while ((index = line.toLowerCase().indexOf(character, index)) != -1) 
        {
            // Incrementa o contador de ocorrências
            count++;
            // Atualiza o índice para procurar a próxima ocorrência após a posição atual
            index++;
        }
        
        // Retorna o número total de ocorrências do caractere
        return count;
    }
}
