// Fig. 21.13: Queue.java
// A fila usa a classe List.
package com.deitel.datastructures;

public class Queue<T> 
{
   private List<T> queueList;

   // construtor
   public Queue() 
   { 
      queueList = new List<T>("fila"); 
   } 

   // adiciona objeto à fila
   public void enqueue(T object)
   { 
      queueList.insertAtBack(object); 
   }

   // remove objeto da fila
   public T dequeue() throws EmptyListException
   { 
      return queueList.removeFromFront(); 
   }

   // determina se a fila está vazia
   public boolean isEmpty()
   {
      return queueList.isEmpty();
   }

   // exibe o conteúdo da fila
   public void print()
   {
      queueList.print();
   }
} // fim da classe Queue
