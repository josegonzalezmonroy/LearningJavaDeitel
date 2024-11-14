// 16.16 - Contando palavras duplicadas
// Escreva um programa que determina e imprime o número de palavras duplicadas em uma frase. Trate da mesma maneira letras minúsculas e maiúsculas. Ignore a pontuação.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exerc_16_16 
{
    public static void main(String[] args) 
    {
        // Solicita a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String input = scanner.nextLine();

        // Remove pontuações e converte a frase para letras minúsculas
        input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Separa as palavras da frase
        String[] palavras = input.split("\\s+");

        // Mapa para armazenar a contagem de palavras
        Map<String, Integer> mapaPalavras = new HashMap<>();

        // Conta a frequência de cada palavra
        for (String palavra : palavras) 
            if (mapaPalavras.containsKey(palavra)) 
                mapaPalavras.put(palavra, mapaPalavras.get(palavra) + 1);
            else 
                mapaPalavras.put(palavra, 1);

        // Conta o número de palavras duplicadas
        duplicatas(mapaPalavras);
    }

    private static void duplicatas(Map<String, Integer> mapaPalavras)
    {
        System.out.println("Palavras duplicadas:");

        int duplicadas = 0;
        for (Map.Entry<String, Integer> entry : mapaPalavras.entrySet())
            if (entry.getValue() > 1)
            {
                duplicadas++;
                System.out.println(entry.getKey());
            }

        System.out.println("Total: " + duplicadas);
    }
}
