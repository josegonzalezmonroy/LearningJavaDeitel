// Figura 7.22 - ArrayManipulations.java
// Métodos da classe Arrays e System.arraycopy
import java.util.Arrays;

public class Fig_7_22 
{
    public static void main(String[] args) 
    {
        // classifica doubleArray em ordem crescente 
        double[] doubleArray = { 8.4, 9.3, 0.2, 7.9, 3.4 };
        Arrays.sort(doubleArray);
        System.out.printf("%ndoubleArray: ");
        
        for (double value : doubleArray)
            System.out.printf("%.1f", value);
        
        // preenche o array de 10 elementos com 7s
        int[] filledIntArray = new int[10];
        Arrays.fill(filledIntArray, 7);
        displayArray(filledIntArray, "filledIntArray");

        // copia array intArray em array initArrayCopy
        int[] initArray = { 1, 2, 3, 4, 5, 6 };
        int[] initArrayCopy = new int[initArray.length];
        System.arraycopy(initArray, 0, initArrayCopy, 0, initArray.length);
        displayArray(initArray, "intArray");
        displayArray(initArrayCopy, "intArrayCopy");

        // verifica a igualdade de intArray e intArrayCopy
        boolean b = Arrays.equals(initArray, initArrayCopy);
        System.out.printf("%n%nintArray %s intArrayCopy%n", 
            (b ? "==" : "!="));
        
        // verifica a igualdade de intArray e filledIntArray
        b = Arrays.equals(initArray, filledIntArray);
        System.out.printf("intArray %s filledIntArray%n", 
            (b ? "==" : "!="));
        
        // pesquisa o valor 5 em intArray
        int location = Arrays.binarySearch(initArray, 5);

        if (location >= 0)
            System.out.printf(
                "Found 5 at element %d in intArray%n", location);
        else
            System.out.println("5 not found in initArray");
        
        // pesquisa o valor 8763 em initArray
        location = Arrays.binarySearch(initArray, 8763);

        if (location >= 0)
        System.out.printf(
            "Found 8763 at element %d in intArray%n", location);
        else
            System.out.println("8763 not found in initArray");
    }

    // gera a saída de valores em cada array
    public static void displayArray(int[] array, String description)
    {
        System.out.printf("%n%s", description);

        for (int value : array)
            System.out.printf("%d", value);
    }
}// fim da classe ArrayManipulations
