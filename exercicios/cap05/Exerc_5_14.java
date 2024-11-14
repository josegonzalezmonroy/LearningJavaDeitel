// 5.14 - Programa de juros compostos modificado
// Modifique o aplicativo de juros compostos da Figura 5.6 para repetir os passos para taxas de juros de 5% 6% 7% 8% 9% 10%. Utilize um loop for para variar a taxa de juros
public class Exerc_5_14 
{
    public static void main(String[] args) 
    {
        double amount; // quantia em deposito ao fim de cada ano
        double principal = 1000.0; // quantidade inicial antes dos juros

        //exibe cabeçalhos
        System.out.printf("%s%12s%12s%12s%12s%12s%12s%n", "Year", "5%", "6%", "7%", "8%", "9%", "10%");
        
        //calcula a quantidade de deposito para cada um dos dez anos
        for (int year = 1; year <= 10; year++)
        {
            System.out.printf("%4d", year);

            for (double rate = 0.05; rate <= 0.10;)
            {   
                amount = principal * Math.pow(1.0 + rate, year);

                System.out.printf("%,12.2f", amount);
                rate += 0.01;
            }
            System.out.println();
        }
    }    
}
