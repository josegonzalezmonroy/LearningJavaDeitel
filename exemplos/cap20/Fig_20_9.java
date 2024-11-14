// Figura 21.9 - StackTest.java
// Programa de teste para a classe genérica Stack.

public class Fig_20_9
{
   public static void main(String[] args) 
   {
      // Arrays de elementos double e int para testar a pilha
      double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // Criação de uma Stack<Double> e uma Stack<Integer>
      Stack<Double> doubleStack = new Stack<>(5); // pilha de double com capacidade 5
      Stack<Integer> integerStack = new Stack<>(); // pilha de inteiros com capacidade padrão

      // Empilha os elementos de doubleElements na doubleStack
      testPushDouble(doubleStack, doubleElements); 
      // Desempilha da doubleStack
      testPopDouble(doubleStack);

      // Empilha os elementos de integerElements na integerStack
      testPushInteger(integerStack, integerElements); 
      // Desempilha da integerStack
      testPopInteger(integerStack);
   } 

   // Método para testar o push na pilha de doubles
   private static void testPushDouble(Stack<Double> stack, double[] values)
   {
      System.out.printf("%nEmpilhando elementos na doubleStack%n");

      // Empilha os elementos no Stack
      for (double value : values)
      {
         System.out.printf("%.1f ", value); // Exibe o valor a ser empilhado
         stack.push(value); // empilha na doubleStack
      }
   }

   // Método para testar o pop na pilha de doubles
   private static void testPopDouble(Stack<Double> stack)
   {
      // Desempilha os elementos da pilha
      try
      {
         System.out.printf("%nDesempilhando elementos da doubleStack%n");
         double popValue; // Armazena o elemento removido da pilha

         // Remove todos os elementos da pilha até ela estar vazia
         while (true)
         {
            popValue = stack.pop(); // Desempilha da doubleStack
            System.out.printf("%.1f ", popValue); // Exibe o valor desempilhado
         }
      }
      catch(EmptyStackException emptyStackException) // Exceção para pilha vazia
      {
         System.err.println(); // Exibe uma linha em branco
         emptyStackException.printStackTrace(); // Exibe a pilha de chamadas do erro
      } 
   } 

   // Método para testar o push na pilha de inteiros
   private static void testPushInteger(Stack<Integer> stack, int[] values)
   {
      System.out.printf("%nEmpilhando elementos na integerStack%n");

      // Empilha os elementos na pilha
      for (int value : values)
      {
         System.out.printf("%d ", value); // Exibe o valor a ser empilhado
         stack.push(value); // Empilha na integerStack
      } 
   }

   // Método para testar o pop na pilha de inteiros
   private static void testPopInteger(Stack<Integer> stack)
   {
      // Desempilha os elementos da pilha
      try
      {
         System.out.printf("%nDesempilhando elementos da integerStack%n");
         int popValue; // Armazena o elemento removido da pilha

         // Remove todos os elementos da pilha até ela estar vazia
         while (true)
         {
            popValue = stack.pop(); // Desempilha da integerStack
            System.out.printf("%d ", popValue); // Exibe o valor desempilhado
         }
      } 
      catch(EmptyStackException emptyStackException) // Exceção para pilha vazia
      {
         System.err.println(); // Exibe uma linha em branco
         emptyStackException.printStackTrace(); // Exibe a pilha de chamadas do erro
      } 
   }
} // fim da classe StackTest
