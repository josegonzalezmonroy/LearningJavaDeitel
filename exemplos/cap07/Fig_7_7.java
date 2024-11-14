// Figura 7.7 - RollDie.java
// Programa de jogo de dados utilizando arrays em vez de switch
import java.security.SecureRandom;

public class Fig_7_7 
{
    public static void main(String[] args) 
    {
        SecureRandom randomNumbers = new SecureRandom();
        int[] frecuency = new int[7]; // array de contadores de frecuencia 

        // lança o dado 6.000.000 vezes; usa o valor do dado como indice de frequência
        for (int roll = 1; roll <= 6000000; roll++)
            ++frecuency[1 + randomNumbers.nextInt(6)];
        
        System.out.printf("%s%10s%n", "Face", "Frequency");

        // gera saída do valor de cada elemento do array
        for (int face = 1; face < frecuency.length; face++)
            System.out.printf("%4d%10d%n", face, frecuency[face]);
    }    
}// fim da classe RollDie

