// 16.13 - Eliminação de duplicatas 
// Escreva um programa que lê em uma série nomes e elimina duplicatas armazenando-os em um Set. Permita que o usuário procure um primeiro nome.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exerc_16_13 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Set<String> nomes = new HashSet<>(); // Utiliza um Set para eliminar duplicatas
        String nome;

        // Lê e armazena os nomes, eliminando duplicatas
        System.out.println("Digite nomes (ou 'fim' para parar):");
        while (true) 
        {
            nome = input.nextLine().trim();

            if (nome.equalsIgnoreCase("fim")) 
                break;

            // Adiciona o nome ao Set, duplicatas serão automaticamente ignoradas
            nomes.add(nome);
        }

        // Exibe os nomes únicos
        System.out.println("\nNomes sem duplicatas:");
        for (String n : nomes) 
            System.out.println(n);

        // Permite que o usuário procure um nome
        System.out.println("\nDigite o nome que deseja procurar:");
        String nomeProcurado = input.nextLine().trim();

        if (nomes.contains(nomeProcurado)) 
            System.out.printf("O nome '%s' foi encontrado.%n", nomeProcurado);
        else 
            System.out.printf("O nome '%s' nao foi encontrado.%n", nomeProcurado);
    }    
}
