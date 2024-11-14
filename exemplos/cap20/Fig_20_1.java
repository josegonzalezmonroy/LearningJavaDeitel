// Figura 20.1 - OverloadedMethods.java
// Imprimindo elementos de arrays usando métodos sobrecarregados.
public class Fig_20_1
{
   public static void main(String[] args) 
   {
      // cria arrays de Integer, Double e Character
      Integer[] integerArray = {1, 2, 3, 4, 5, 6};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

      // imprime o array integerArray
      System.out.printf("Array integerArray contém:%n");
      printArray(integerArray); // passa um array de Integer
      // imprime o array doubleArray
      System.out.printf("%nArray doubleArray contém:%n");
      printArray(doubleArray); // passa um array de Double
      // imprime o array characterArray
      System.out.printf("%nArray characterArray contém:%n");
      printArray(characterArray); // passa um array de Character
   } 

   // método printArray para imprimir um array de Integer
   public static void printArray(Integer[] inputArray)
   {
      // exibe os elementos do array
      for (Integer element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }

   // método printArray para imprimir um array de Double
   public static void printArray(Double[] inputArray)
   {
      // exibe os elementos do array
      for (Double element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }

   // método printArray para imprimir um array de Character
   public static void printArray(Character[] inputArray)
   {
      // exibe os elementos do array
      for (Character element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }
} // fim da classe OverloadedMethods
