// 21.24 - Travessia na ordem de nível de árvore binária
// O programa das figuras 21.17 e 21.18 ilustrou os três métodos recursivos de atravessar uma árvore binária — travessias na ordem, pré-ordem e pós-ordem. Esse exercício apresenta o percurso na ordem de nível de uma árvore binária, em que os valores de nó são impressos nível por nível, iniciando no nível do nó raiz. Os nós em cada nível são impressos da esquerda para a direita. O percurso na ordem de nível não é um algoritmo recursivo. Ele utiliza um objeto fila para controlar a saída dos nós.
import com.deitel.datastructures.Tree;

public class Exerc_21_24 
{
    public static void main(String[] args) 
    {
        // Criacao da arvore binaria
        Tree<Integer> tree = new Tree<>();

        // Insercao de nos na arvore
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(9);
        tree.insertNode(2);
        tree.insertNode(4);
        tree.insertNode(6);
        tree.insertNode(16);
        tree.insertNode(20);

        System.out.println("Inorder:");
        tree.inorderTraversal();
        System.out.println("Postorder:");
        tree.postorderTraversal();
        System.out.println("Level order:");
        tree.levelOrder();

    }    
}
