// 5.18 - Programa de juros compostos modificado
// Modifique a figura 5.6 para utilizar apenas inteiros para calcular os juros compostos. [Dica: trate todas as quantidades monetarias como numeros inteiros em centavos. Entao divida o resultado em suas partes dolar e centavos utilizando as operacoes divisao e resto, respectivamente. Insira uma virgula entre as partes dolar e centavos.]
public class Exerc_5_18 
{
    public static void main(String[] args) 
    {
        int number = 100000;
        int rate = 105;

        //exibe cabeçalhos
        System.out.printf("%s%20s %n", "Year", "Amount on deposit");
        
        for (int year = 1; year <= 10; year++)
        {
            int dolarInteiro = (number*rate)/10000;
            int centavos = (number*rate)%10000/1000;
            
            System.out.printf("%4d%18d,%d%n", year, dolarInteiro, centavos);
            
            number = (number*rate)/100;
        }
    }    
}
