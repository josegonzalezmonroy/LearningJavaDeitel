// Figura 3.8 - Account.java
// Classe Account com uma variável de instância double balance e um construtor
// e um método de depósito que realizam validação.

public class Account
{   
   private String name; // variável de instância 
   private double balance; // variável de instância 

   // Construtor Account que recebe dois parâmetros  
   public Account(String name, double balance) 
   {
      this.name = name; // atribui nome à variável de instância name

      // valida que o saldo é maior que 0.0; se não for,
      // a variável de instância balance mantém seu valor inicial padrão de 0.0
      if (balance > 0.0) // se o saldo for válido
         this.balance = balance; // atribui-o à variável de instância balance
   }

   // método que deposita (adiciona) apenas um valor válido ao saldo
   public void deposit(double depositAmount) 
   {      
      if (depositAmount > 0.0) // se depositAmount for válido
         balance = balance + depositAmount; // adiciona ao saldo 
   }

   // método que retorna o saldo da conta
   public double getBalance()
   {
      return balance; 
   } 

   // método que define o nome
   public void setName(String name)
   {
      this.name = name; 
   } 

   // método que retorna o nome
   public String getName()
   {
      return name; 
   } 
} // fim da classe Account
