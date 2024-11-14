// Figura 21.3 - List.java
// Declarações das classes ListNode e List.
package com.deitel.datastructures;

// classe para representar um nó na lista
class ListNode<T> 
{
   // membros com acesso de pacote; List pode acessá-los diretamente
   T data; // dados para este nó
   ListNode<T> nextNode; // referência para o próximo nó na lista

   // construtor cria um ListNode que se refere ao objeto
   ListNode(T object) 
   { 
      this(object, null); 
   }  

   // construtor cria ListNode que se refere ao objeto especificado
   // e ao próximo ListNode
   ListNode(T object, ListNode<T> node)
   {
      data = object;    
      nextNode = node;  
   } 

   // retorna referência para os dados no nó
   T getData() 
   { 
      return data; 
   } 

   // retorna referência para o próximo nó na lista
   ListNode<T> getNext() 
   { 
      return nextNode; 
   } 
} // fim da classe ListNode<T>

// definição da classe List
public class List<T>
{
   private ListNode<T> head;
   private String name; // string como "lista" usada para impressão

   // construtor cria uma lista vazia com "list" como nome
   public List() 
   { 
      this("list"); 
   } 

   // construtor cria uma lista vazia com um nome
   public List(String listName)
   {
      name = listName;
      head = null;
   } 

   // insere um item no início da lista
   public void insertAtFront(T insertItem)
   {
      head = new ListNode<T>(insertItem, head);
   } 

   // insere um item no final da lista
   public void insertAtBack(T insertItem) 
   {
      if (isEmpty())
         head = new ListNode<T>(insertItem);
      else 
      { // o nextNode refere-se ao novo no
         ListNode<T> current = head;

         // percorre ate o final da lista
         while (current.nextNode != null) 
         {
            current = current.nextNode;
         }

         // adiciona o novo no ao final da lista
         current.nextNode = new ListNode<>(insertItem);
      }
   }

   // remove o primeiro no da lista
   public T removeFromFront() throws EmptyListException 
   {
      if (isEmpty()) // lanca excecao se a lista estiver vazia
         throw new EmptyListException(name);

      T removedItem = head.data;

      // atualiza o head para o proximo no
      head = head.nextNode;

      return removedItem; // retorna os dados do no removido
   }

   // remove o ultimo no da lista
   public T removeFromBack() throws EmptyListException 
   {
      if (isEmpty()) // lanca excecao se a lista estiver vazia
         throw new EmptyListException(name);

      // atualiza a referencia head
      if (head.nextNode == null)
      {
         T removedItem = head.data;
         head = null;

         return removedItem; // retorna os dados do no removido
      }

      ListNode<T> current = head;

      // percorre ate o penultimo no
      while (current.nextNode.nextNode != null) 
      {
         current = current.nextNode;
      }

      T removedItem = current.nextNode.data;
      current.nextNode = null;

      return removedItem; // retorna os dados do no removido
   } // fim do metodo removeFromBack

   public void insertAt(int index, T data)
   {
      // Verifica se o indice esta fora do intervalo permitido
      if (index < 0 || index > size())
         throw new IndexOutOfBoundsException("Index out of range"); 
      
      // Cria um novo nodo com o dado fornecido
      ListNode<T> newNode = new ListNode<>(data);
   
      // Insere o novo nodo no inicio da lista se o indice for 0
      if (index == 0)
         insertAtFront(data);
      // Insere o novo nodo no final da lista se o indice for igual ao tamanho
      else if (index == size())
         insertAtBack(data);
      else
      {
         // Percorre a lista ate encontrar a posicao de insercao
         ListNode<T> current = head;
         for (int i = 1; i < index; i++)
            current = current.nextNode;
   
         // Insere o novo nodo na posicao especificada
         newNode.nextNode = current.nextNode;
         current.nextNode = newNode;
      }
   }
   
   public T removeAt(int index)
   {
      // Verifica se o indice esta fora do intervalo permitido
      if (index < 0 || index >= size())
         throw new IndexOutOfBoundsException("Index out of range"); 
      
      // Remove e retorna o nodo do inicio da lista se o indice for 0
      if (index == 0)
         return removeFromFront();
      // Remove e retorna o nodo do final da lista se o indice for o ultimo
      else if (index == size() - 1)
         return removeFromBack();
      else
      {
         // Percorre a lista ate encontrar a posicao de remocao
         ListNode<T> current = head;
         for (int i = 1; i < index; i++)
            current = current.nextNode;
         
         // Remove o nodo na posicao especificada e armazena o dado removido
         T removedData = current.nextNode.data;
         current.nextNode = current.nextNode.nextNode;
   
         // Retorna o dado do nodo removido
         return removedData;
      }
   }   

   public T peek()
   {
      return head.data; 
   }

   public int size()
   {
      int size = 0;

      ListNode<T> current = head;

      while (current != null) 
      {
         size++;
         current = current.nextNode;
      }

      return size;
   }

   // determina se a lista está vazia
   public boolean isEmpty()
   { 
      return head == null; // retorna true se a lista estiver vazia
   } 

   public ListNode<T> search(T value) 
   {
      if (isEmpty()) 
      {
          System.out.printf("%nEmpty %s%n", name);
          return null; // Lista vazia, retorna null
      }
  
      // Chama o método auxiliar para buscar a partir do primeiro nó
      return search(head, value);
   }
  
   private ListNode<T> search(ListNode<T> node, T value) {
      // Se chegamos ao final da lista sem encontrar o valor
      if (node == null) 
      {
          System.out.println("\nValor nao encontrado: " + value);
          return null; // Valor não encontrado
      }
  
      // Se o nó atual contém o valor
      if (node.data.equals(value)) 
      {
          System.out.println("\nValor encontrado: " + node.data);
          return node; // Retorna o nó encontrado
      }
  
      // Chamada recursiva para o próximo nó
      return search(node.nextNode, value); // Continua a busca na lista
   }
  
   public void printListBackward() 
   {
      if (isEmpty()) 
      {
          System.out.printf("Empty %s%n", name);
          return;
      }
  
      System.out.printf("Backward %s: ", name);
      printNodesBackward(head); // Função auxiliar para recursão
  }
  
   // Função auxiliar recursiva para imprimir a lista de trás para frente
   private void printNodesBackward(ListNode<T> node) 
   {
      if (node == null) 
          return; // Base da recursão, quando o nó for nulo
  
      // Avança até o final da lista
      printNodesBackward(node.nextNode);
  
      // Na volta da recursão, imprime os dados
      System.out.print(node.data + " ");
  }
  
   // imprime o conteúdo da lista
   public void print()
   {
      if (isEmpty()) 
      {
         System.out.printf("Empty %s%n", name);
         return;
      }

      System.out.printf("The %s is: ", name);
      ListNode<T> current = head;

      // enquanto não estiver no final da lista, imprime os dados do nó atual
      while (current != null) 
      {
         System.out.printf("%s ", current.data);
         current = current.nextNode;
      }

      System.out.println();
   } 
} // fim da classe List<T>
