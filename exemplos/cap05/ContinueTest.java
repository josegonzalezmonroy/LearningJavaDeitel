// Figura 5.14 - ContinueTest.java
// continue statement terminating an iteration of a for statement.

public class ContinueTest 
{
   public static void main(String[] args)
   {
      for (int count = 1; count <= 10; count++) // loop 10 vezes
      {  
         if (count == 5) 
            continue; // pula o código restante no corpo do loop se count for 5

         System.out.printf("%d ", count);
      } 

      System.out.printf("%nUsed continue to skip printing 5%n");
   }
} // fim da classe ContinueTest
