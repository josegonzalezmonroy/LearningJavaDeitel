// 21.23 - Arvore de pesquisa binária
// Modifique a classe Tree da Figura 21.17 para incluir o método contains, que tenta localizar um valor especificado em um objeto de árvore de pesquisa binária. O método deve aceitar como um argumento uma chave de pesquisa a ser localizada.
import com.deitel.datastructures.Tree;

public class Exerc_21_23 
{
    public static void main(String[] args) 
    {
        // Cria uma nova arvore binaria
        Tree<Integer> tree = new Tree<>();

        // Insere nos na arvore
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(1);
        tree.insertNode(7);
        tree.insertNode(15);
        tree.insertNode(12);
        tree.insertNode(20);

        // Valores para testar se estao na arvore
        int[] valoresParaTestar = {7, 10, 15, 99};

        // Testa se os valores estao na arvore
        for (int valor : valoresParaTestar) 
        {
            if (tree.contains(valor) != null) 
            {
                System.out.println("Valor " + valor + " encontrado na arvore.");
            } 
            else 
            {
                System.out.println("Valor " + valor + " nao encontrado na arvore.");
            }
        }
    }    
}
