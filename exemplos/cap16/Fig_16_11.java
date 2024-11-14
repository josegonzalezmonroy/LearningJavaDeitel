// Figura 16.1 - Algorithms1.java
// Metodos collections reverse, fill, copy, max e min
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Fig_16_11 
{
    public static void main(String[] args) 
    {
        // crie e exibe uma List<Character>
        Character[] letters = {'P', 'C', 'M'};
        List<Character> list = Arrays.asList(letters);// obtem list
        System.out.println("list contains: ");
        output(list);
        
        //invierte e exibe uma List<Character>
        Collections.reverse(list);// invierte a ordem dos elementos
        System.out.printf("%nAfter calling reverse, list constains:%n");
        output(list);

        // cria CopyList de um array de 3 caracteres
        Character[] lettersCopy = new Character[3];
        List<Character> copyList = Arrays.asList(lettersCopy);
        
        // copia o conteudo da lista para copyList
        Collections.copy(copyList, list);
        System.out.printf("%nAfter copying, copyList constains:%n");
        output(list);

        // preenche a lista con Rs
        Collections.fill(list, 'R');
        System.out.printf("%nAfter calling fill, list constains:%n");
        output(list);
    }

    // envia informacoes de List para saida
    private static void output(List<Character> listRef)
    {
        System.out.print("The list is: ");

        for (Character element : listRef)
            System.out.printf("%s ", element);

        System.out.printf("%nMax: %s", Collections.max(listRef));
        System.out.printf("  Min: %s", Collections.min(listRef));
    }
}
