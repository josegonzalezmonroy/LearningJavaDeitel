// Figura 6.7 - RollDie.java
// Rola um dado de seis lados 6.000.000 vezes.
import java.security.SecureRandom;

public class Fig_6_7 
{
    public static void main(String[] args) 
    {
        // o objeto randomNumbers produzirá números aleatórios seguros
        SecureRandom randomNumbers = new SecureRandom();
        
        int frequency1 = 0; // contgem de 1s lançados
        int frequency2 = 0; // contgem de 2s lançados
        int frequency3 = 0; // contgem de 3s lançados
        int frequency4 = 0; // contgem de 4s lançados
        int frequency5 = 0; // contgem de 5s lançados
        int frequency6 = 0; // contgem de 6s lançados

        // soma 6.000.000 lançamentos de um dado
        for (int roll = 1; roll < 6000000; roll++) 
        {
            int face = 1 + randomNumbers.nextInt(6);

            // usa o valor 1-6 para as faces a fim e determinar qual contador incrementar
            switch (face) 
            {
                case 1:
                    ++frequency1; // incrementa o contador de 1s                   
                    break;
                case 2:
                    ++frequency2; // incrementa o contador de 2s                   
                    break;                
                case 3:
                    ++frequency3; // incrementa o contador de 3s                   
                    break;                
                case 4:
                    ++frequency4; // incrementa o contador de 4s                   
                    break;                
                case 5:
                    ++frequency5; // incrementa o contador de 5s                   
                    break;                
                case 6:
                    ++frequency6; // incrementa o contador de 6s                   
                    break;
            }
        }

        System.out.println("Face\tFrequency");// cabeçalhos de saída
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n", 
            frequency1, frequency2, frequency3, frequency4, 
            frequency5, frequency6);
    }    
}// fim da classe RollDie
