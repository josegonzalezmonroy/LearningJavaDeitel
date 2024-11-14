// 5.20 - Calculando o valor de pi
// Imprima uma tabela que mostre o valor de pi calculando os 200000 primeiros termos dessa serie. Quantos termos voce tem de utilizar antes de primeiro obter um valor que começa com 3.14159?
public class Exerc_5_20 
{
    public static void main(String[] args) 
    {
        int number1 = 4;
        int number2 = 1;
        double pi = 0;

        
        for (int i = 1; i <= 200000; i++)
        {
            double result = (double) number1/number2;
            
            switch (i%2) 
            {
                case 1:
                pi+=result;
                break;
                case 0:
                pi-=result;
                break;
            }
            number2+=2;
            
            if ((int)(pi*100000)/1 == 314159)
            {
                System.out.printf("%d: %.10f%n", i,pi);
                break;
            }    
        }
    }    
}
