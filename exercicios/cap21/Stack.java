import com.deitel.datastructures.List;
import com.deitel.datastructures.EmptyListException;
// Classe Stack que implementa uma pilha utilizando uma lista encadeada
public class Stack<T>
{
    private List<T> stackList; // Lista que armazena os elementos da pilha

    // Construtor da pilha, inicializa uma nova lista
    public Stack() 
    { 
       stackList = new List<T>("pilha"); 
    } 
 
    // Metodo para adicionar um elemento no topo da pilha
    public void push(T object)
    { 
       stackList.insertAtFront(object); // Insere o objeto no inicio da lista (topo da pilha)
    } 
 
    // Metodo para remover um elemento do topo da pilha
    public T pop() throws EmptyListException
    { 
       return stackList.removeFromFront(); // Remove o elemento do inicio da lista (topo da pilha)
    } 
 
    // Verifica se a pilha esta vazia
    public boolean isEmpty() 
    { 
       return stackList.isEmpty(); // Retorna verdadeiro se a lista estiver vazia
    } 
 
    // Exibe os elementos da pilha
    public void print() 
    { 
       stackList.print(); // Imprime os elementos da lista
    } 
}
