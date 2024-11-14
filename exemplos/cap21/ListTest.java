// Fig. 21.5: ListTest.java
// Classe ListTest para demonstrar as capacidades da classe List.
import com.deitel.datastructures.List;
import com.deitel.datastructures.EmptyListException;

public class ListTest 
{
   public static void main(String[] args)
   {
      List<Integer> list = new List<>(); 

      // insere inteiros na lista
      list.insertAtFront(-1);
      list.print();
      list.insertAtFront(0);
      list.print();
      list.insertAtBack(1);
      list.print();
      list.insertAtBack(5);
      list.print();

      // remove objetos da lista; imprime após cada remoção
      try 
      { 
         int removedItem = list.removeFromFront();
         System.out.printf("%n%d removido%n", removedItem);
         list.print();

         removedItem = list.removeFromFront();
         System.out.printf("%n%d removido%n", removedItem);
         list.print();

         removedItem = list.removeFromBack();
         System.out.printf("%n%d removido%n", removedItem);
         list.print();

         removedItem = list.removeFromBack();
         System.out.printf("%n%d removido%n", removedItem);
         list.print();
      } 
      catch (EmptyListException emptyListException) 
      {
         emptyListException.printStackTrace();
      } 
   } 
} // fim da classe ListTest
