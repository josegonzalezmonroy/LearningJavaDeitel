import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateDataSerializable 
{
    private static ObjectOutputStream oldMaster;
    private static ObjectOutputStream transactions;
    
    public static void main(String[] args) 
    {
        createMaster();
        createTransactions();
        addRecords();
    }

    public static void createMaster()
    {
        try
        {
            oldMaster = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Erro ao criar o arquivo-mestre.");
            System.exit(1);
        } 
    }

    public static void createTransactions()
    {
        try
        {
            transactions = new ObjectOutputStream(Files.newOutputStream(Paths.get("transactions.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Erro ao criar o arquivo de transacoes.");
            System.exit(1);
        }
    }

    public static void addRecords()
    {
        try
        {
            Account[] accounts = new Account[4];

            accounts[0] = new Account(100, "Alan", "Jones", 348.17);
            accounts[1] = new Account(300, "Mary", "Smith", 27.19);
            accounts[2] = new Account(500, "Sam", "Sharp", 0.0);
            accounts[3] = new Account(700, "Suzy", "Green", -14.22);

            for (Account account : accounts) 
                oldMaster.writeObject(account);

            oldMaster.close();    
        }
        catch (IOException ioException)
        {
            System.err.println("Erro escrevendo o arquivo-mestre. Finalizando");
            System.exit(1);
        }

        try
        {
            TransactionRecord[] transactionRecords = new TransactionRecord[8];

            transactionRecords[0] = new TransactionRecord(100, 27.14);
            transactionRecords[1] = new TransactionRecord(300, 62.11);
            transactionRecords[2] = new TransactionRecord(400, 100.56);  // Transacao sem correspondência
            transactionRecords[3] = new TransactionRecord(900, 82.17);  // Transacao sem correspondência 
            transactionRecords[4] = new TransactionRecord(300, 83.89);
            transactionRecords[5] = new TransactionRecord(700, 80.78);
            transactionRecords[6] = new TransactionRecord(700, 1.53);
            transactionRecords[7] = new TransactionRecord(400, 3.33);

            for (TransactionRecord transactionRecord : transactionRecords) 
                transactions.writeObject(transactionRecord);

            transactions.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Erro ao criar o arquivo de transacoes.");
            System.exit(1);
        }
    }
}
