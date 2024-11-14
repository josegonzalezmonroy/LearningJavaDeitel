// Figura 5.6 - Interest.java
// Cálculos de juros compostos com for.

public class Interest 
{
   public static void main(String args[])
   {
      double amount; // valor depositado ao final de cada ano
      double principal = 1000.0; // valor inicial antes dos juros
      double rate = 0.05; // taxa de juros

      // exibir cabeçalhos
      System.out.printf("%s%20s%n", "Ano", "Valor em depósito");

      // calcular o valor em depósito para cada um dos dez anos
      for (int year = 1; year <= 10; year++) 
      {
         // calcular novo valor para o ano especificado
         amount = principal * Math.pow(1.0 + rate, year);

         // exibir o ano e o valor
         System.out.printf("%4d%,20.2f%n", year, amount);
      } 
   }
} // fim da classe Interest
