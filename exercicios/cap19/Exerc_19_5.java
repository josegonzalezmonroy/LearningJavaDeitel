// 19.5 - Classificação por borbulhamento
// Implemente uma classificação por borbulhamento — outra técnica de classificação simples, mas ineficiente. É chamada classificação por borbulhamento ou classificação por afundamento porque os menores valores gradualmente "borbulham" no seu caminho para a parte superior do array (isto é, na direção do primeiro elemento) como bolhas de ar que emergem na superfície, enquanto os maiores valores afundam na parte inferior (final) do array. A técnica utiliza loops aninhados para fazer várias passagens pelo array. Cada passagem compara pares sucessivos de elementos. Se um par estiver na ordem crescente (ou os valores forem iguais), a classificação por borbulhamento deixa os valores como estão. Se um par estiver na ordem decrescente, a classificação por borbulhamento troca seus valores no array. A primeira passagem compara os dois primeiros elementos do array e troca seus valores, se necessário. Ela então compara o segundo e terceiro elementos no array. O final dessa passagem compara os dois últimos elementos no array e troca-os, se necessário. Depois de uma passagem, o maior elemento estará no último índice. Depois de duas passagens, os dois maiores elementos estarão nos dois últimos índices. Explique por que a classificação por borbulhamento é um algoritmo O(n2).
import java.security.SecureRandom; 
import java.util.Arrays; 

public class Exerc_19_5 
{
    public static void main(String[] args) 
    {
        SecureRandom generator = new SecureRandom(); // Cria um gerador de numeros aleatorios seguro

        int[] array = new int[7]; // Cria um array de inteiros com tamanho 7

        // Preenche o array com numeros aleatorios entre 10 e 99
        for (int i = 0; i < array.length; i++) 
            array[i] = 10 + generator.nextInt(90);

        // Exibe o array antes da ordenacao
        System.out.printf("Array sem ordenar --> %s%n", Arrays.toString(array));

        bubbleSort(array); // Chama o metodo para ordenar o array

        // Exibe o array depois da ordenacao
        System.out.printf("Array ordenado -----> %s%n", Arrays.toString(array));
    }

    // Metodo que implementa a classificacao por borbulhamento
    public static void bubbleSort(int[] array) 
    {
        // Loop para passar pelo array varias vezes
        for (int i = 0; i <= array.length; i++) 
            // Loop para comparar elementos adjacentes
            for (int j = 0; j < array.length - 1; j++)
                // Compara os elementos adjacentes
                if (array[j] > array[j + 1]) 
                {
                    // Troca se estiver na ordem errada
                    int temp = array[j]; // Armazena o elemento atual em uma variavel temporaria
                    array[j] = array[j + 1]; // Troca o elemento atual pelo proximo
                    array[j + 1] = temp; // Coloca o elemento armazenado na posicao correta
                }
    }
}
