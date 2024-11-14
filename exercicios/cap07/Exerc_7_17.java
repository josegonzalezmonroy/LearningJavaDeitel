import java.security.SecureRandom;

public class Exerc_7_17 
{
    // cria um gerador seguro de numeros aleatorios
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static void main(String[] args) 
    {
        int[] array = new int[11];// array para armazenar as jogadas
        int lances = 6000000;// numero de jogadas

        for (int count = 0; count < lances; count++)
        {
            array[dado() - 2]++;// adiciona 1 na posicicao do array dependendo do resultado 
        }
        // exibe os resultados
        System.out.printf("Resultados dos %d lances%n%n", lances);
        
        System.out.printf("%-6s%6s%n","Valor", "Vezes");     
        
        for (int valor = 0; valor < array.length; valor++)
        {
            System.out.printf("%-5d%8d%n", (valor + 2), array[valor]);
        }
    }
    
    public static int dado()// gera uma lance aleatorio
    {
        int dado1 = 1 + randomNumbers.nextInt(6);// primeiro lançamento
        int dado2 = 1 + randomNumbers.nextInt(6); // segundo lançamento
        
        return dado1 + dado2;// retorna a soma dos dois lançamentos
    }
}
