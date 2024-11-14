// 21.7 - Inserindo em uma lista ordenada
// Escreva um programa que insere 25 inteiros aleatorios de 0 a 100 na ordem em um objeto de lista encadeada. Para este exercicio, voce precisara modificar a classe List para manter uma lista ordenada.bNomeie a nova versao da classe como SortedList.
import java.security.SecureRandom;

public class Exerc_21_7
{
    public static void main(String[] args) 
    {
        // Cria duas listas ordenadas
        SortedList<Integer> list = new SortedList<>("Lista 1");
        SortedList<Integer> list2 = new SortedList<>("Lista 2");
        
        // Instancia um gerador de numeros aleatorios
        SecureRandom random = new SecureRandom();

        // Insere 25 numeros aleatorios na lista
        for (int i = 0; i < 25; i++)
        {
            // Gera um numero aleatorio de 0 a 100
            int number = random.nextInt(101);
            // Insere o numero na lista
            list.insertValue(number);
        }

        // Imprime o conteudo da primeira lista
        list.print();
        System.out.println();
        // Imprime o conteudo da segunda lista
        list2.print();
    }
}
