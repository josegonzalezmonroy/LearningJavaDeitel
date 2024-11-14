// 16.20 - Classificando palavras com um TreeSet
// Escreva um programa que utiliza um método String split para tokenizar uma linha de entrada de texto fornecida pelo usuário e coloca cada token em um TreeSet. Imprima os elementos do TreeSet. [Observação: isso deve fazer com que os elementos sejam impressos na ordem de classificação ascendente.]

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exerc_16_20 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário uma linha de texto
        System.out.println("Digite uma linha de texto:");
        String entrada = scanner.nextLine();

        // Tokeniza a entrada com base nos espaços
        String[] palavras = entrada.split("\\s+"); // separa por espaços em branco

        // Cria um TreeSet para armazenar as palavras (TreeSet ordena automaticamente)
        Set<String> treeSet = new TreeSet<>();

        // Adiciona as palavras tokenizadas ao TreeSet
        for (String palavra : palavras) 
            treeSet.add(palavra.toLowerCase()); // Insere em minúsculas para evitar distinção entre maiúsculas e minúsculas

        // Exibe os elementos do TreeSet (serão exibidos em ordem ascendente)
        System.out.println("Palavras ordenadas:");
        for (String palavra : treeSet) 
            System.out.println(palavra);
    }    
}
