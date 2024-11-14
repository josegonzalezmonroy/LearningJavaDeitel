// Figura 8.16 - Interest.java
// Calculos de juros compostos com BigDecimal
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Fig_8_16 
{
    public static void main(String[] args) 
    {
        //quantidade principal inicial antes dos juros
        BigDecimal principal = BigDecimal.valueOf(1000.0); 
        BigDecimal rate = BigDecimal.valueOf(0.05);
        
        // exibe calculos
        System.out.printf("%s%20s%n", "Year", "Amount on deposit");

        // calcula quantidade de deposito para cada um dos dez anos
        for (int year = 1; year <= 10; year++)
        {
            // calcula nova quantidade durante ano especiicado
            BigDecimal amount = 
                principal.multiply(rate.add(BigDecimal.ONE).pow(year));// 1 + 0.05 ^ year
            
            // exibe o ano e a quantidade
            System.out.printf("%4d%20s%n", year,
                NumberFormat.getCurrencyInstance().format(amount));
        }
    }    
}// fim da classe interest
