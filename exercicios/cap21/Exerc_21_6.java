// 21.6 - Concatenando listas
// Escreva um programa que concatena dois objetos de lista encadeada de caracteres. A classe ListConcatenate deve incluir um método static concatenate que aceita referências tanto para objetos de lista como para argumentos e concatena a segunda lista com a primeira.

public class Exerc_21_6
{
    public static void main(String[] args) 
    {
        List<String> list1 = new List<>();
        List<String> list2 = new List<>();

        // Adicionando elementos à primeira lista
        list1.add("Ola");
        list1.add("mundo!");

        // Adicionando elementos à segunda lista
        list2.add("Como");
        list2.add("voce?");

        System.out.println("Lista 1:");
        list1.print();
        System.out.println("Lista 2:");
        list2.print();

        // Concatenando listas
        ListConcatenate.concatenate(list1, list2);

        System.out.println("Lista concatenada:");
        list1.print();
    }
}
