// Figura 16.9 - Sort3.java
// Metodo sort de Collections com um objeto Comparator personalizado
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fig_16_9 
{
    public static void main(String[] args) 
    {
        List<Time2> list = new ArrayList<>();// cria list
        
        list.add(new Time2(6,24,34));
        list.add(new Time2(18,14,58));
        list.add(new Time2(6,05,34));
        list.add(new Time2(12,14,58));
        list.add(new Time2(6,24,22));

        // gera saida de elementos List 
        System.out.printf("Unsorted array elements:%n%s%n", list);

        // classifica em ordem utilizando um comparator 
        Collections.sort(list, new Fig_16_8());

        // gera saida de elementos List
        System.out.printf("Sorted list elements:%n%s%n", list);
    }
}// fim da classe Sort3
