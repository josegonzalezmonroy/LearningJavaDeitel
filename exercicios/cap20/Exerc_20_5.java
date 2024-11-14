// 20.5 - Método genérico sobrecarregado printArray
// Sobrecarregue o método genérico printArray da Figura 20.3 para que ele receba dois argumentos do tipo inteiro adicionais, lowSubscript e highSubscript. Uma chamada a esse método imprime somente a parte especificada do array. Valide lowSubscript e highSubscript. Se um deles estiver fora do intervalo, o método printArray sobrecarregado deve lançar uma InvalidSubscriptException; caso contrário, printArray deve retornar o número de elementos impressos. Então, modifique main para praticar as duas versões do printArray nos arrays integerArray, doubleArray e characterArray. Teste todas as capacidades das duas versões de printArray.

public class Exerc_20_5
{
   public static void main(String[] args) 
   {
      Integer[] integerArray = {1, 2, 3, 4, 5, 6}; // Cria um array de Inteiros
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7}; // Cria um array de Doubles
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'}; // Cria um array de Caracteres

      System.out.printf("Array integerArray contains:%n");
      printArray(integerArray); // Imprime todos os elementos do array integerArray
      System.out.printf("%nArray doubleArray contains:%n");
      printArray(doubleArray); // Imprime todos os elementos do array doubleArray
      System.out.printf("%nArray characterArray contains:%n");
      printArray(characterArray); // Imprime todos os elementos do array characterArray

      try 
      {
         System.out.printf("%nPrinting a subset of integerArray (1 to 4):%n");
         printArray(integerArray, 1, 4); // Chama a versão sobrecarregada para imprimir os elementos de 1 a 4
         
         System.out.printf("%nPrinting a subset of doubleArray (0 to 6):%n");
         printArray(doubleArray, 0, 6); // Chama a versão sobrecarregada para imprimir os elementos de 0 a 6

         System.out.printf("%nPrinting a subset of characterArray (2 to 5):%n");
         printArray(characterArray, 2, 5); // Chama a versão sobrecarregada para imprimir os elementos de 2 a 5
     } 
     catch (InvalidSubscriptException e) 
     {
         System.err.println(e.getMessage()); // Exibe a mensagem de erro caso a exceção seja lançada
     }
   } 

   public static <T> void printArray(T[] array, int lowSubscript, int highSubscript) throws InvalidSubscriptException
   {
      // Valida se os subscritos estão dentro do intervalo permitido
      if (lowSubscript < 0 || highSubscript >= array.length || lowSubscript > highSubscript) 
         throw new InvalidSubscriptException(String.format("Invalid subscript range."));

      // Imprime os elementos do array entre os índices lowSubscript e highSubscript
      while (lowSubscript <= highSubscript)
      {
         System.out.printf("%s ", array[lowSubscript++]); 
      }
      System.out.println();
   }

   public static <T> void printArray(T[] inputArray)
   {
      // Imprime todos os elementos do array de entrada
      for (T element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }
}

// Classe personalizada para exceções relacionadas a subscritos inválidos
class InvalidSubscriptException extends Exception 
{
   public InvalidSubscriptException(String message) 
   {
       super(message); // Chama o construtor da classe pai com a mensagem de erro
   }
}
