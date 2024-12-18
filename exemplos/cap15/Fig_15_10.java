// Figura 15.10 - CreateSequentialFile.java
// Gravando objetos sequencialmente em um arquivo com a classe ObjectOutputStream

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Fig_15_10 
{
    private static ObjectOutputStream output;// gera saida dos dados no arquivo
    public static void main(String[] args) 
    {
        openFile();
        addRecords();
        closeFile();
    }

    // abre o arquivo clients.ser
    public static void openFile()
    {
        try
        {
            output = new ObjectOutputStream(
                Files.newOutputStream(Paths.get("clients.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error open file. Terminating.");
            System.exit(1);// termina o programa
        }
    }

    // adiciona registros ao arquivo
    public static void addRecords()
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("%s%n%s%n? ",
            "Enter account number, first name, last name and balance.",
            "Enter end-off-file indicator to end input.");
        
        while (input.hasNext())// faz um loop ate o indicador de fim de arquivo
        {
            try
            {
                // cria novo registro; esse exemplo supoe uma entrada valida
                Account record = new Account(input.nextInt(),
                    input.next(), input.next(), input.nextDouble());
                
                // serializa o objeto de registro em um arquivo
                output.writeObject(record);
            }
            catch (NoSuchElementException elementException)
            {
                System.err.println("Invalid input. Please try again.");
                input.nextLine(); // descarta entrada para o usuario tentar de novo
            }
            catch (IOException ioException)
            {
                System.err.println("Error writing to file. Terminating.");
                break;
            }

            System.out.print("? ");
        }
    }

    // fecha o arquivo e termina o aplicativo
    public static void closeFile()
    {
        try 
        {
            if (output != null)
                output.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
    }
}// fim da classe CreateSequentialFile
