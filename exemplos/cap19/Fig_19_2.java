// Figura 19.2 - LinearSearchTest.java
// Pesquisa sequencial em um array para encontrar um item.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Fig_19_2
{
   // realiza uma busca linear nos dados              
   public static int linearSearch(int data[], int searchKey)       
   {                                                   
      // percorre o array sequencialmente               
      for (int index = 0; index < data.length; index++)
         if (data[index] == searchKey)                 
            return index; // retorna o índice do inteiro encontrado   

      return -1; // inteiro nao foi encontrado
   } // fim do método linearSearch          

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      int[] data = new int[10]; // cria um array de 10 elementos

      // preenche o array com valores aleatórios entre 10 e 99
      for (int i = 0; i < data.length; i++) 
         data[i] = 10 + generator.nextInt(90);

      // exibe o conteúdo do array
      System.out.printf("%s%n%n", Arrays.toString(data)); 

      // obtém a entrada do usuário
      System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
      int searchInt = input.nextInt(); 

      // continua solicitando entradas até que -1 seja inserido
      while (searchInt != -1)
      {
         int position = linearSearch(data, searchInt); // realiza a busca

         if (position == -1) // nao encontrado
            System.out.printf("%d nao foi encontrado%n%n", searchInt); 
         else // encontrado
            System.out.printf("%d foi encontrado na posiçao %d%n%n", 
               searchInt, position);

         // obtém a próxima entrada do usuário
         System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
         searchInt = input.nextInt();
      } 
   } // fim do método main
} // fim da classe LinearSearchTest
