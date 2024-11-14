// 17.12 - Remoção de palavras duplicadas
// Escreva um programa que insere uma frase do usuário (suponha nenhuma pontuação), e então determina e exibe as palavras únicas em ordem alfabética. Trate da mesma maneira letras minúsculas e maiúsculas.

import java.util.Arrays;
import java.util.Scanner;

public class Exerc_17_12 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite uma frase (sem pontuacao):");
        String[] palavras = scanner.nextLine().split("\\s+"); // Divide a frase em palavras com base nos espacos
        
        Arrays.stream(palavras)
            .map(String::toLowerCase) // Converte as palavras para letras minusculas
            .distinct()               // Remove palavras duplicadas
            .sorted()                 // Ordena as palavras em ordem alfabetica
            .forEach(System.out::println); // Exibe cada palavra unica
    }    
}
