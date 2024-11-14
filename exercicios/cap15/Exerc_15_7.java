import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exerc_15_7
{
    // Array que mapeia cada digito para suas letras correspondentes
    private static final String[] DIGIT_TO_LETTERS =
    {
        "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"
    };
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
                
        while (true) 
        {
            try 
            {
                System.out.print("Por favor, insira um numero de 7 digitos: ");
                String input = scanner.nextLine();

                // Define a expressao regular para validar um numero de 7 digitos
                Pattern pattern = Pattern.compile("\\d{7}");
                Matcher matcher = pattern.matcher(input);

                // Se a entrada nao corresponder ao formato esperado, lança uma excecao
                if (!matcher.matches()) 
                {
                    throw new IllegalArgumentException("O numero deve conter exatamente 7 digitos.");
                }

                // Chama o metodo para gerar e salvar as combinacoes
                printStream(input);
                break;  // Sai do loop se o numero for valido

            } 
            catch (IllegalArgumentException e) 
            {
                // Exibe a mensagem de erro caso a entrada seja invalida
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // Metodo para gerar e salvar todas as combinacoes de letras
    public static void printStream(String number)
    {
        try
        {
            // Cria um Formatter para escrever em um arquivo
            Formatter combinations = new Formatter("combinations.txt");
            
            // Prepara os conjuntos de letras para cada digito do numero
            String[] letterSets = new String[number.length()];
            
            for (int i = 0; i < number.length(); i++) 
            {
                // Obtém as letras correspondentes para o digito atual
                int digit = number.charAt(i) - '0';
                letterSets[i] = DIGIT_TO_LETTERS[digit];
            }
            
            // Cria um array de indices para gerar as combinacoes
            int[] indices = new int[letterSets.length];
            
            while (true) 
            {
                String word = "";
                // Gera a combinacao atual
                for (int i = 0; i < letterSets.length; i++) 
                    word += letterSets[i].charAt(indices[i]);
                // Escreve a combinacao no arquivo
                combinations.format("%s%n", word);
                
                // Encontra a posicao para incrementar
                int pos = letterSets.length - 1;
                
                while (pos >= 0 && indices[pos] == letterSets[pos].length() - 1) 
                {
                    indices[pos] = 0;  // Reseta o indice atual
                    pos--;
                }
                
                // Se todos os indices foram ajustados, sai do loop
                if (pos < 0) 
                    break;
                
                // Incrementa o indice da posicao atual
                indices[pos]++;
            }
            // Fecha o Formatter e confirma a criacao do arquivo
            combinations.close();
            System.out.println("Arquivo combinations criado com sucesso");
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            // Exibe mensagem de erro caso o arquivo nao possa ser criado
            System.err.println("Erro ao criar o arquivo combinations.");
            System.exit(1);
        } 
    }
}
