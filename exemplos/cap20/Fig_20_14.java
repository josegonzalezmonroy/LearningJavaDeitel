// Figura 20.14 - WildcardTest.java
// Programa de teste de curingas (wildcards) em Java.

import java.util.ArrayList;

public class Fig_20_14
{
   public static void main(String[] args) 
   {
      // Criação, inicialização e saída de ArrayList de Integers, 
      // depois exibição do total dos elementos
      Integer[] integers = {1, 2, 3, 4, 5}; // array de inteiros
      ArrayList<Integer> integerList = new ArrayList<>(); // cria ArrayList de Integer

      // Insere elementos no integerList
      for (Integer element : integers)
         integerList.add(element);

      // Exibe os elementos de integerList
      System.out.printf("integerList contém: %s%n", integerList);
      // Exibe o total dos elementos de integerList
      System.out.printf("Total dos elementos em integerList: %.0f%n%n", sum(integerList));

      // Criação, inicialização e saída de ArrayList de Doubles, 
      // depois exibição do total dos elementos
      Double[] doubles = {1.1, 3.3, 5.5}; // array de doubles
      ArrayList<Double> doubleList = new ArrayList<>(); // cria ArrayList de Double

      // Insere elementos no doubleList
      for (Double element : doubles)
         doubleList.add(element);

      // Exibe os elementos de doubleList
      System.out.printf("doubleList contém: %s%n", doubleList);
      // Exibe o total dos elementos de doubleList
      System.out.printf("Total dos elementos em doubleList: %.1f%n%n", sum(doubleList));

      // Criação, inicialização e saída de ArrayList de Numbers contendo 
      // tanto Integers quanto Doubles, depois exibição do total dos elementos
      Number[] numbers = {1, 2.4, 3, 4.1}; // array de Number com Integers e Doubles
      ArrayList<Number> numberList = new ArrayList<>(); // cria ArrayList de Number

      // Insere elementos no numberList
      for (Number element : numbers)
         numberList.add(element);

      // Exibe os elementos de numberList
      System.out.printf("numberList contém: %s%n", numberList);
      // Exibe o total dos elementos de numberList
      System.out.printf("Total dos elementos em numberList: %.1f%n", sum(numberList));
   } // fim do main

   // Método que totaliza os elementos; usando um curinga no parâmetro ArrayList
   public static double sum(ArrayList<? extends Number> list)
   {
      double total = 0; // inicializa o total

      // Calcula a soma
      for (Number element : list)
         total += element.doubleValue(); // converte cada elemento para double

      return total; // retorna o total calculado
   } 
} // fim da classe WildcardTest
