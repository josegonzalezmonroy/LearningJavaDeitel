// Figura 21.4 - EmptyListException.java
// Declaração da classe EmptyListException.
package com.deitel.datastructures;

public class EmptyListException extends RuntimeException 
{
   // construtor
   public EmptyListException()
   {
      this("List"); // chama o outro construtor de EmptyListException
   } 

   // construtor
   public EmptyListException(String name)
   {
      super(name + " is empty"); // chama o construtor da superclasse
   } 
} // fim da classe EmptyListException
