// Figura 16.14 - StackTest.java
// classe Stack do pacote java.util

import java.util.Stack;
import java.util.EmptyStackException;

public class Fig_16_14
{
   public static void main(String[] args)
   {
      Stack<Number> stack = new Stack<>(); // cria uma Stack

      // utiliza o metodo push
      stack.push(12L); // insere o valor long 12L
      System.out.println("Pushed 12L");
      printStack(stack);
      stack.push(34567); // insere o valor int 34567
      System.out.println("Pushed 34567");
      printStack(stack);
      stack.push(1.0F); // insere o valor float 1.0F
      System.out.println("Pushed 1.0F");
      printStack(stack);
      stack.push(1234.5678); // insere o valor double 1234.5678
      System.out.println("Pushed 1234.5678 ");
      printStack(stack);

      // remove items de pilha
      try 
      {
         Number removedObject = null;

         // remove elementos da pilha
         while (true) 
         {
            removedObject = stack.pop(); // utiliza o metodo pop
            System.out.printf("Popped %s%n", removedObject);
            printStack(stack);
         } 
      } 
      catch (EmptyStackException emptyStackException) 
      {
         emptyStackException.printStackTrace();
      } 
   } 

   // exibe o conteudo de Stack
   private static void printStack(Stack<Number> stack)
   {
      if (stack.isEmpty())
         System.out.printf("stack is empty%n%n"); // a pilha esta vazia
      else // a pilha nao esta vazia
         System.out.printf("stack contains: %s (top)%n", stack);      
   } 
}