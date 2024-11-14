// Fig. 21.12: StackComposition.java
// StackComposition usa um objeto List composto.
package com.deitel.datastructures;

public class StackComposition<T>
{
   private List<T> stackList;

   // construtor
   public StackComposition() 
   { 
      stackList = new List<T>("pilha"); 
   } 

   // adiciona objeto à pilha
   public void push(T object)
   { 
      stackList.insertAtFront(object); 
   } 

   // remove objeto da pilha
   public T pop() throws EmptyListException
   { 
      return stackList.removeFromFront(); 
   } 

   // determina se a pilha está vazia
   public boolean isEmpty() 
   { 
      return stackList.isEmpty(); 
   } 

   // exibe o conteúdo da pilha
   public void print() 
   { 
      stackList.print(); 
   } 
} // fim da classe StackComposition
