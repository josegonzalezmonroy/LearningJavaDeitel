// 21.30 - Classe Queue que é herdada de uma classe List
// Na Seção 21.5, criamos uma classe de pilha da classe List com a herança (Figura 21.10) e com a composição (Figura 21.12). Na Seção 21.6, criamos uma classe queue a partir da classe List com composição (Figura 21.13). Crie uma classe queue herdando da classe List. Quais as diferenças entre essa classe e aquela criada com a composição?
import com.deitel.datastructures.Queue;

public class Exerc_21_29 
{
    public static void main(String[] args) 
    {
        Queue<String> queue = new Queue<>();

        // Teste de enfileiramento
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");

        System.out.println("Primeiro na fila: " + queue.peek()); // Deveria ser "Alice"

        // Teste de desenfileiramento
        System.out.println("Desenfileirado: " + queue.dequeue()); // Deveria ser "Alice"
        System.out.println("Novo primeiro na fila: " + queue.peek()); // Deveria ser "Bob"
    }    
}
