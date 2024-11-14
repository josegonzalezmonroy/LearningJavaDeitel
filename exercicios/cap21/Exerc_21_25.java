// 21.25 - Imprimindo árvores 
/* Modifique a classe Tree da Figura 21.17 para incluir um método outputTree recursivo a fim de exibir um objeto de árvore binária. O método deve gerar saída da árvore linha por linha com o topo da árvore na parte esquerda da tela e a parte inferior da árvore em direção à parte direita da tela. Cada linha é enviada para a saída verticalmente. Por exemplo, a árvore binária ilustrada na Figura 21.20 é enviada para a saída, como mostrado na Figura 21.21.

O nó mais à direita da folha aparece na parte superior da saída na coluna mais à direita e o nó raiz aparece à esquerda da saída. Cada coluna inicia cinco espaços à direita da coluna precedente. O método outputTree deve receber um argumento totalSpaces para representar o número de espaços que precedem o valor a ser enviado para a saída. (Essa variável deve iniciar em zero de modo que o nó raiz seja enviado para a saída à esquerda da tela.) O método utiliza uma travessia na ordem modificada para dar a saída à árvore — ele inicia no nó mais à direita na árvore e segue para a esquerda.

Enquanto a referência ao nó atual for nula, apresente o seguinte:
    Invoque recursivamente outputTree com a subárvore direita do nó atual e
        totalSpaces + 5.
    Utilize uma declaração for para contar de 1 a totalSpaces e forneça espaços.
    Forneça o valor no nó atual.
    Estabeleça a referência ao nó atual para se referir à subárvore esquerda do nó atual.
    Aumente o totalSpaces por 5.
*/
import com.deitel.datastructures.Tree;

public class Exerc_21_25 
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
        tree.insertNode(14);
        tree.insertNode(11);
        tree.insertNode(24);
        tree.insertNode(15);
        tree.insertNode(19);
        tree.insertNode(1);

        System.out.println("Tree:");
        tree.outputTree();
    }        
}
