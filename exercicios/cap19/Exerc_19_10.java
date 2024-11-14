// 19.10 - Quicksort
// A técnica de classificação recursiva chamada quicksort usa o seguinte algoritmo dimensional básico para um array dos valores: a) Passo de partição: selecione o primeiro elemento do array não classificado e determine sua localização final no array classificado (isto é, todos os valores à esquerda do elemento no array são menores que o elemento e todos os valores à direita do elemento no array são maiores que o elemento — mostramos como fazer isso a seguir). Agora temos um elemento em sua posição adequada e dois subarrays não classificados. b) Passo recursivo: realize o Passo 1 em cada subarray não classificado. Toda vez que o Passo 1 for realizado em um subarray, outro elemento é colocado em sua posição final no array classificado e dois subarrays não classificados são criados. Quando um subarray consiste em apenas um elemento, esse elemento está na sua localização final (porque o array de um elemento já está classificado). O algoritmo básico parece suficientemente simples, mas como determinamos a posição final do primeiro elemento de cada subarray? Como um exemplo, considere o seguinte conjunto de valores (o elemento em negrito é o elemento de partição — ele será colocado em sua localização final no array classificado): 37 2 6 4 89 8 10 12 68 45. Iniciando a partir do elemento mais à direita do array, compare cada elemento com 37 até um elemento menor que 37 ser encontrado; então, permute 37 e esse elemento. O primeiro elemento menor que 37 é 12, então 37 e 12 são permutados. O novo array é 12 2 6 4 89 8 10 37 68 45. O elemento 12 está em itálico para indicar que acabou de ser permutado com 37. Iniciando a partir da esquerda do array, mas começando com o elemento depois de 12, compare cada elemento com 37 até um elemento maior que 37 ser encontrado, então permute 37 e esse elemento. O primeiro elemento maior que 37 é 89, então 37 e 89 foram permutados. O novo array é 12 2 6 4 37 8 10 89 68 45. Iniciando da direita, mas começando com o elemento antes de 89, compare cada elemento com 37 até um elemento menor que 37 ser encontrado — então, permute 37 e esse elemento. O primeiro elemento menor que 37 é 10, então 37 e 10 são permutados. O novo array é 12 2 6 4 10 8 37 89 68 45 Iniciando da esquerda, mas começando com o elemento depois de 10, compare cada elemento com 37 até um elemento maior que 37 ser encontrado — então, permute 37 e esse elemento. Não há mais elementos maiores que 37, então, quando comparamos 37 com ele mesmo, sabemos que 37 foi colocado na sua localização final no array classificado. Cada valor à esquerda do 37 é menor que ele e cada valor à direita do 37 é maior que ele. Uma vez que a partição foi aplicada no array anterior, há dois subarrays não classificados. O subarray com valores menores que 37 contém 12, 2, 6, 4, 10 e 8. O subarray com valores maiores que 37 contém 89, 68 e 45. A classificação continua recursivamente, com ambos os subarrays sendo particionados da mesma maneira que o array original. Com base na discussão precedente, escreva o método recursivo quickSortHelper para classificar um array unidimensional de inteiros. O método deve receber como argumentos um indice inicial e um indice final no array original sendo classificado.
import java.security.SecureRandom;
import java.util.Arrays;

public class Exerc_19_10
{
    // Método principal para testar o quicksort
    public static void main(String[] args) 
    {
        SecureRandom generator = new SecureRandom();

        int[] data = new int[10]; // cria um array

        // Preenche o array com valores aleatórios entre 10 e 99
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        System.out.println("Array original: " + Arrays.toString(data));
    
        quickSort(data);
    
        System.out.println("Array ordenado: " + Arrays.toString(data));
    }

    public static void quickSort(int[] lista) 
    {
        // Chama o metodo quickSort auxiliar com os indices inicial e final do array
        quickSortHelper(lista, 0, lista.length - 1);
    }
    
    private static void quickSortHelper(int[] lista, int start_pos, int end_pos)
    {
        // Seleciona o primeiro elemento do array (ou subarray) como o pivo
        int pivot = lista[start_pos];
        
        // Inicializa os indices esquerdo (left) e direito (right)
        int left = start_pos;
        int right = end_pos;
    
        // O loop continua enquanto os indices nao se cruzarem
        while (left <= right) 
        {
            // Encontra um elemento maior ou igual ao pivo a partir da esquerda
            while (lista[left] < pivot) 
            {
                left++;    
            }
    
            // Encontra um elemento menor ou igual ao pivo a partir da direita
            while (lista[right] > pivot) 
            {
                right--;
            }
    
            // Se os indices nao se cruzaram, troca os elementos
            if (left <= right)
            {
                // Troca os elementos nas posicoes left e right
                int temp = lista[left];
                lista[left] = lista[right];
                lista[right] = temp;
    
                // Avanca o indice esquerdo
                left++;
    
                // Retrai o indice direito
                right--;
            }
        }
    
        // Recursivamente ordena o subarray a esquerda do pivo
        if (start_pos < right)
            quickSortHelper(lista, start_pos, right); 
        
        // Recursivamente ordena o subarray a direita do pivo
        if (left < end_pos) 
            quickSortHelper(lista, left, end_pos);
    }    
}
