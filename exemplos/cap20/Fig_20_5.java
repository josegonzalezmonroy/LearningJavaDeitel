// Figura 20.5 - MaximumTest.java
// O método genérico maximum retorna o maior de três objetos.

public class Fig_20_5
{
   public static void main(String[] args) 
   {
      // Exibe o maior valor entre três inteiros
      System.out.printf("Maior de %d, %d e %d é %d%n%n", 3, 4, 5, 
         maximum(3, 4, 5));
         
      // Exibe o maior valor entre três números decimais
      System.out.printf("Maior de %.1f, %.1f e %.1f é %.1f%n%n", 
         6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
         
      // Exibe o maior valor entre três strings (comparação lexicográfica)
      System.out.printf("Maior de %s, %s e %s é %s%n", "pear", 
         "apple", "orange", maximum("pear", "apple", "orange"));
   } 

   // Determina o maior de três objetos que implementam a interface Comparable
   public static <T extends Comparable<T>> T maximum(T x, T y, T z)
   {
      T max = x; // assume que x é o maior inicialmente

      // Compara y com max, se y for maior, ele se torna o novo max
      if (y.compareTo(max) > 0)
         max = y; // y é o maior até agora

      // Compara z com max, se z for maior, ele se torna o novo max
      if (z.compareTo(max) > 0)
         max = z; // z é o maior

      return max; // retorna o maior objeto
   }
} // fim da classe MaximumTest
