// 18.16 - Exibir um array
// Escreva um método recursivo printArray que exibe todos os elementos em um array de inteiros, separados por espaços.

public class Exerc_18_16 
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // array de exemplo
        String results = printArray(array, 0); // chama o metodo para imprimir o array
        System.out.println(results); // exibe o resultado
    }

    public static String printArray(int[] array2, int x)
    {
        if (x < array2.length) // condicao de parada
            return String.format("%d %s", array2[x], printArray(array2, x + 1)); 
        else
            return ""; // caso base
    }
}
