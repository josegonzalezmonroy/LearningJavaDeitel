// Fig. 21.11: StackInheritanceTest.java
// Programa de manipulação de pilha.
import com.deitel.datastructures.StackInheritance;
import com.deitel.datastructures.EmptyListException;

public class StackInheritanceTest 
{
   public static void main(String[] args)
   {
      StackInheritance<Integer> stack = new StackInheritance<>();  

      // usa o método push
      stack.push(-1);
      stack.print();
      stack.push(0);
      stack.print();
      stack.push(1);
      stack.print();
      stack.push(5);
      stack.print();

      // remove itens da pilha
      try 
      {
         int removedItem;

         while (true) 
         {
            removedItem = stack.pop(); // usa o método pop
            System.out.printf("%n%d removido%n", removedItem);
            stack.print();
         } 
      } 
      catch (EmptyListException emptyListException) 
      {
         emptyListException.printStackTrace();
      } 
   } 
} // fim da classe StackInheritanceTest
