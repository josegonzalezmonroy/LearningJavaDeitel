// 16.17 - Inserção de elementos de uma LinkedList em uma ordem classificada
// Escreva um programa que insere 25 inteiros aleatórios de 0 a 100 em ordem em um objeto LinkedList. O programa deve classificar os elementos e, então, calcular a soma dos elementos e a média de ponto flutuante deles.

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Exerc_16_17 
{
    public static void main(String[] args) 
    {
        LinkedList<Integer> lista = new LinkedList<>();
        Random random = new Random();

        // Gera e insere 25 inteiros aleatórios entre 0 e 100 na LinkedList
        for (int i = 0; i < 25; i++) 
        {
            int numero = random.nextInt(101); // Gera números entre 0 e 100
            lista.add(numero);
        }

        // Ordena a LinkedList
        Collections.sort(lista);

        // Exibe a lista ordenada
        System.out.println("Lista ordenada: " + lista);

        // Calcula a soma dos elementos
        int soma = 0;
        for (int numero : lista) 
            soma += numero;

        // Calcula a média dos elementos
        double media = (double) soma / lista.size();

        // Exibe a soma e a média
        System.out.println("Soma dos elementos: " + soma);
        System.out.printf("Media dos elementos: %.2f%n", media);
    }
}
