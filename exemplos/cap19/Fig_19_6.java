// Figura 19.6 - MergeSortTest.java
// Ordenando um array utilizando o algoritmo merge sort.
import java.security.SecureRandom;
import java.util.Arrays;

public class Fig_19_6
{
   // Método principal para chamar a funçao de ordenaçao recursiva
   public static void mergeSort(int[] data)
   {
      sortArray(data, 0, data.length - 1); // Ordena o array inteiro
   } 

   // Funçao recursiva que divide o array, ordena e depois mescla os subarrays
   private static void sortArray(int[] data, int low, int high) 
   {
      // Testa o caso base; o tamanho do array é igual a 1
      if ((high - low) >= 1) // Se nao for o caso base
      {
         int middle1 = (low + high) / 2; // Calcula o meio do array
         int middle2 = middle1 + 1; // Próximo elemento após o meio     

         // Exibe o passo da divisao
         System.out.printf("divisao:   %s%n", subarrayString(data, low, high));
         System.out.printf("           %s%n", subarrayString(data, low, middle1));
         System.out.printf("           %s%n%n", subarrayString(data, middle2, high));

         // Divide o array ao meio e ordena cada metade (chamadas recursivas)
         sortArray(data, low, middle1);    // Ordena a primeira metade       
         sortArray(data, middle2, high);   // Ordena a segunda metade      

         // Mescla os dois subarrays ordenados
         merge(data, low, middle1, middle2, high);             
      } 
   } 
   
   // Mescla dois subarrays ordenados em um único subarray ordenado
   private static void merge(int[] data, int left, int middle1, int middle2, int right)
   {
      int leftIndex = left; // Indice para o subarray da esquerda              
      int rightIndex = middle2; // Indice para o subarray da direita         
      int combinedIndex = left; // Indice para o array combinado temporário
      int[] combined = new int[data.length]; // Array temporário        

      // Exibe os dois subarrays antes de mesclar
      System.out.printf("mescla:   %s%n", subarrayString(data, left, middle1));
      System.out.printf("           %s%n", subarrayString(data, middle2, right));

      // Mescla os arrays até que um dos lados esteja esgotado
      while (leftIndex <= middle1 && rightIndex <= right)
      {
         // Coloca o menor dos dois elementos atuais no array resultante
         if (data[leftIndex] <= data[rightIndex])        
            combined[combinedIndex++] = data[leftIndex++]; 
         else                                                  
            combined[combinedIndex++] = data[rightIndex++];
      } 
   
      // Se o subarray da esquerda estiver vazio, copia o restante do subarray da direita
      if (leftIndex == middle2)                              
         while (rightIndex <= right)                         
            combined[combinedIndex++] = data[rightIndex++];
      else // Se o subarray da direita estiver vazio, copia o restante do subarray da esquerda
         while (leftIndex <= middle1)                        
            combined[combinedIndex++] = data[leftIndex++]; 

      // Copia os valores de volta para o array original
      for (int i = left; i <= right; i++)  
         data[i] = combined[i];          

      // Exibe o array mesclado
      System.out.printf("           %s%n%n", subarrayString(data, left, right));
   } 

   // Método para exibir certos valores do array
   private static String subarrayString(int[] data, int low, int high)
   {
      StringBuilder temporary = new StringBuilder();

      // Adiciona espaços para alinhamento
      for (int i = 0; i < low; i++)
         temporary.append("   ");

      // Exibe os elementos restantes do array
      for (int i = low; i <= high; i++)
         temporary.append(" " + data[i]);

      return temporary.toString();
   }

   public static void main(String[] args)
   {
      SecureRandom generator = new SecureRandom();

      int[] data = new int[10]; // Cria um array com 10 elementos

      // Preenche o array com números aleatórios entre 10 e 99
      for (int i = 0; i < data.length; i++) 
         data[i] = 10 + generator.nextInt(90);

      // Exibe o array nao ordenado
      System.out.printf("Array nao ordenado:%n%s%n%n", Arrays.toString(data)); 
      
      // Ordena o array utilizando o merge sort
      mergeSort(data); 

      // Exibe o array ordenado
      System.out.printf("Array ordenado:%n%s%n%n", Arrays.toString(data)); 
   } 
} 
