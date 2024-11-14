// A fila usa a classe List.
package com.deitel.datastructures;

public class Queue<T> extends List<T>
{
   // adiciona objeto à fila
   public void enqueue(T object)
   { 
      insertAtBack(object); 
   }

   // remove objeto da fila
   public T dequeue() throws EmptyListException
   { 
      return removeFromFront(); 
   }
   
   public T peek()
   {
      return super.peek();
   }

   public int size()
   {
      return super.size();
   }

   // determina se a fila está vazia
   public boolean isEmpty()
   {
      return super.isEmpty();
   }

   // exibe o conteúdo da fila
   public void print()
   {
      super.print();
   }
} // fim da classe Queue
