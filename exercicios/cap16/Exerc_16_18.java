import java.util.LinkedList;
import java.util.ListIterator;

public class Exerc_16_18 
{
    public static void main(String[] args) 
    {
        // Cria uma LinkedList de 10 caracteres
        LinkedList<Character> listaOriginal = new LinkedList<>();
        listaOriginal.add('A');
        listaOriginal.add('B');
        listaOriginal.add('C');
        listaOriginal.add('D');
        listaOriginal.add('E');
        listaOriginal.add('F');
        listaOriginal.add('G');
        listaOriginal.add('H');
        listaOriginal.add('I');
        listaOriginal.add('J');

        // Exibe a lista original
        System.out.println("Lista original: " + listaOriginal);

        // Cria uma LinkedList invertida
        LinkedList<Character> listaInvertida = new LinkedList<>();

        // Usamos um ListIterator para percorrer a lista original de trás para frente
        ListIterator<Character> iterator = listaOriginal.listIterator(listaOriginal.size());
        
        while (iterator.hasPrevious()) 
            listaInvertida.add(iterator.previous()); // Adiciona os elementos na ordem inversa

        // Exibe a lista invertida
        System.out.println("Lista invertida: " + listaInvertida);
    }    
}
