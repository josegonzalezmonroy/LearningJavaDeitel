// 21.8 - Combinando listas ordenadas
// Modifique a classe SortedList da Questão 21.7 para incluir um método merge que pode mesclar a SortedList que ela recebe como um argumento com a SortedList que chama o método. Escreva um aplicativo para testar o método merge.
import java.security.SecureRandom;

public class Exerc_21_8 
{
    public static void main(String[] args) 
    {
        // Cria duas listas ordenadas
        SortedList<Integer> list1 = new SortedList<>("Lista 1");
        SortedList<Integer> list2 = new SortedList<>("Lista 2");

        // Gera valores aleatórios para a primeira lista
        gerarValores(list1);
        System.out.println("Conteúdo da Lista 1:");
        list1.print(); // Imprime o conteúdo da lista 1
        
        // Gera valores aleatórios para a segunda lista
        gerarValores(list2);
        System.out.println("Conteúdo da Lista 2:");
        list2.print(); // Imprime o conteúdo da lista 2

        // Mescla a lista 2 na lista 1
        list1.merge(list2);

        // Imprime o conteúdo da lista 1 após a mesclagem
        System.out.println("Conteúdo da Lista 1 após mesclar com Lista 2:");
        list1.print();
    }
    
    // Método para gerar valores aleatórios e inseri-los na lista
    public static void gerarValores(SortedList<Integer> list)
    {
        SecureRandom random = new SecureRandom(); // Instancia um gerador de números aleatórios

        // Insere 25 números aleatórios entre 0 e 100 na lista
        for (int i = 0; i < 25; i++) 
        {
            int number = random.nextInt(101); // Gera um número aleatório
            list.insertValue(number); // Insere o número gerado na lista
        }
    }
}
