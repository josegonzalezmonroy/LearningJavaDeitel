// 21.26 - Inserção/exclusão em qualquer lugar em uma lista encadeada
// Nossa classe de lista encadeada permitiu inserções e exclusões no início e no fim da lista encadeada. Essas capacidades foram convenientes para nós quando utilizamos herança ou composição para produzir uma classe de pilha e uma classe de fila com uma quantidade mínima de código simplesmente reutilizando a classe de lista. As listas encadeadas são normalmente mais gerais que aquelas que fornecemos. Modifique a classe da lista encadeada que desenvolvemos neste capítulo para tratar inserções e exclusões em qualquer lugar da lista. Crie diagramas comparáveis àqueles das figuras 21.6 (insertAtFront), 21.7 (insertAtBack), 21.8 (removeFromFront) e 21.9 (removeFromBack) que mostram como inserir um novo nó no meio de uma lista encadeada e como remover um nó existente do meio de uma lista encadeada.
import com.deitel.datastructures.List;

public class Exerc_21_26
{
    public static void main(String[] args) 
    {
        // Criacao de uma nova lista encadeada
        List<String> list = new List<>();

        // Inserindo elementos no final da lista
        System.out.println("Inserindo A, B, C e D no final da lista:");
        list.insertAtBack("A");
        list.insertAtBack("B");
        list.insertAtBack("C");
        list.insertAtBack("D");
        list.print(); // Deve mostrar A -> B -> C -> D

        // Inserindo elemento no indice 2 (meio da lista)
        System.out.println("\nInserindo X na posicao 2:");
        list.insertAt(2, "X");
        list.print(); // Deve mostrar A -> B -> X -> C -> D

        // Tentando inserir elemento em uma posicao invalida (-1)
        System.out.println("\nTentando inserir T em posicao invalida (-1):");
        try 
        {
            list.insertAt(-1, "T");
        } 
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("Erro: " + e.getMessage());
        }

        // Removendo o elemento na posicao 3
        System.out.println("\nRemovendo elemento na posicao 3:");
        list.removeAt(3);
        list.print(); // Deve mostrar A -> B -> X -> D

        // Tentando remover elemento em uma posicao invalida (fora dos limites)
        System.out.println("\nTentando remover elemento em posicao invalida (fora dos limites):");
        try 
        {
            list.removeAt(10);
        } 
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }    
}
