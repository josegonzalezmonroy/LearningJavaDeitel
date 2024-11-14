// Fig. 21.18: TreeTest.java
// Programa de teste da árvore binária.
import java.security.SecureRandom;
import com.deitel.datastructures.Tree;

public class TreeTest 
{
   public static void main(String[] args)
   {
      Tree<Integer> tree = new Tree<Integer>();
      SecureRandom randomNumber = new SecureRandom();

      System.out.println("Inserindo os seguintes valores: ");

      // insere 10 inteiros aleatórios de 0-99 na árvore 
      for (int i = 1; i <= 10; i++) 
      {
         int value = randomNumber.nextInt(100);
         System.out.printf("%d ", value);
         tree.insertNode(value);
      } 

      System.out.printf("%n%nTravessia pré-ordem%n");
      tree.preorderTraversal(); 

      System.out.printf("%n%nTravessia em-ordem%n");
      tree.inorderTraversal(); 

      System.out.printf("%n%nTravessia pós-ordem%n");
      tree.postorderTraversal(); 
      System.out.println();
   } 
} // fim da classe TreeTest
