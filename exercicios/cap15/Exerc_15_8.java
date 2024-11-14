// 15.8 - Pesquisa entre alunos
// A Figura 7.8 contém um array de respostas a uma pesquisa que é codificado diretamente no programa. Suponha que queremos processar os resultados dessa pesquisa que são armazenados em um arquivo. Este exercício requer dois programas separados. Primeiro, crie um aplicativo que solicita ao usuário respostas à pesquisa e gera a saída de cada resposta para um arquivo. Utilize um Formatter para criar um arquivo chamado numbers.txt. Cada inteiro deve ser escrito com o método format. Então modifique o programa que aparece na Figura 7.8 para ler as respostas à pesquisa a partir de numbers.txt. As respostas devem ser lidas do arquivo utilizando um Scanner. Use o método nextInt para inserir um número inteiro de cada vez a partir do arquivo. O programa precisa continuar a ler respostas até alcançar o fim desse arquivo. A saída dos resultados deve ser gerada no arquivo de texto "output.txt".

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Exerc_15_8
{
    public static void main(String[] args) 
    {
        // Inicializa o array de frequencias para armazenar as respostas
        int[] frequency = new int[5];

        try
        {
            // Abre o arquivo "numbers.txt" para ler as respostas
            Scanner responses = new Scanner(new File("numbers.txt"));

            int answer = 0;
            int counter = 0;

            // Continua lendo as respostas enquanto houver entradas no arquivo
            while (responses.hasNext())
            {
                try 
                {
                    // Lê a proxima resposta e incrementa a frequencia correspondente
                    answer = responses.nextInt();
                    ++frequency[answer - 1];
                } 
                catch (ArrayIndexOutOfBoundsException e) 
                {
                    // Se houver um valor fora do intervalo, captura a excecao
                    System.out.println(e); 
                    System.out.printf("   responses[%d] = %d%n%n", 
                    counter, answer);
                }
                counter++;
            }
            // Fecha o scanner apos ler todas as respostas
            responses.close();
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            // Exibe mensagem de erro se o arquivo "numbers.txt" nao for encontrado
            System.err.println("Erro ao abrir o arquivo numbers.");
            System.exit(1);
        }

        try
        {
            // Cria o arquivo "output.txt" para gravar os resultados das frequencias
            Formatter output = new Formatter("output.txt");

            // Grava cada frequencia no arquivo "output.txt"
            for (int i : frequency)
                output.format("%d%n", i); 
            
            // Fecha o formatter apos gravar os dados
            output.close();
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            // Exibe mensagem de erro se o arquivo "output.txt" nao puder ser criado
            System.err.println("Erro ao abrir o arquivo output.");
            System.exit(1);
        }
    }    
}
