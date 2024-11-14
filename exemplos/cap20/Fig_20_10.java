// Figura 20.10 - StackTest2.java
// Passando objetos Stack genéricos para métodos genéricos.

public class Fig_20_10
{
   public static void main(String[] args) 
   {
      // Arrays de Double e Integer para testar as pilhas
      Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // Criação de uma Stack<Double> e uma Stack<Integer>
      Stack<Double> doubleStack = new Stack<>(5);  // pilha de Double com capacidade de 5
      Stack<Integer> integerStack = new Stack<>(); // pilha de Integer com capacidade padrão

      // Empilha os elementos de doubleElements na doubleStack
      testPush("doubleStack", doubleStack, doubleElements);
      // Desempilha os elementos da doubleStack
      testPop("doubleStack", doubleStack); 

      // Empilha os elementos de integerElements na integerStack
      testPush("integerStack", integerStack, integerElements);
      // Desempilha os elementos da integerStack
      testPop("integerStack", integerStack); 
   } 

   // Método genérico testPush para empurrar elementos em uma pilha (Stack)
   public static <T> void testPush(String name , Stack<T> stack, T[] elements)
   {
      System.out.printf("%nEmpilhando elementos na %s%n", name);

      // Empilha cada elemento no Stack
      for (T element : elements)
      {
         System.out.printf("%s ", element); // Exibe o elemento
         stack.push(element); // Empilha o elemento
      } 
   } 

   // Método genérico testPop para desempilhar elementos de uma pilha (Stack)
   public static <T> void testPop(String name, Stack<T> stack)
   {
      // Desempilha os elementos da pilha
      try
      {
         System.out.printf("%nDesempilhando elementos da %s%n", name);
         T popValue; // Armazena o elemento removido da pilha

         // Remove todos os elementos da pilha
         while (true)
         {
            popValue = stack.pop(); // Desempilha da stack
            System.out.printf("%s ", popValue); // Exibe o valor desempilhado
         } 
      }
      catch(EmptyStackException emptyStackException) // Captura exceção se a pilha estiver vazia
      {
         System.out.println(); // Linha em branco
         emptyStackException.printStackTrace(); // Exibe o stack trace do erro
      }
   }
} // fim da classe StackTest2
