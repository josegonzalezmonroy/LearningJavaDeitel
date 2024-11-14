// Figura 19.4 - SelectionSortTest.java
// Ordenando um array usando o algoritmo de ordenaçao por seleçao.
import java.security.SecureRandom;
import java.util.Arrays;

public class Fig_19_4
{
   // método para ordenar o array utilizando ordenaçao por seleçao
   public static void selectionSort(int[] data)              
   {
      // percorre os elementos até o penúltimo do array
      for (int i = 0; i < data.length - 1; i++)
      {
         int smallest = i; // define o primeiro índice do subarray restante

         // loop para encontrar o índice do menor elemento no subarray
         for (int index = i + 1; index < data.length; index++)
            if (data[index] < data[smallest]) // verifica se há um menor valor
               smallest = index; // atualiza o índice do menor elemento

         // troca o menor elemento encontrado com o elemento atual
         swap(data, i, smallest); 
         
         // exibe o estado do array após cada passagem
         printPass(data, i + 1, smallest);  
      }                                          
   } // fim do método selectionSort                                    

   // método auxiliar para trocar os valores em dois índices do array
   private static void swap(int[] data, int first, int second)
   {
      int temporary = data[first]; // armazena o valor do primeiro elemento temporariamente
      data[first] = data[second]; // substitui o primeiro pelo segundo
      data[second] = temporary; // coloca o valor temporário na posiçao do segundo
   } 

   // método para exibir o estado do array após cada passagem do algoritmo
   private static void printPass(int[] data, int pass, int index)
   {
      System.out.printf("depois da passagem %2d: ", pass);

      // exibe os elementos até o índice selecionado
      for (int i = 0; i < index; i++)
         System.out.printf("%d  ", data[i]);

      System.out.printf("%d* ", data[index]); // indica a troca feita

      // exibe o restante do array
      for (int i = index + 1; i < data.length; i++)
         System.out.printf("%d  ", data[i]);

      System.out.printf("%n               "); // para alinhamento

      // indica a parte do array que já está ordenada
      for (int j = 0; j < pass; j++)
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

      // exibe o array nao ordenado
      System.out.printf("Array nao ordenado:%n%s%n%n", Arrays.toString(data)); 
      
      selectionSort(data); // ordena o array utilizando o método selectionSort

      // exibe o array já ordenado
      System.out.printf("Array ordenado:%n%s%n%n", Arrays.toString(data)); 
   } 
} // fim da classe SelectionSortTest
