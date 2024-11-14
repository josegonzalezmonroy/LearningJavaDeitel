// Figura 20.7 - Stack.java
// Declaração de uma classe genérica Stack.
import java.util.ArrayList;

public class Stack<T>  
{
   // ArrayList armazena os elementos da pilha
   private final ArrayList<T> elements;

   // Construtor sem argumentos cria uma pilha com tamanho padrão
   public Stack()
   {
      this(10); // tamanho padrão da pilha
   } 

   // Construtor cria uma pilha com o número especificado de elementos
   public Stack(int capacity)
   {
      // validação: define a capacidade inicial para o valor fornecido ou 10
      int initCapacity = capacity > 0 ? capacity : 10;
      elements = new ArrayList<T>(initCapacity); // cria o ArrayList
   }

   // Método para empilhar um elemento
   public void push(T pushValue)
   {
      elements.add(pushValue); // coloca o valor pushValue na pilha
   } 

   // Método para desempilhar e retornar o elemento do topo, se não estiver vazia; senão, lança uma exceção
   public T pop()
   {
      if (elements.isEmpty()) // se a pilha estiver vazia
         throw new EmptyStackException("A pilha está vazia, não é possível desempilhar");

      // remove e retorna o elemento do topo da pilha
      return elements.remove(elements.size() - 1); 
   }
} // fim da classe Stack<T>

