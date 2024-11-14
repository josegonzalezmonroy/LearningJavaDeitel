// 14.5 - Sentencas aleatórias
// Elabore um aplicativo que utiliza geração de números aleatórios para criar frases. Utilize quatro arrays de strings chamados article, noun, verb e preposition. Crie uma frase selecionando uma palavra aleatoriamente de cada array na seguinte ordem: article, noun, verb, preposition, article e noun. À medida que cada palavra é selecionada, concatene-a às primeiras palavras na frase. As palavras devem ser separadas por espaços. Quando a frase final for enviada para saída, ela deve iniciar com uma letra maiúscula e terminar com um ponto. O aplicativo deve gerar e exibir 20 frases. O array de artigos deve conter os artigos "the", "a", "one", "some" e "any"; o array de substantivos deve conter os substantivos "boy", "girl", "dog", "town" e "car"; o array de verbos deve conter os verbos "drove", "jumped", "ran", "walked" e "skipped"; o array de preposições deve conter as preposições "to", "from", "over", "under" e "on".
import java.security.SecureRandom;

public class Exerc_14_5
{
    public static void main(String[] args) 
    {
        // Arrays de palavras
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};

        // Instancia o SecureRandom
        SecureRandom secureRandom = new SecureRandom();

        // Gera e exibe 20 frases
        for (int i = 0; i < 20; i++) 
        {
            // Seleciona uma palavra aleatória de cada array usando SecureRandom
            String sentence = article[secureRandom.nextInt(article.length)] + " " + noun[secureRandom.nextInt(noun.length)] + " " + verb[secureRandom.nextInt(verb.length)] + " " + preposition[secureRandom.nextInt(preposition.length)] + " " + article[secureRandom.nextInt(article.length)] + " " + noun[secureRandom.nextInt(noun.length)];

            // Converte a primeira letra da frase para maiúscula
            sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

            // Adiciona um ponto ao final da frase
            sentence += ".";

            // Exibe a frase gerada
            System.out.println(sentence);
        }
    }
}
