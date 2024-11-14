// 19.9 - Pesquisa binária recursiva
// Modifique a Figura 19.3 para usar o método recursivo recursiveBinarySearch a fim de realizar uma pesquisa binária do array. O método deve receber a chave de pesquisa, o índice inicial e o índice final como argumentos. Se a chave de pesquisa for encontrada, seu índice no array é retornado. Se a chave de pesquisa nao for encontrada, é retornado –1.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Exerc_19_9 
{
    // realiza a busca binária recursiva nos dados
    public static int recursiveBinarySearch(int[] data, int key, int low, int high) 
    {
        if (low > high) 
            return -1; // Condicao base: chave nao encontrada

        int middle = (low + high) / 2; // Calcula o índice do meio

        // Imprime os elementos restantes no array
        System.out.print(remainingElements(data, low, high));

        // Imprime espacos para alinhamento
        for (int i = 0; i < middle; i++)
            System.out.print("   ");

        System.out.println(" * "); // Indica o elemento do meio

        // Verifica se o valor no meio é a chave de busca
        if (key == data[middle]) 
            return middle; // Chave encontrada, retorna o índice
        // Se a chave for menor que o valor do meio, busca na metade esquerda
        else if (key < data[middle]) 
            return recursiveBinarySearch(data, key, low, middle - 1);
        // Se a chave for maior que o valor do meio, busca na metade direita
        else 
            return recursiveBinarySearch(data, key, middle + 1, high);
    }

    // método para exibir certos valores no array
    private static String remainingElements(int[] data, int low, int high) 
    {
        StringBuilder temporary = new StringBuilder();

        // adiciona espacos para alinhamento
        for (int i = 0; i < low; i++)
            temporary.append("   ");

        // adiciona os elementos restantes no array
        for (int i = low; i <= high; i++)
            temporary.append(data[i] + " ");

        return String.format("%s%n", temporary);
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = new int[15]; // cria um array

        // Preenche o array com valores aleatórios entre 10 e 99
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        Arrays.sort(data); // A busca binária exige o array ordenado
        
        System.out.printf("%s%n%n", Arrays.toString(data)); // Exibe o array

        // Recebe um valor inteiro do usuário
        System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
        int searchInt = input.nextInt();

        // Repete a entrada de inteiros; -1 termina o programa
        while (searchInt != -1) 
        {
            // Realiza a busca binária recursiva
            int location = recursiveBinarySearch(data, searchInt, 0, data.length - 1);

            if (location == -1) // Nao encontrado
                System.out.printf("%d nao foi encontrado%n%n", searchInt);
            else // Encontrado
                System.out.printf("%d foi encontrado na posicao %d%n%n", searchInt, location);

            // Recebe outro valor do usuário
            System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
            searchInt = input.nextInt();
        }
    }    
}
