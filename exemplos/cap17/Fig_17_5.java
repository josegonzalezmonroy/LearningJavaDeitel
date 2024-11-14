// Figura 17.5 - IntStreamOperations.java
// Demonstrando operacoes IntStream

import java.util.stream.IntStream;

public class Fig_17_5 
{
   public static void main(String[] args)
    {
      int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

      // exibe valores originais
      System.out.print("Original values: ");
      IntStream.of(values)
               .forEach(value -> System.out.printf("%d ", value));
      System.out.println();

      // count, min, max, sum e average dos valores
      System.out.printf("%nCount: %d%n", IntStream.of(values).count());
      System.out.printf("Min: %d%n", 
         IntStream.of(values).min().getAsInt());
      System.out.printf("Max: %d%n", 
         IntStream.of(values).max().getAsInt());
      System.out.printf("Sum: %d%n", IntStream.of(values).sum());
      System.out.printf("Average: %.2f%n", 
         IntStream.of(values).average().getAsDouble());

      // soma dos valores com o metodo reduce
      System.out.printf("%nSum via reduce method: %d%n", 
         IntStream.of(values)                      
                  .reduce(0, (x, y) -> x + y));
      
      // soma das raizes quadradas dos valores com o metodo reduce
      System.out.printf("Sum of squares via reduce method: %d%n", 
         IntStream.of(values)                   
                  .reduce(0, (x, y) -> x + y * y));
      
      // produto dos valores com o metodo reduce
      System.out.printf("Product via reduce method: %d%n", 
         IntStream.of(values)
                  .reduce(1, (x, y) -> x * y));
      
      // valores pares exibidos em ordem classificada
      System.out.printf("%nEven values displayed in sorted order: "); 
      IntStream.of(values)
               .filter(value -> value % 2 == 0)
               .sorted()
               .forEach(value -> System.out.printf("%d ", value));
      System.out.println();
   
      // valores impares multiplicados por 10 e exibidos em ordem classificada
      System.out.printf(
         "Odd values multiplied by 10 displayed in sorted order: "); 
      IntStream.of(values)
               .filter(value -> value % 2 != 0)
               .map(value -> value * 10)
               .sorted()
               .forEach(value -> System.out.printf("%d ", value));
      System.out.println();

      // soma o intervalo dos numeros inteiros de 1 a 10, exclusivo
      System.out.printf("%nSum of integers from 1 to 9: %d%n",
         IntStream.range(1, 10).sum());

      // soma o intervalo dos numeros inteiros de 1 a 10, inclusive
      System.out.printf("Sum of integers from 1 to 10: %d%n",
         IntStream.rangeClosed(1, 10).sum());
    }     
}
