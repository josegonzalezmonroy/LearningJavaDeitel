// Figura 16.6 - Sort1.java
// Metodo Collections sort

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fig_16_6 
{
    public static void main(String[] args) 
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // cria e exibe uma lista contendo os elementos do array naipes 
        List<String> list = Arrays.asList(suits);
        System.out.printf("Unsorted array elements: %s%n", list);

        Collections.sort(list);// classifica ArrayList
        System.out.printf("Sorted array elements: %s%n", list);
    }
}
