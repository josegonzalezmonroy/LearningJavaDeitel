// 18.18 - Localizar o valor mínimo em um array
// Escreva um método recursivo recursiveMinimum que determina o menor elemento em um array de inteiros. O método deve retornar quando ele receber um array de um elemento.
public class Exerc_18_18 
{
    public static void main(String[] args) 
    {
        // Define o array de inteiros
        int[] array = {12, 7, 3, 8, 15, 2, 9};

        // Chama o metodo recursivo e exibe o menor valor
        System.out.printf("O menor valor no array e: %d%n", recursiveMinimum(array));
    }

    // Método público sem índice
    public static int recursiveMinimum(int[] array) 
    {
        return recursiveMinimum(array, array.length); // Chama a versão privada começando com o array completo
    }

    // Método privado que usa o índice
    private static int recursiveMinimum(int[] array, int tamanho) 
    {
        if (tamanho == 1) 
            return array[0]; // Se o array tem um único elemento, esse é o menor

        // Chama recursivamente com um array menor
        int menorRestante = recursiveMinimum(array, tamanho - 1);

        // Retorna o menor entre o último elemento do array atual e o menor do restante
        return Math.min(array[tamanho - 1], menorRestante);
    }
}