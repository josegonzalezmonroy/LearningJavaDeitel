// 14.7 - Latim de porco
// Elabore um aplicativo que codifica frases da lingua inglesa em latim de porco. O Pig Latin é uma forma de linguagem codificada. Há muitos métodos diferentes para formar frases em Pig Latin. Para simplificar, utilize o seguinte algoritmo: Para formar uma frase em latim de porco a partir de uma frase em ingles, tokenize a frase em palavras com o método String split. Para traduzir cada palavra inglesa em uma palavra do latim de porco, coloque a primeira letra da palavra inglesa no final da palavra e adicione as letras "ay". Assim, a palavra "jump" torna-se "umpjay", a palavra "the" torna-se "hetay", e a palavra "computer" torna-se "omputercay". Os espaços entre as palavras permanecem iguais. Suponha o seguinte: a frase inglesa consiste em palavras separadas por espaços, nao há nenhuma marcaçao de pontuaçao e todas as palavras tem duas ou mais letras. O método printLatinWord deve exibir cada palavra. Cada token é passado para o método printLatinWord a fim de imprimir a palavra latina porco. Permita que o usuário insira a frase. Continue exibindo todas as frases convertidas em uma área de texto.
import java.util.Scanner;

public class Exerc_14_7 
{

    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma frase em ingles
        System.out.println("Digite uma frase em ingles:");
        String input = scanner.nextLine();

        // Divide a frase em palavras
        String[] words = input.split(" ");

        // Converte cada palavra para Pig Latin e imprime
        for (String word : words) 
        {
            String pigLatinWord = convertToPigLatin(word);
            printLatinWord(pigLatinWord);
        }
    }

    // Método para converter uma palavra para Pig Latin
    public static String convertToPigLatin(String word) 
    {
        // Pega a primeira letra da palavra e move-a para o final, adicionando "ay"
        return word.substring(1) + word.charAt(0) + "ay";
    }

    // Método para exibir a palavra em Pig Latin
    public static void printLatinWord(String word) 
    {
        System.out.print(word + " ");
    }
}
