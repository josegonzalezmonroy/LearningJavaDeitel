// Figura 20.3 - GenericMethodTest.java
// Imprimindo elementos de arrays usando um método genérico printArray.

public class Fig_20_3
{
   public static void main(String[] args) 
   {
      // cria arrays de Integer, Double e Character
      Integer[] integerArray = {1, 2, 3, 4, 5, 6};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

      // imprime o conteúdo do array de Integer
      System.out.print("Array integerArray contém:%n");
      printArray(integerArray); // passa um array de Integer 
      
      // imprime o conteúdo do array de Double
      System.out.printf("%nArray doubleArray contém:%n");
      printArray(doubleArray); // passa um array de Double
      
      // imprime o conteúdo do array de Character
      System.out.printf("%nArray characterArray contém:%n");
      printArray(characterArray); // passa um array de Character
   } 

   // método genérico printArray
   public static <T> void printArray(T[] inputArray)
   {
      // exibe os elementos do array
      for (T element : inputArray)
         System.out.printf("%s ", element);

      System.out.println(); // adiciona uma nova linha após a impressão do array
   }
} // fim da classe GenericMethodTest
