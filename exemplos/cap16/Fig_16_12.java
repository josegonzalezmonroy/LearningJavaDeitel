// Figura 16.12 - BinarySearchTest.java
// Metodo binarySearch de Collections
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Fig_16_12 
{
    public static void main(String[] args) 
    {
        // cria um arraylist <String> a partir do conteudo do array colors
        String[] colors = {"red", "white", "blue", "black", "yellow", 
            "purple", "tan", "pink"};
        List<String> list = 
            new ArrayList<>(Arrays.asList(colors));
        
        Collections.sort(list);// classifica a ArrayList
        System.out.printf("Sorted ArrayList: %s%n", list);

        // pesquisa varios valores na lista
        printSearchResults(list, "black");
        printSearchResults(list, "red");
        printSearchResults(list, "pink");
        printSearchResults(list, "aqua");
        printSearchResults(list, "gray");
        printSearchResults(list, "teal");
    }    

    // realiza pesquisa e exibe o resultado
    private static void printSearchResults(
        List<String> list, String key)
    {
        int result = 0;

        System.out.printf("%nSearching for: %s%n", key);
        result = Collections.binarySearch(list, key);

        if (result >= 0)
            System.out.printf("Found at index %d%n", result);
        else    
            System.out.printf("Not Found (%d)%n", result);
    }
}
