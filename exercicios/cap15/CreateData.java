import java.io.FileNotFoundException;
import java.util.Formatter;

public class CreateData 
{
    public static void main(String[] args) 
    {
        // Tenta criar e preencher o arquivo oldmast.txt com os registros de clientes.
        try 
        {
            Formatter oldMaster = new Formatter("oldmast.txt");

            // Adiciona os registros de clientes no arquivo mestre (oldmast.txt).
            oldMaster.format("%d %s %s %.2f%n", 100, "Alan", "Jones", 348.17);
            oldMaster.format("%d %s %s %.2f%n", 300, "Mary", "Smith", 27.19);
            oldMaster.format("%d %s %s %.2f%n", 500, "Sam", "Sharp", 0.0);
            oldMaster.format("%d %s %s %.2f%n", 700, "Suzy", "Green", -14.22);  
            
            // Fecha o arquivo oldmast.txt.
            oldMaster.close();
        }
        // Captura exceção caso o arquivo oldmast.txt não possa ser criado.
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Erro ao criar o arquivo-mestre.");
            System.exit(1);
        } 
        
        // Tenta criar e preencher o arquivo trans.txt com os registros de transacoes.
        try 
        {
            Formatter transactions = new Formatter("trans.txt");

            // Adiciona os registros de transacoes no arquivo de transacoes (trans.txt).
            transactions.format("%d %.2f%n", 100, 27.14);  // Transação correspondente
            transactions.format("%d %.2f%n", 300, 62.11);  // Transação correspondente
            transactions.format("%d %.2f%n", 400, 100.56); // Transação sem correspondência
            transactions.format("%d %.2f%n", 900, 82.17);  // Transação sem correspondência

            // Fecha o arquivo trans.txt.
            transactions.close();
        } 
        // Captura exceção caso o arquivo trans.txt não possa ser criado.
        catch (FileNotFoundException fileNotFoundException) 
        {
            System.err.println("Erro ao criar o arquivo de transacoes.");
            System.exit(1);
        }

        // Confirma que os arquivos de teste foram criados com sucesso.
        System.out.println("Arquivos de teste criados.");
    }    
}
