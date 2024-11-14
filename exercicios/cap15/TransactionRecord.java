import java.io.Serializable;

public class TransactionRecord implements Serializable
{
    private int account;
    private double transactionAmount;
    
    public TransactionRecord(int account, double transactionAmount)
    {
        this.account = account;
        this.transactionAmount = transactionAmount;
    }

    // Métodos de acesso
    public int getAccount()
    {
        return account;
    }

    public double getTransactionAmount()
    {
        return transactionAmount;
    }
}
