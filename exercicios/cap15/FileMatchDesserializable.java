import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;

public class FileMatchDesserializable 
{
    public static void main(String[] args) 
    {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<TransactionRecord> transactions = new ArrayList<>();

        // Ler o arquivo-mestre (oldmast.ser)
        try  
        {
            ObjectInputStream masterInput = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.ser")));
            
            // Ler cada objeto do arquivo-mestre e adicionar a lista de contas
            while (true) 
            {
                try
                {
                    Account account = (Account) masterInput.readObject();
                    accounts.add(account);
                }
                catch (IOException ioException)
                {
                    // Interrompe o loop quando nao ha mais objetos para ler
                    break;
                }
            }
        } 
        catch (IOException ioException) 
        {
            // Exibe erro se o arquivo-mestre nao for encontrado
            System.err.println("Erro ao abrir o arquivo-mestre.");
            System.exit(1);
        }
        catch (ClassNotFoundException exception)
        {
            // Exibe erro se a classe nao for encontrada
            System.err.println("ClassNotFoundException no arquivo-mestre.");
            System.exit(1);        
        }

        // Ler o arquivo de transacoes (transactions.ser)
        try  
        {
            ObjectInputStream transactionInput = new ObjectInputStream(Files.newInputStream(Paths.get("transactions.ser")));

            // Ler cada objeto do arquivo de transacoes e adicionar a lista de transacoes
            while (true) 
            {
                try
                {
                    TransactionRecord transaction = (TransactionRecord) transactionInput.readObject();
                    transactions.add(transaction);
                }
                catch (IOException ioException)
                {
                    // Interrompe o loop quando nao ha mais objetos para ler
                    break;
                }
            }
        } 
        catch (IOException ioException) 
        {
            // Exibe erro se o arquivo de transacoes nao for encontrado
            System.err.println("Erro ao abrir o arquivo de transacoes.");
            System.exit(1);
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            // Exibe erro se a classe nao for encontrada
            System.err.println("ClassNotFoundException no arquivo de transacoes.");
            System.exit(1);        
        }

        // Processar as correspondencias e gerar o arquivo de log
        try  
        {
            Formatter newMasterOutput = new Formatter("newmastdes.txt");  // Criar novo arquivo-mestre
            Formatter logOutput = new Formatter("logdes.txt");  // Criar arquivo de log

            // Para cada conta, aplicar as transacoes correspondentes
            for (Account account : accounts) 
            {
                boolean transactionFound = false;
                for (TransactionRecord transaction : transactions) 
                    if (account.getAccount() == transaction.getAccount()) 
                    {
                        account.combine(transaction);  // Combinar transacao com a conta
                        transactionFound = true;
                    }

                newMasterOutput.format("%s%n", account);  // Gravar a conta atualizada no novo arquivo-mestre
                
                // Exibir mensagem se nao houver transacoes para a conta
                if (!transactionFound) 
                    System.out.printf("Sem transacoes para a conta %d%n", account.getAccount());
            }

            ArrayList<TransactionRecord> accountsNotFound = new ArrayList<>(); 

            // Verificar transacoes sem correspondencia de conta
            for (TransactionRecord transaction : transactions) 
            {
                boolean accountFound = false;
                for (Account account : accounts) 
                    if (account.getAccount() == transaction.getAccount()) 
                    {
                        accountFound = true;
                        break;
                    }

                // Se nenhuma conta corresponder, adicionar ao log de contas nao encontradas
                if (!accountFound)
                {
                    accountsNotFound.add(transaction);

                    // Gravar no arquivo de log transacoes que nao tem contas correspondentes
                    for (TransactionRecord record : accountsNotFound)
                        if (record.getAccount() != transaction.getAccount())
                            logOutput.format("Registro de transacao nao correspondente para a conta %d%n", transaction.getAccount());
                }
            }

            // Fechar os arquivos
            newMasterOutput.close();
            logOutput.close();
        } 
        catch (FileNotFoundException e) 
        {
            // Exibe erro se os arquivos nao puderem ser gravados
            System.err.println("Erro ao gravar os arquivos.");
            System.exit(1);
        }

        // Mensagem de conclusao do processo de correspondencia
        System.out.println("Processo de correspondencia de arquivos concluido.");
    }
}
