// Figura 18.9 - FactorialCalculator.java
// Metodo fatorial iterativo

public class Fig_18_9
{
   // declaracao recursiva de metodo fatorial
   public static long factorial(long number)
   {
      long result = 1;

      // declaracao iterativa de metodo fatorial
      for (long i = number; i >= 1; i--)
         result *= i;

      return result;
   } 

   // gera saida de fatoriais para valores de 0 a 10
   public static void main(String[] args)
   {
      // calcula o fatorial de 0 a 10
      for (int counter = 0; counter <= 10; counter++)
         System.out.printf("%d! = %d%n", counter, factorial(counter));
   }
}