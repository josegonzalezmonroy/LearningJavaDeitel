// Fig. 21.14: QueueTest.java
// Classe QueueTest.
import com.deitel.datastructures.Queue;
import com.deitel.datastructures.EmptyListException;

public class QueueTest 
{
   public static void main(String[] args)
   {
      Queue<Integer> queue = new Queue<>();  

      // usa o método enqueue
      queue.enqueue(-1);
      queue.print();
      queue.enqueue(0);
      queue.print();
      queue.enqueue(1);
      queue.print();
      queue.enqueue(5);
      queue.print();

      // remove objetos da fila
      try 
      {
         int removedItem;

         while (true) 
         {
            removedItem = queue.dequeue(); // usa o método dequeue
            System.out.printf("%n%d removido da fila%n", removedItem);
            queue.print();
         } 
      } 
      catch (EmptyListException emptyListException) 
      {
         emptyListException.printStackTrace();
      } 
   } 
} // fim da classe QueueTest
