// Figura 3.9 - AccountTest.java
// Entrada e saída de números de ponto flutuante com objetos Account.
import java.util.Scanner;

public class AccountTest
{
   public static void main(String[] args) 
   {
      Account account1 = new Account("Jane Green", 50.00);
      Account account2 = new Account("John Blue", -7.53); 

      // exibe o saldo inicial de cada objeto
      System.out.printf("%s saldo: $%.2f%n",
         account1.getName(), account1.getBalance()); 
      System.out.printf("%s saldo: $%.2f%n%n",
         account2.getName(), account2.getBalance()); 

      // cria um Scanner para obter entrada do console
      Scanner input = new Scanner(System.in);

      System.out.print("Digite o valor do depósito para account1: "); // prompt
      double depositAmount = input.nextDouble(); // obtém entrada do usuário
      System.out.printf("%nadicionando %.2f ao saldo de account1%n%n", 
         depositAmount);
      account1.deposit(depositAmount); // adiciona ao saldo de account1

      // exibe saldos
      System.out.printf("%s saldo: $%.2f%n",
         account1.getName(), account1.getBalance()); 
      System.out.printf("%s saldo: $%.2f%n%n",
         account2.getName(), account2.getBalance()); 

      System.out.print("Digite o valor do depósito para account2: "); // prompt
      depositAmount = input.nextDouble(); // obtém entrada do usuário
      System.out.printf("%nadicionando %.2f ao saldo de account2%n%n", 
         depositAmount);
      account2.deposit(depositAmount); // adiciona ao saldo de account2

      // exibe saldos
      System.out.printf("%s saldo: $%.2f%n", 
         account1.getName(), account1.getBalance()); 
      System.out.printf("%s saldo: $%.2f%n%n",
         account2.getName(), account2.getBalance()); 
   } // fim do método main
} // fim da classe AccountTest
