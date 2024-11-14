// Figura 20.13 - TotalNumbers.java
// Somando os números em uma ArrayList<Number>.

import java.util.ArrayList;

public class Fig_20_13
{
   public static void main(String[] args) 
   {
      // Cria um array com números inteiros (Integer) e de ponto flutuante (Double)
      Number[] numbers = {1, 2.4, 3, 4.1}; // Integers e Doubles
      
      // Cria uma ArrayList que pode conter elementos do tipo Number
      ArrayList<Number> numberList = new ArrayList<>();

      // Adiciona cada número do array numbers à lista numberList
      for (Number element : numbers) 
         numberList.add(element); // coloca cada número em numberList

      // Exibe o conteúdo de numberList
      System.out.printf("numberList contém: %s%n", numberList);
      
      // Chama o método sum para calcular a soma dos elementos e exibe o total
      System.out.printf("Total dos elementos em numberList: %.1f%n", 
         sum(numberList));
   }

   // Método que calcula o total dos elementos de uma ArrayList de Number
   public static double sum(ArrayList<Number> list)
   {
      double total = 0; // inicializa o total

      // Itera por cada elemento da lista, somando seus valores
      for (Number element : list)
         total += element.doubleValue(); // Converte cada elemento para double

      return total; // Retorna o total calculado
   } 
} // fim da classe TotalNumbers
