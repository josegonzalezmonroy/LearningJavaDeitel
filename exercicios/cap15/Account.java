// Figura 15.9 - Account.java
// Classe Account serializavel para armazenar registros como objetos

import java.io.Serializable;

public class Account implements Serializable 
{
    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    // inicializa uma Account com valores padrao
    public Account()
    {
        this(0, "", "", 0.0);// chama o construtor
    }

    // inicializa Account com os valores fornecidos
    public Account(int account, String firstName, String lastName, double balance)
    {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // configura o numero de conta 
    public void setAccount(int account)
    {
        this.account = account;
    }

    // obtem o numero de conta
    public int getAccount()
    {
        return account;
    }

    // configura o nome 
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // obtem o nome 
    public String getFirstName()
    {
        return firstName;
    }

    // configura o sobrenome 
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // obtem o nome 
    public String getLastName()
    {
        return lastName;
    }

    // configura o saldo 
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    // obtem o saldo
    public double getBalance()
    {
        return balance;
    }

    public void combine(TransactionRecord transactionRecord)
    {
        if (this.account == transactionRecord.getAccount())
        {
            this.balance += transactionRecord.getTransactionAmount();
        }
    }

    @Override
    public String toString() 
    {
        return String.format("%d %s %s %.2f", account, firstName, lastName, balance);
    }
}// fim da classe Account
