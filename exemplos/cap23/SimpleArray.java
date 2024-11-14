// Fig. 23.8: SimpleArray.java
// Classe que gerencia um array de inteiros para ser compartilhado por multiplas 
// threads com sincronizacao.
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray
{
   private static final SecureRandom generator = new SecureRandom();
   private final int[] array; // o array de inteiros compartilhado
   private int writeIndex = 0; // indice do proximo elemento a ser escrito

   // constroi um SimpleArray de um dado tamanho
   public SimpleArray(int size)
   {
      array = new int[size];
   } 

   // adiciona um valor ao array compartilhado
   public synchronized void add(int value)
   {
      int position = writeIndex; // armazena o indice de escrita

      try
      {
         // em aplicacoes reais, nao e recomendavel dormir enquanto estiver com o lock
         Thread.sleep(generator.nextInt(500)); // apenas para demonstracao 
      } 
      catch (InterruptedException ex)
      {
         Thread.currentThread().interrupt(); 
      } 

      // coloca o valor no elemento apropriado
      array[position] = value;
      System.out.printf("%s escreveu %2d no elemento %d.%n", 
         Thread.currentThread().getName(), value, position);

      ++writeIndex; // incrementa o indice do proximo elemento a ser escrito
      System.out.printf("Proximo indice de escrita: %d%n", writeIndex);
   } 
   
   // usado para exibir o conteudo do array de inteiros compartilhado
   public synchronized String toString()
   {
      return Arrays.toString(array);
   } 
} // fim da classe SimpleArray


