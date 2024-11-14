import java.io.FileNotFoundException;
import java.util.Formatter;

public class Responses 
{
    // Array de respostas dos alunos
    private static int[] responses = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14 };

    public static void main(String[] args) 
    {
        try 
        {
            // Cria o arquivo "numbers.txt" para gravar as respostas
            Formatter numbers = new Formatter("numbers.txt");

            // Escreve cada resposta no arquivo
            for (int response : responses) 
                numbers.format("%d%n", response); 
                
            // Fecha o formatter apos gravar os dados
            numbers.close();
        } 
        catch (FileNotFoundException fileNotFoundException)
        {
            // Exibe mensagem de erro se o arquivo "numbers.txt" nao puder ser criado
            System.err.println("Erro ao criar o arquivo numbers.");
            System.exit(1);
        } 
    }    
}
