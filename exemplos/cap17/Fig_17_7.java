// Figura 17.7 - ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fig_17_7 
{
       public static void main(String[] args)
   {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // exibe strings originais
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings em maiusculas
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)
               .map(String::toUpperCase)
               .collect(Collectors.toList()));

      // strings menores que "m" (sem distincao maiusc/minusc) em ordem crescente
      System.out.printf("strings greater than m sorted ascending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));

    // strings menores que "m" (com distincao maiusc/minusc) em ordem decrescente
      System.out.printf("strings greater than m sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));
   }
}
