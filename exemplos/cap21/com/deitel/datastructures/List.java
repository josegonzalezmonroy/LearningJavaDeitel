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
   private ListNode<T> firstNode;
   private ListNode<T> lastNode;
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
      firstNode = lastNode = null;
   } 

   // insere um item no início da lista
   public void insertAtFront(T insertItem)
   {
      if (isEmpty()) // firstNode e lastNode referem-se ao mesmo objeto
         firstNode = lastNode = new ListNode<T>(insertItem);
      else // firstNode refere-se ao novo nó
         firstNode = new ListNode<T>(insertItem, firstNode);
   } 

   // insere um item no final da lista
   public void insertAtBack(T insertItem)
   {
      if (isEmpty()) // firstNode e lastNode referem-se ao mesmo objeto
         firstNode = lastNode = new ListNode<T>(insertItem);
      else // o nextNode de lastNode refere-se ao novo nó
         lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
   } 

   // remove o primeiro nó da lista
   public T removeFromFront() throws EmptyListException
   {
      if (isEmpty()) // lança exceção se a lista estiver vazia
         throw new EmptyListException(name);

      T removedItem = firstNode.data; // recupera os dados removidos

      // atualiza as referências firstNode e lastNode 
      if (firstNode == lastNode)
         firstNode = lastNode = null;
      else
         firstNode = firstNode.nextNode;

      return removedItem; // retorna os dados do nó removido
   } // fim do método removeFromFront

   // remove o último nó da lista
   public T removeFromBack() throws EmptyListException
   {
      if (isEmpty()) // lança exceção se a lista estiver vazia
         throw new EmptyListException(name);

      T removedItem = lastNode.data; // recupera os dados removidos

      // atualiza as referências firstNode e lastNode
      if (firstNode == lastNode)
         firstNode = lastNode = null;
      else // localiza o novo último nó
      { 
         ListNode<T> current = firstNode;

         // percorre enquanto o nó atual não se refere ao lastNode
         while (current.nextNode != lastNode)
            current = current.nextNode;
   
         lastNode = current; // current é o novo lastNode
         current.nextNode = null;
      } 

      return removedItem; // retorna os dados do nó removido
   } 

   // determina se a lista está vazia
   public boolean isEmpty()
   { 
      return firstNode == null; // retorna true se a lista estiver vazia
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
      ListNode<T> current = firstNode;

      // enquanto não estiver no final da lista, imprime os dados do nó atual
      while (current != null) 
      {
         System.out.printf("%s ", current.data);
         current = current.nextNode;
      }

      System.out.println();
   } 
} // fim da classe List<T>
