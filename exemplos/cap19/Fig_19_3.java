// Figura 19.3 - BinarySearchTest.java
// Utiliza a busca binária para localizar um item em um array.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Fig_19_3
{
   // realiza a busca binária nos dados
   public static int binarySearch(int[] data, int key)
   {
      int low = 0; // limite inferior da área de busca
      int high = data.length - 1; // limite superior da área de busca
      int middle = (low + high + 1) / 2; // elemento do meio
      int location = -1; // valor de retorno; -1 se nao encontrado

      do // loop para buscar o elemento
      {
         // imprime os elementos restantes no array
         System.out.print(remainingElements(data, low, high));

         // imprime espacos para alinhamento
         for (int i = 0; i < middle; i++)
            System.out.print("   ");
         System.out.println(" * "); // indica o elemento do meio

         // se o elemento for encontrado no meio
         if (key == data[middle])
            location = middle; // location é o meio atual
         else if (key < data[middle]) // o elemento do meio é muito grande
            high = middle - 1; // elimina a metade superior
         else // o elemento do meio é muito pequeno
            low = middle + 1; // elimina a metade inferior

         middle = (low + high + 1) / 2; // recalcula o meio
      } while ((low <= high) && (location == -1)); // continua enquanto nao achar ou esgotar a busca

      return location; // retorna a posicao do elemento buscado
   } // fim do método binarySearch

   // método para exibir certos valores no array
   private static String remainingElements(int[] data, int low, int high)
   {
      StringBuilder temporary = new StringBuilder();

      // adiciona espacos para alinhamento
      for (int i = 0; i < low; i++)
         temporary.append("   ");

      // adiciona os elementos restantes no array
      for (int i = low; i <= high; i++)
         temporary.append(data[i] + " ");

      return String.format("%s%n", temporary);
   } // fim do método remainingElements

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      int[] data = new int[15]; // cria um array

      // preenche o array com valores aleatórios entre 10 e 99
      for (int i = 0; i < data.length; i++)
         data[i] = 10 + generator.nextInt(90);

      Arrays.sort(data); // a busca binária exige o array ordenado
      System.out.printf("%s%n%n", Arrays.toString(data)); // exibe o array

      // recebe um valor inteiro do usuário
      System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
      int searchInt = input.nextInt();

      // repete a entrada de inteiros; -1 termina o programa
      while (searchInt != -1)
      {
         // realiza a busca binária
         int location = binarySearch(data, searchInt);

         if (location == -1) // nao encontrado
            System.out.printf("%d nao foi encontrado%n%n", searchInt);
         else // encontrado
            System.out.printf("%d foi encontrado na posicao %d%n%n", searchInt, location);

         // recebe outro valor do usuário
         System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
         searchInt = input.nextInt();
      }
   } // fim do método main
} // fim da classe BinarySearchTest
