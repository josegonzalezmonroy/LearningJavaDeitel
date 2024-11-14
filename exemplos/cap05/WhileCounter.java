// Figura 5.1 - WhileCounter.java
// Repetição controlada por contador com a instrução de repetição while.

public class WhileCounter 
{
   public static void main(String[] args) 
   {      
      int counter = 1; // declarar e inicializar a variável de controle

      while (counter <= 10) // condição de continuação do loop
      {
         System.out.printf("%d  ", counter);
         ++counter; // incrementar a variável de controle 
      } 

      System.out.println(); 
   } 
} // fim da classe WhileCounter
