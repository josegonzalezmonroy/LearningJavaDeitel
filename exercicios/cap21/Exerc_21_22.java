// 21.22 - Exclusão de árvore binária
/* Neste exercício, discutimos a exclusão de itens de árvores de pesquisa binária. O algoritmo de exclusão não é tão simples e direto quanto o algoritmo de inserção. Três casos são encontrados ao excluir-se um item — o item está contido em um nó de folha (isto é, não tem filhos), o item está contido em um nó que tem um filho ou está em um nó que tem dois filhos.

Se o item a ser excluído está contido em um nó de folha, o nó é excluído e a referência no nó pai é configurada como nula.

Se o item a ser excluído está contido em um nó com um filho, a referência no nó pai é configurada para referenciar o nó filho e o nó contendo o item de dados é excluído. Isso faz com que o nó filho tome o lugar do nó excluído na árvore.

O último caso é o mais difícil. Quando um nó com dois filhos é excluído, outro nó na árvore deve tomar seu lugar. Entretanto, a referência no nó pai simplesmente não pode ser atribuída para referenciar um dos filhos do nó a ser excluído. Na maioria dos casos, a árvore de pesquisa binária resultante não incorporaria a seguinte característica das árvores de pesquisa binária (sem valores duplicados): os valores em qualquer subárvore esquerda são menores que o valor no nó pai e os valores em qualquer subárvore direita são maiores que o valor no nó pai.

Qual é o nó utilizado como um nó substituto para manter essa característica? É o nó contendo o maior valor na árvore menor que o valor no nó que está sendo excluído, ou o nó contendo o menor valor na árvore maior que o valor no nó que está sendo excluído? Vamos considerar o nó com o menor valor. Em uma árvore de pesquisa binária, o valor maior menor que um valor do pai encontra-se na subárvore esquerda do nó pai e seguramente estará contido no nó mais à direita da subárvore. Esse nó é encontrado descendo a subárvore esquerda pela direita até que a referência ao filho direito do nó atual seja nula. Agora estamos referenciando o nó substituto, que é um nó de folha ou um nó com um filho à sua esquerda. Se o nó substituto for um nó de folha, os passos para realizar a exclusão são os seguintes:

a) Armazene a referência ao nó a ser excluído em uma variável de referência temporária.

b) Configure a referência no pai do nó sendo excluído para referenciar o nó substituto.

c) Configure a referência no pai do nó substituto como null.

d) Configure a referência como a subárvore direita no nó substituto para referenciar a subárvore direita do nó a ser excluído.

e) Configure a referência como a subárvore esquerda no nó substituto para referenciar a subárvore esquerda do nó a ser excluído.

Os passos de exclusão para um nó substituto com um filho esquerdo são semelhantes àqueles para um nó substituto sem filhos, mas o algoritmo também deve mover o filho para a posição do nó substituto na árvore. Se o nó substituto for um nó com um filho esquerdo, os passos a realizar a exclusão são como segue:

a) Armazene a referência ao nó a ser excluído em uma variável de referência temporária.

b) Configure a referência no pai do nó sendo excluído para referenciar o nó substituto.

c) Configure a referência no pai do nó substituto para referenciar o filho esquerdo do nó substituto.

d) Configure a referência como a subárvore direita no nó substituto para referenciar a subárvore direita do nó a ser excluído.

e) Configure a referência como a subárvore esquerda no nó substituto para referenciar a subárvore esquerda do nó a ser excluído.

Escreva o método deleteNode, que aceita como seu argumento o valor a ser excluído. O método deleteNode deve localizar na árvore o nó que contém o valor a ser excluído e utilizar os algoritmos discutidos aqui para excluir o nó. Se o valor não for encontrado na árvore, o método deve exibir uma mensagem indicando isso. Modifique o programa das figuras 21.17 e 21.18 para utilizar esse método. Depois de excluir um item, chame os métodos inorderTraversal, preorderTraversal e postorderTraversal para confirmar que a operação de exclusão foi realizada corretamente.*/
import com.deitel.datastructures.Tree; 

public class Exerc_21_22 
{
    public static void main(String[] args) 
    {
        // Criacao da arvore binaria
        Tree<Integer> tree = new Tree<>();

        // Insercao de nos na arvore
        System.out.println("Inserindo nos na arvore:");
        tree.insertNode(10);
        tree.insertNode(1);
        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(8);
        
        // Exibe a travessia em ordem
        System.out.println("arvore apos insercoes:");
        tree.inorderTraversal();
        System.out.println();

        // Remocao de um no com dois filhos
        int valueToRemove = 5;
        System.out.println("Removendo o valor: " + valueToRemove);
        tree.deleteNode(valueToRemove);
        
        // Exibe a travessia em ordem apos a remocao
        System.out.println("arvore apos remocao do valor " + valueToRemove + ":");
        tree.inorderTraversal();
        System.out.println();

        // Remocao de um no com um filho
        valueToRemove = 1;
        System.out.println("Removendo o valor: " + valueToRemove);
        tree.deleteNode(valueToRemove);
        
        // Exibe a travessia em ordem apos a remocao
        System.out.println("arvore apos remocao do valor " + valueToRemove + ":");
        tree.inorderTraversal();
        System.out.println();

        // Remocao de uma folha
        valueToRemove = 8;
        System.out.println("Removendo o valor: " + valueToRemove);
        tree.deleteNode(valueToRemove);
        
        // Exibe a travessia em ordem apos a remocao
        System.out.println("arvore apos remocao do valor " + valueToRemove + ":");
        tree.inorderTraversal();
        System.out.println();

        // Teste de remocao de um valor que nao existe na arvore
        valueToRemove = 99;
        System.out.println("Tentando remover o valor: " + valueToRemove);
        tree.deleteNode(valueToRemove);
        
        // Exibe a travessia em ordem apos a tentativa de remocao
        System.out.println("\narvore apos tentativa de remocao do valor " + valueToRemove + ":");
        tree.inorderTraversal();
    }    
}
