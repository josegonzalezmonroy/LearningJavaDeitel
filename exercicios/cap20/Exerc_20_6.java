/* 20.6 - Sobrecarregando um método genérico com um método não genérico
Sobrecarregue o método genérico printArray da Figura 20.3 com uma versão não genérica que imprime especificamente um array de Strings em um formato tabular perfeito, como mostrado na saída do exemplo a seguir:

Array stringArray contains:
one two three four
five six seven eight
*/
public class Exerc_20_6 
{
    public static void main(String[] args) 
    {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6}; // Cria um array de Inteiros

        System.out.printf("Array integerArray contains:%n");
        printArray(integerArray); // Imprime todos os elementos do array integerArray
        
        String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        System.out.println("Array stringArray contains:");
        printArray(stringArray); // Chama o método para imprimir o array de Strings
    }

    public static void printArray(String[] array) // metodo nao generico que imprime especificamente um array de Strings
    {
        int columnCount = 4; // Número de colunas desejadas
    
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-10s ", array[i]); // Imprime o elemento com largura fixa
    
            if ((i + 1) % columnCount == 0) {
                System.out.println(); // Nova linha
            }
        }
        System.out.println(); // Nova linha após imprimir todos os elementos
    }

    public static <T> void printArray(T[] inputArray)
    {
       // Imprime todos os elementos do array de entrada
       for (T element : inputArray)
          System.out.printf("%s ", element);
 
       System.out.println();
    }
}
