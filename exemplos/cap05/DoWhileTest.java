// Figura 5.7 - DoWhileTest.java
// Declaração de repetição do...while.

public class DoWhileTest 
{  
   public static void main(String[] args)
   {
      int counter = 1; 

      do 
      {
         System.out.printf("%d  ", counter);
         ++counter;
      } while (counter <= 10); // fim do do...while 

      System.out.println(); 
   } 
} // fim da classe DoWhileTest
