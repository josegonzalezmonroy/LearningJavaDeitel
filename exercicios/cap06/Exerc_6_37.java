// 6.36 - Instrução auxiliada por computador: monitorando o desempenho do aluno
// Sistemas mais sofisticados de instruções auxiliadas por computador monitoram o desempenho do estudante durante um período de tempo. A decisão sobre um novo tópico freqüentemente é baseada no sucesso do estudante com tópicos prévios. Modifique o programa do Exercício 6.36 para contar o número de respostas corretas e incorretas digitadas pelo estudante. Depois que o aluno digitar 10 respostas, seu programa deve calcular a porcentagem de respostas corretas.
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_37 
{
    public static SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int number1;// primeiro número aleatório
        int number2;// segundo número aleatório
        int correta = 0;
        int incorreta = 0;

        for (int counter = 0; counter < 10; counter++)
        {
            System.out.printf("Quanto e %d vezes %d ?%n", number1 = number(), number2 = number());// pergunta
            int resposta = input.nextInt();// resposta inserida pelo usuário

            if (resposta(resposta, number1, number2)) 
            {   
                System.out.println(mensagem(true) + "\n");// se for certa imprime a mensagem
                correta++;
            }
            else 
            {
                System.out.println(mensagem(false) + "\n");// se for incorreta    
                incorreta++; 
            }
        }

        if (100 - correta * 10 > 75)// se for mais de 75% incorretas
            System.out.println("Peca ajuda extra ao seu professor\n");
        else if (correta * 10 >= 75)// se for 75% corretas ou mais
            System.out.println("Parabens, voce esta pronto para avancar para o proximo nivel!\n"); 
        
        System.out.println("Corretas: " + correta);
        System.out.println("Incorretas: " + incorreta);
    }

    public static String mensagem(boolean x)// mensagem aleatória dependendo da resposta
    {
        int value;
        String resposta = "";

        if (x)
            value = 1 + randomNumber.nextInt(4);// value para respostas corretas
        else
            value = 5 + randomNumber.nextInt(4);// value para respostas incorretas

        switch (value) // 1 - 4 caso a resposta seja correta
        {              // 5 - 8 caso a resposta seja correta
            case 1:
                resposta = "Muito bom!";   
                break;
            case 2:
                resposta = "Excelente!";
                break;     
            case 3:
                resposta = "Bom trabalho!";        
                break;
            case 4:
                resposta = "Mantenha um bom trabalho!";
                break;
            case 5:
                resposta = "Nao. Por favor, tente de novo.";   
                break;
            case 6:
                resposta = "Errado. Tente mais uma vez.";
                break;     
            case 7:
                resposta = "Nao desista!";        
                break;
            case 8:
                resposta = "Nao. Continue tentando.";
                break;
        }
        return resposta;
    }

    public static boolean resposta(int c, int a, int b)// confirma se a resposta é verdadeira
    {
        return c == a * b;
    }

    public static int number()// gera os números aleatórios
    {
        return 1 + randomNumber.nextInt(9);
    }
}
