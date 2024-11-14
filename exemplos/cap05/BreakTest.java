// Figura 5.13 - BreakTest.java
// break statement exiting a for statement.

public class BreakTest 
{
   public static void main(String[] args)
   {
      int count; // variável de controle também usada após a terminação do loop
      
      for (count = 1; count <= 10; count++) // loop 10 vezes
      {  
         if (count == 5)  
            break; // termina o loop se count for 5

         System.out.printf("%d ", count);
      }

      System.out.printf("%nBroke out of loop at count = %d%n", count);
   } 
} // fim da classe BreakTest
