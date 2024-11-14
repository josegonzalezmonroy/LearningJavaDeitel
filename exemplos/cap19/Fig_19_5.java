// Figura 19.5 - InsertionSortTest.java
// Ordenando um array usando o algoritmo de ordenação por inserção.
import java.security.SecureRandom;
import java.util.Arrays;

public class Fig_19_5
{
   // método para ordenar o array utilizando o algoritmo de ordenação por inserção
   public static void insertionSort(int[] data)                
   {
      // percorre o array a partir do segundo elemento
      for (int next = 1; next < data.length; next++)
      {
         int insert = data[next]; // valor a ser inserido
         int moveItem = next; // posição onde o elemento será inserido

         // procura a posição correta para o elemento atual              
         while (moveItem > 0 && data[moveItem - 1] > insert)
         {
            // desloca os elementos uma posição para a direita
            data[moveItem] = data[moveItem - 1];
            moveItem--; // move para o próximo índice à esquerda
         } 

         // insere o elemento na posição correta    
         data[moveItem] = insert; 
         
         // exibe o estado do array após cada passagem do algoritmo
         printPass(data, next, moveItem);  
      }                                             
   }

   // método para exibir o estado do array após cada passagem do algoritmo
   public static void printPass(int[] data, int pass, int index)
   {
      System.out.printf("depois da passagem %2d: ", pass);

      // exibe os elementos até o item que foi inserido
      for (int i = 0; i < index; i++)
         System.out.printf("%d  ", data[i]);

      System.out.printf("%d* ", data[index]); // indica o item que foi inserido

      // exibe o restante do array
      for (int i = index + 1; i < data.length; i++)
         System.out.printf("%d  ", data[i]);

      System.out.printf("%n               "); // para alinhamento

      // indica a parte do array que já está ordenada
      for(int i = 0; i <= pass; i++)
         System.out.print("--  ");
      System.out.println();
   } 

   public static void main(String[] args)
   {
      SecureRandom generator = new SecureRandom();

      int[] data = new int[10]; // cria um array com 10 elementos

      // preenche o array com números aleatórios entre 10 e 99
      for (int i = 0; i < data.length; i++) 
         data[i] = 10 + generator.nextInt(90);

      // exibe o array não ordenado
      System.out.printf("Array não ordenado:%n%s%n%n", Arrays.toString(data)); 
      
      insertionSort(data); // ordena o array utilizando o método insertionSort

      // exibe o array já ordenado
      System.out.printf("Array ordenado:%n%s%n%n", Arrays.toString(data)); 
   } 
} // fim da classe InsertionSortTest
