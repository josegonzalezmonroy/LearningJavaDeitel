// 20.4 - Método genérico SelectionSort
// Escreva um método selectionSort genérico com base no programa de classificação da Figura 19.4. Escreva um programa de teste que insere, classifica e gera uma saída de um array Integer e um array Float. [Dica: use <T extends Comparable> na seção de parâmetros de tipo para o método selectionSort, de modo que você possa usar o método compareTo para comparar os objetos do tipo que T representa.]
import java.security.SecureRandom;
import java.util.Arrays;

public class Exerc_20_4
{
   public static void main(String[] args)
   {
      SecureRandom generator = new SecureRandom();

      Integer[] dataInteger = new Integer[10]; // cria um array de Integer com 10 elementos

      for (int i = 0; i < dataInteger.length; i++) 
         dataInteger[i] = 10 + generator.nextInt(90); // preenche o array com números aleatórios entre 10 e 99

      System.out.printf("Array Integer nao ordenado:%n%s%n", Arrays.toString(dataInteger)); 
      
      selectionSort(dataInteger); // ordena o array utilizando o método selectionSort

      System.out.printf("Array Integer ordenado:%n%s%n%n", Arrays.toString(dataInteger)); 

      Float[] dataFloats = new Float[10]; // cria um array de Float com 10 elementos

      for (int i = 0; i < dataFloats.length; i++) 
         dataFloats[i] = 10.0f + (generator.nextFloat() * 90.0f); // preenche o array com números aleatórios entre 10.0 e 100.0

      System.out.printf("Array Float nao ordenado:%n%s%n", Arrays.toString(dataFloats)); 
      
      selectionSort(dataFloats); // ordena o array utilizando o método selectionSort

      System.out.printf("Array Float ordenado:%n%s%n%n", Arrays.toString(dataFloats)); 
   } 
   
   // método para ordenar o array utilizando ordenação por seleção
   public static <T extends Comparable<T>> void selectionSort(T[] data)              
   {
      for (int i = 0; i < data.length - 1; i++)
      {
         int smallest = i; // define o índice do menor elemento encontrado

         for (int index = i + 1; index < data.length; index++)
            if (data[index].compareTo(data[smallest]) < 0) // verifica se o elemento atual é menor que o menor encontrado
               smallest = index; // atualiza o índice do menor elemento

         swap(data, i, smallest); // troca o menor elemento encontrado com o elemento atual
      }                                          
   } 

   // método auxiliar para trocar os valores em dois índices do array
   private static <T> void swap(T[] data, int first, int second)
   {
      T temporary = data[first]; // armazena o valor do primeiro elemento temporariamente
      data[first] = data[second]; // substitui o primeiro pelo segundo
      data[second] = temporary; // coloca o valor temporário na posição do segundo
   } 
}
