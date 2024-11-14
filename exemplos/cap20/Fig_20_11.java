// Figura 20.11 - RawTypeTest.java
// Programa de teste com tipos brutos (raw types).

public class Fig_20_11
{
   public static void main(String[] args) 
   {
      // Arrays de Double e Integer para testar as pilhas (stacks)
      Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

      // Pilha com tipo bruto (raw type) atribuída a uma variável Stack de tipos brutos
      Stack rawTypeStack1 = new Stack(5); 

      // Stack<Double> atribuída a uma variável de tipo bruto (raw type)
      Stack rawTypeStack2 = new Stack<Double>(5);          

      // Pilha de tipo bruto atribuída a uma variável Stack<Integer>
      Stack<Integer> integerStack = new Stack(10);            

      // Empilha elementos no rawTypeStack1
      testPush("rawTypeStack1", rawTypeStack1, doubleElements);
      // Desempilha os elementos do rawTypeStack1
      testPop("rawTypeStack1", rawTypeStack1);

      // Empilha elementos no rawTypeStack2
      testPush("rawTypeStack2", rawTypeStack2, doubleElements);
      // Desempilha os elementos do rawTypeStack2
      testPop("rawTypeStack2", rawTypeStack2);

      // Empilha elementos na integerStack
      testPush("integerStack", integerStack, integerElements);
      // Desempilha os elementos da integerStack
      testPop("integerStack", integerStack);
   }

   // Método genérico para empurrar elementos em uma pilha (Stack)
   private static <T> void testPush(String name, Stack<T> stack, T[] elements)
   {
      System.out.printf("%nEmpilhando elementos em %s%n", name);

      // Empilha cada elemento na Stack
      for (T element : elements)         
      {
         System.out.printf("%s ", element);
         stack.push(element); // Empilha o elemento
      } 
   } 

   // Método genérico para desempilhar elementos de uma pilha (Stack)
   private static <T> void testPop(String name, Stack<T> stack)
   {
      // Desempilha os elementos da pilha
      try
      {
         System.out.printf("%nDesempilhando elementos de %s%n", name);
         T popValue; // Armazena o elemento removido da pilha

         // Remove todos os elementos da pilha
         while (true)
         {
            popValue = stack.pop(); // Desempilha da stack
            System.out.printf("%s ", popValue);
         } 
      }
      catch(EmptyStackException emptyStackException) // Captura exceção se a pilha estiver vazia
      {
         System.out.println(); // Linha em branco
         emptyStackException.printStackTrace(); // Exibe o stack trace do erro
      }
   }
} // fim da classe RawTypeTest
