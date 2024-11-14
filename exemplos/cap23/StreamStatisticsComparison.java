// StreamStatisticsComparison.java
// Comparando o desempenho de operacoes sequenciais e paralelas de streams.
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;
import java.security.SecureRandom;

public class StreamStatisticsComparison
{
   public static void main(String[] args)
   {
      SecureRandom random = new SecureRandom();

      // cria um array de valores long aleatorios
      long[] values = random.longs(10_000_000, 1, 1001).toArray();
 
      // realiza os calculos separadamente
      Instant separateStart = Instant.now(); 
      long count = Arrays.stream(values).count();
      long sum = Arrays.stream(values).sum();
      long min = Arrays.stream(values).min().getAsLong();
      long max = Arrays.stream(values).max().getAsLong();
      double average = Arrays.stream(values).average().getAsDouble();
      Instant separateEnd = Instant.now(); 

      // exibe os resultados
      System.out.println("Calculos realizados separadamente");
      System.out.printf("    count: %,d%n", count);
      System.out.printf("      sum: %,d%n", sum);
      System.out.printf("      min: %,d%n", min);
      System.out.printf("      max: %,d%n", max);
      System.out.printf("  average: %f%n", average);
      System.out.printf("Tempo total em milissegundos: %d%n%n", 
         Duration.between(separateStart, separateEnd).toMillis());

      // tempo da operacao de soma com stream sequencial
      LongStream stream1 = Arrays.stream(values);
      System.out.println("Calculando estatisticas em stream sequencial");
      Instant sequentialStart = Instant.now(); 
      LongSummaryStatistics results1 = stream1.summaryStatistics();
      Instant sequentialEnd = Instant.now();

      // exibe os resultados
      displayStatistics(results1);
      System.out.printf("Tempo total em milissegundos: %d%n%n", 
         Duration.between(sequentialStart, sequentialEnd).toMillis());

      // tempo da operacao de soma com stream paralelo
      LongStream stream2 = Arrays.stream(values).parallel();
      System.out.println("Calculando estatisticas em stream paralelo");
      Instant parallelStart = Instant.now(); 
      LongSummaryStatistics results2 = stream2.summaryStatistics();
      Instant parallelEnd = Instant.now();

      // exibe os resultados
      displayStatistics(results2);
      System.out.printf("Tempo total em milissegundos: %d%n%n", 
         Duration.between(parallelStart, parallelEnd).toMillis());
   }

   // exibe os valores de LongSummaryStatistics
   private static void displayStatistics(LongSummaryStatistics stats)
   {
      System.out.println("Estatisticas");
      System.out.printf("    count: %,d%n", stats.getCount());
      System.out.printf("      sum: %,d%n", stats.getSum());
      System.out.printf("      min: %,d%n", stats.getMin());
      System.out.printf("      max: %,d%n", stats.getMax());
      System.out.printf("  average: %f%n", stats.getAverage());
   }
} // fim da classe StreamStatisticsComparison
