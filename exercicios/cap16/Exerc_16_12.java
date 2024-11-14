// 16.12
// Reescreva as linhas 16 a 25 na Figura 16.3 para que sejam mais concisas utilizando o método asList e o construtor LinkedList, que aceita um argumento Collection.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exerc_16_12 
{
 public static void main(String[] args) 
    {
        List<String> list1 = new LinkedList<>(Arrays.asList("black", "yellow", "green", "blue", "violet", "silver"));

        List<String> list2 = new LinkedList<>(Arrays.asList("gold", "white", "brown", "blue", "gray", "silver"));
        
        list1.addAll(list2);// concatena as listas
        list2 = null;// libera recursos
        printList(list1);// imprime elementos list1

        convertToUppercaseStrings(list1);// converte em string de letras maiusculas
        printList(list1);// imprime elementos list1

        System.out.printf("%nDeleting elements 4 to 6...");
        removeItems(list1, 4, 7);// remove itens 4 a 6 da lista
        printList(list1);// imprime elementos list1
        printReversedList(list1);// imprime lista na ordem inversa
    }    

    // gera saida do conteudo de list 
    private static void printList(List<String> list)
    {
        System.out.printf("%nlist:%n");

        for (String color : list)
            System.out.printf("%s ", color);
        
        System.out.println();
    }

    // localiza objetos String e converte em letras maiusculas
    private static void convertToUppercaseStrings(List<String> list)
    {
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) 
        {
            String color = iterator.next();// obtem o item
            iterator.set(color.toUpperCase());// converte em letras maiusculas    
        }
    }

    // obtem sublista e utiliza metodo clear para excluir itens da sublista
    private static void removeItems(List<String> list, int start, int end)
    {
        list.subList(start, end).clear();// remove os itens 
    }

    // imprime lista invertida 
    private static void printReversedList(List<String> list)
    {
        ListIterator<String> iterator = list.listIterator(list.size());

        System.out.printf("%nReversed List:%n");

        // imprime lista na ordem inversa
        while (iterator.hasPrevious()) 
            System.out.printf("%s ", iterator.previous());
    }
}
