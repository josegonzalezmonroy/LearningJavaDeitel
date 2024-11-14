// SortComparison.java
// Comparando o desempenho dos metodos sort e parallelSort da classe Arrays.
import java.time.Duration;
import java.time.Instant;
import java.text.NumberFormat;
import java.util.Arrays;
import java.security.SecureRandom;

public class SortComparison
{
   public static void main(String[] args)
   {
      SecureRandom random = new SecureRandom();

      // cria um array de inteiros aleatorios e o copia
      int[] array1 = random.ints(15_000_000).toArray();
      int[] array2 = new int[array1.length];
      System.arraycopy(array1, 0, array2, 0, array1.length);

      // tempo a ordenacao de array1 usando o metodo sort da classe Arrays 
      System.out.println("Iniciando a ordenacao");
      Instant sortStart = Instant.now(); 
      Arrays.sort(array1); 
      Instant sortEnd = Instant.now();

      // exibe os resultados do tempo
      long sortTime = Duration.between(sortStart, sortEnd).toMillis();
      System.out.printf("Tempo total em milissegundos: %d%n%n", sortTime);

      // tempo a ordenacao de array2 usando o metodo parallelSort da classe Arrays
      System.out.println("Iniciando parallelSort");
      Instant parallelSortStart = Instant.now(); 
      Arrays.parallelSort(array2); 
      Instant parallelSortEnd = Instant.now();

      // exibe os resultados do tempo
      long parallelSortTime = 
         Duration.between(parallelSortStart, parallelSortEnd).toMillis();
      System.out.printf("Tempo total em milissegundos: %d%n", 
         parallelSortTime);

      // exibe a diferenca de tempo como uma porcentagem
      String percentage = NumberFormat.getPercentInstance().format(
         (double) sortTime / parallelSortTime);
      System.out.printf("%nsort levou %s mais tempo que parallelSort%n", 
         percentage);
   }
}
