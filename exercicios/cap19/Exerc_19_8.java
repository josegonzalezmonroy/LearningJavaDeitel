// 19.8 - Pesquisa linear recursiva
// Modifique a Figura 19.2 para usar o método recursivo recursiveLinearSearch para realizar uma pesquisa linear do array. O método deve receber a chave de pesquisa e o índice inicial como argumentos. Se a chave de pesquisa for encontrada, seu índice no array é retornado; caso contrário, –1 é retornado. Cada chamada ao método recursivo deve verificar um índice no array.

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Exerc_19_8 
{
    // realiza uma busca linear recursiva nos dados              
    public static int recursiveLinearSearch(int[] data, int searchKey, int index) 
    {                                                   
        // Condicao de parada: se o índice for maior ou igual ao tamanho do array
        if (index >= data.length) 
            return -1; // valor nao foi encontrado

        // Se o valor no índice atual for igual à chave de pesquisa, retorna o índice
        if (data[index] == searchKey) 
            return index; // retorna o índice do valor encontrado

        // Chamada recursiva para o próximo índice
        return recursiveLinearSearch(data, searchKey, index + 1);
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = new int[10]; // cria um array de 10 elementos

        // Preenche o array com valores aleatórios entre 10 e 99
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        // Exibe o conteúdo do array
        System.out.printf("%s%n%n", Arrays.toString(data));

        // Obtém a entrada do usuário
        System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
        int searchInt = input.nextInt();

        // Continua solicitando entradas até que -1 seja inserido
        while (searchInt != -1) 
        {
            // Chama o método recursivo para realizar a busca
            int position = recursiveLinearSearch(data, searchInt, 0); 

            if (position == -1)  // nao encontrado
                System.out.printf("%d nao foi encontrado%n%n", searchInt);
            else  // encontrado
                System.out.printf("%d foi encontrado na posicao %d%n%n", searchInt, position);

            // Obtém a próxima entrada do usuário
            System.out.print("Por favor, insira um valor inteiro (-1 para sair): ");
            searchInt = input.nextInt();
        }
    }   
}
