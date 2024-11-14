// 17.14 - Mapeando e então reduzindo um IntStream para paralelização 
// A lambda que você passa para o método reduce de um fluxo deve ser associativa — isto é, independentemente da ordem em que as subexpressões são avaliadas, o resultado deve ser o mesmo. A expressão lambda nas linhas 34 a 36 da Figura 17.5 não é associativa. Se usasse fluxos paralelos (Capítulo 23, “Concorrência”) com essa lambda, você poderia obter resultados incorretos para a soma dos quadrados, dependendo da ordem em que as subexpressões são avaliadas. A maneira correta de implementar as linhas 34 a 36 seria primeiro mapear cada valor int para o quadrado desse valor e, então, reduzir o fluxo para a soma dos quadrados. Modifique a Figura 17.5 para implementar as linhas 34 a 36 dessa maneira.

import java.util.stream.IntStream;

public class Exerc_17_14 
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
        IntStream.of(values)                    // Cria um IntStream a partir do array values
                .map(x -> x * x)              // Mapeia cada valor para seu quadrado
                .reduce(0, Integer::sum));     // Reduz a stream somando os quadrados
  
      
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
