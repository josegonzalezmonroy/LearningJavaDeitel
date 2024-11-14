// Fig. 21.12: StackCompositionTest.java
// Classe StackCompositionTest.
import com.deitel.datastructures.StackComposition;
import com.deitel.datastructures.EmptyListException;

public class StackCompositionTest 
{
   public static void main(String[] args)
   {
      StackComposition<Integer> stack = new StackComposition<>();

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
} // fim da classe StackCompositionTest
