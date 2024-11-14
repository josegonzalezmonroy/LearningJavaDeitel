import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fig_16_7 
{
    public static void main(String[] args) 
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // cria e exibe uma lista contendo os elementos do array naipes 
        List<String> list = Arrays.asList(suits);// cria List 
        System.out.printf("Unsorted array elements: %s%n", list);

        // classifica em ordem decrescente utilizando um comparador
        Collections.sort(list, Collections.reverseOrder());
        System.out.printf("Sorted list elements: %s%n", list);
    }    
}
