// 21.17 - Processando uma árvore de pesquisa binária de Strings
// Escreva um programa com base no programa das figuras 21.17 e 21.18 que insere uma linha de texto, tokeniza-o em palavras separadas, insere as palavras em uma árvore de pesquisa binária e imprime percursos na ordem, pré-ordem e pós-ordem da árvore.
import java.util.Scanner;
import com.deitel.datastructures.Tree;

public class Exerc_21_17 
{
    public static void main(String[] args) 
    {
        // Cria um scanner para entrada de dados
        Scanner input = new Scanner(System.in);
        
        // Cria uma árvore de strings
        Tree<String> treeString = new Tree<>();

        // Solicita ao usuário que digite uma frase
        System.out.print("Digite uma frase: ");
        
        // Lê a frase digitada
        String frase = input.nextLine();
        
        // Remove pontos e vírgulas da frase
        String fraseLimpa = frase.replaceAll("[.,]", "");
        
        // Divide a frase em palavras, convertendo todas para minúsculas e ignorando múltiplos espaços
        String[] listaFrase = fraseLimpa.toLowerCase().split("\\s+");

        // Insere cada palavra na árvore
        for (String string : listaFrase) 
            treeString.insertNode(string);

        // Realiza a travessia em-ordem (inorder) e imprime os nós da árvore
        System.out.printf("%nEm-ordem%n");
        treeString.inorderTraversal(); 
        
        // Realiza a travessia pré-ordem (preorder) e imprime os nós da árvore
        System.out.printf("%n%nPre-ordem%n");
        treeString.preorderTraversal(); 
      
        // Realiza a travessia pós-ordem (postorder) e imprime os nós da árvore
        System.out.printf("%n%nPos-ordem%n");
        treeString.postorderTraversal(); 
    }
}
