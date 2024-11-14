import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch 
{
    public static void main(String[] args) 
    {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<TransactionRecord> transactions = new ArrayList<>();

        // Ler o arquivo-mestre (oldmast.txt)
        try  
        {
            Scanner masterInput = new Scanner(new File("oldmast.txt"));
            
            // Ler cada linha do arquivo-mestre e adicionar os dados à lista de contas
            while (masterInput.hasNext()) 
            {
                int accountNumber = masterInput.nextInt();  // Número da conta
                String firstName = masterInput.next();      // Nome
                String lastName = masterInput.next();       // Sobrenome
                double balance = masterInput.nextDouble();  // Saldo
                accounts.add(new Account(accountNumber, firstName, lastName, balance));
            }
        } 
        catch (FileNotFoundException e) 
        {
            // Exibe erro se o arquivo-mestre não for encontrado
            System.err.println("Erro ao abrir o arquivo-mestre.");
            System.exit(1);
        }

        // Ler o arquivo de transações (trans.txt)
        try  
        {
            Scanner transactionInput = new Scanner(new File("trans.txt"));

            // Ler cada linha do arquivo de transações e adicionar à lista de transações
            while (transactionInput.hasNext()) 
            {
                int accountNumber = transactionInput.nextInt();  // Número da conta
                double transactionAmount = transactionInput.nextDouble();  // Quantia da transação
                transactions.add(new TransactionRecord(accountNumber, transactionAmount));
            }
        } 
        catch (FileNotFoundException e) 
        {
            // Exibe erro se o arquivo de transações não for encontrado
            System.err.println("Erro ao abrir o arquivo de transações.");
            System.exit(1);
        }

        // Processar as correspondências e gerar o arquivo de log
        try  
        {
            Formatter newMasterOutput = new Formatter("newmast.txt");  // Criar novo arquivo-mestre
            Formatter logOutput = new Formatter("log.txt");  // Criar arquivo de log

            // Para cada conta, aplicar as transações correspondentes
            for (Account account : accounts) 
            {
                boolean transactionFound = false;
                for (TransactionRecord transaction : transactions) 
                    if (account.getAccount() == transaction.getAccount()) 
                    {
                        account.combine(transaction);  // Combinar transação com a conta
                        transactionFound = true;
                    }

                newMasterOutput.format("%s%n", account);  // Gravar a conta atualizada no novo arquivo-mestre
                
                // Exibir mensagem se não houver transações para a conta
                if (!transactionFound) 
                    System.out.printf("Sem transações para a conta %d%n", account.getAccount());
            }

            ArrayList<TransactionRecord> accountsNotFound = new ArrayList<>(); 

            // Verificar transações sem correspondência de conta
            for (TransactionRecord transaction : transactions) 
            {
                boolean accountFound = false;
                for (Account account : accounts) 
                    if (account.getAccount() == transaction.getAccount()) 
                    {
                        accountFound = true;
                        break;
                    }

                // Se nenhuma conta corresponder, adicionar ao log de contas não encontradas
                if (!accountFound)
                {
                    accountsNotFound.add(transaction);

                    // Gravar no arquivo de log transações que não têm contas correspondentes
                    for (TransactionRecord account : accountsNotFound)
                        if (account.getAccount() != transaction.getAccount())
                            logOutput.format("Registro de transação não correspondente para a conta %d%n", transaction.getAccount());
                }
            }

            // Fechar os arquivos
            newMasterOutput.close();
            logOutput.close();
        } 
        catch (FileNotFoundException e) 
        {
            // Exibe erro se os arquivos não puderem ser gravados
            System.err.println("Erro ao gravar os arquivos.");
            System.exit(1);
        }

        // Mensagem de conclusão do processo de correspondência
        System.out.println("Processo de correspondência de arquivos concluído.");
    }
}
