// 21.16 - Permitindo duplicatas em uma árvore binária
// Modifique as figuras 21.17 e 21.18 para permitir que a árvore binária contenha duplicatas.

import java.security.SecureRandom;
import com.deitel.datastructures.Tree;

public class Exerc_21_16 
{
   public static void main(String[] args)
   {
      Tree<Integer> tree = new Tree<Integer>();
      SecureRandom randomNumber = new SecureRandom();

      System.out.println("Inserindo os seguintes valores: ");

      // insere 10 inteiros aleatorios de 0-9 na árvore 
      for (int i = 1; i <= 10; i++) 
      {
         int value = randomNumber.nextInt(10);
         System.out.printf("%d ", value);
         tree.insertNode(value);
      } 

      System.out.printf("%n%nTravessia pre-ordem%n");
      tree.preorderTraversal(); 

      System.out.printf("%n%nTravessia em-ordem%n");
      tree.inorderTraversal(); 

      System.out.printf("%n%nTravessia pos-ordem%n");
      tree.postorderTraversal(); 
      System.out.println();
   } 
} // fim da classe TreeTest
