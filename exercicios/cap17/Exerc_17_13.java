// 17.13 - Classificando letras e removendo duplicatas
// Escreva um programa que insere 30 letras aleatórias em uma List. Realize as seguintes operações e exiba os resultados: a) Classifique a List em ordem crescente. b) Classifique a List em ordem decrescente. c) Mostre a List em ordem crescente com duplicatas removidas.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Exerc_17_13
{
    public static void main(String[] args) 
    {
        List<Character> letras = new ArrayList<>();
        Random random = new Random();
        // Genera 30 letras aleatorias
        for (int i = 0; i < 30; i++) 
            letras.add((char) ('A' + random.nextInt(26))); // Letras de A a Z

        System.out.println("Letras aleatórias:");
        System.out.println(letras);

        // a) Classifica a List em ordem crescente
        System.out.println("\nOrdem crescente:");
        letras.stream()
            .sorted()
            .forEach(letter -> System.out.print(letter + " "));

        // b) Classifica a List em ordem decrescente

        System.out.println("\nOrdem decrescente:");
        letras.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(letter -> System.out.print(letter + " "));

        // c) Mostra a List em ordem crescente com duplicatas removidas
        System.out.println("\nOrdem crescente com duplicatas removidas:");
        letras.stream()
            .distinct()
            .sorted()
            .forEach(letter -> System.out.print(letter + " "));
    }
}
