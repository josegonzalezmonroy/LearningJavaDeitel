// 8.18 - Classe Account com saldo BigDecimal
// Reescreva a classe Account da Seção 3.5 para armazenar o saldo como um objeto BigDecimal e para realizar todos os cálculos usando BigDecimals.

import java.math.BigDecimal;

public class Exerc_8_18 
{
    public static void main(String[] args) 
    {
        Account account1 = new Account("Maria", BigDecimal.valueOf(1370.54));  
        double deposito = 150.75;
        double saque = 342.83;

        System.out.println("Saldo inicial: " + account1.getBalance());
        System.out.println("\nDepósito: " + deposito);
        account1.deposit(BigDecimal.valueOf(deposito));
        System.out.println("Saldo: " + account1.getBalance());

        System.out.println("\nSaque: " + saque);
        String saqueResult = account1.withdraw(BigDecimal.valueOf(saque));
        System.out.println("Resultado do saque: " + saqueResult);
        System.out.println("Saldo: " + account1.getBalance());
    }
}

class Account 
{
    private String name; // variável de instância para o nome
    private BigDecimal balance; // variável de instância para o saldo

    // Construtor da Account que recebe dois parâmetros 
    public Account(String name, BigDecimal balance) 
    {
        this.name = name; // atribui name à variável de instância name
        
        // Valida que o balance é maior que 0.0; se não for,
        // a variável de instância balance mantém seu valor inicial padrão de 0.0
        if (balance.compareTo(BigDecimal.ZERO) > 0) 
        // se o saldo for válido
            this.balance = balance; // o atribui à variável de instância balance 
         else 
            this.balance = BigDecimal.ZERO;
    }

    // Método que deposita (adiciona) apenas uma quantia válida no saldo
    public void deposit(BigDecimal depositAmount) 
    {
        if (depositAmount.compareTo(BigDecimal.ZERO) > 0) 
            // se depositAmount for válido
            balance = balance.add(depositAmount); // adiciona ao saldo
    }

    // Método que retira uma quantia do saldo se for válida
    public String withdraw(BigDecimal withdrawAmount) 
    {        
        if (withdrawAmount.compareTo(balance) <= 0) 
        {
            balance = balance.subtract(withdrawAmount);
            return "Ok";
        } 
        else 
            return "A quantidade de saque excedeu o saldo da conta";
    }

    // Método que retorna o saldo da conta
    public BigDecimal getBalance() 
    {
        return balance;
    }

    // Método que define o nome
    public void setName(String name) 
    {
        this.name = name;
    }

    // Método que retorna o nome 
    public String getName() 
    {
        return name; // retorna o valor de name para o chamador 
    }
} // fim da classe Account 