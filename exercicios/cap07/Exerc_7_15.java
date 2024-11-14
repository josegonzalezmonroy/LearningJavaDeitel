// 7.15 - Argumentos de linha de comando
// Reescreva a figura 7.2 para que o tamanho do array seja especificado pelo primeiro argumento da linha de comando, se nenhum argumento de linha de comando for passado, utilize 10 como tamanho-padrão do array.

public class Exerc_7_15 
{
    public static void main(String[] args) 
    {
        int arrayLength; 

        if (args.length == 0)// se args.length == 0, o usuario não passou nenhum argumento pela linha de comando
            arrayLength = 10;// tamanho do array por padrão
        else 
           arrayLength = Integer.parseInt(args[0]);// obtém o tamanho do array a partir do primeiro argumento de linha de comando

        int[] array = new int[arrayLength];

        int initialValue = 1;
        int increment = 4;

        // calcula valor de cada elemento do array
        for (int counter = 0; counter < array.length; counter++)
            array[counter] = initialValue + increment * counter;
        
        System.out.printf("%s%8s%n", "Index", "Value");

        // exibe o valor e o índice de array
        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);    
        }    
}
