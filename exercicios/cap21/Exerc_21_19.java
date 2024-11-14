// 21.19 - Profundidade de uma árvore binária
// Modifique as figuras 21.17 e 21.18 de modo que a classe Tree forneça um método getDepth que determina quantos níveis estão na árvore. Teste o método em um aplicativo que insere 20 inteiros aleatórios em uma Tree.
import java.security.SecureRandom;
import com.deitel.datastructures.Tree;

public class Exerc_21_19 
{
    public static void main(String[] args) 
    {
        SecureRandom radom = new SecureRandom();
        Tree<Integer> tree = new Tree<>();
        
        // Insere 20 números aleatórios entre 1 e 20 na árvore
        for (int i = 0; i < 20; i++)
            tree.insertNode(1 + radom.nextInt(20));

        // Exibe a árvore em ordem (in-order)
        System.out.printf("Arvore em-ordem:%n");
        tree.inorderTraversal(); 
        
        // Exibe a profundidade da árvore
        System.out.println("\nProfundidade: " + tree.getDepth());
    }    
}
