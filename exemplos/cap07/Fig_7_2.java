// Figura 7.2 - InitArray.java
// Inicializando os elementos de um array como valores padrão de zero

public class Fig_7_2
{
    public static void main(String[] args) 
    {
        // declara array variável e o inicializa com um objetivo array
        int[] array = new int[10];// cria o objeto array
        
        System.out.printf("%s%8s%n", "Index", "Value");// títulos de coluna

        // gera saída do valor de cada elemento do array
        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
} // fim da classe InitArray