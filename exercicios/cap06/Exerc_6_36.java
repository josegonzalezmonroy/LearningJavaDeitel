// 6.36 - Instrução auxiliada por computador: reduzindo a fadiga do aluno
// O uso de computadores na educação é referido como instrução auxiliada por computador (CAI - Computer-Assisted Instruction). Um  que se desenvolve em ambientes CAI é a fadiga do estudante. Esse problema pode ser eliminado variando as respostas do computador para prender a atenção do estudante. Modifique o programa da questão 6.35 de modo que os vários comentários sejam exibidos para cada resposta correta e cada resposta incorreta, como segue: Respostas para uma resposta correta: [Muito bom!], [Excelente!], [Bom Trabalho!], [Continue o bom trabalho!]. Respostas para uma resposta incorreta: [Não. Tente novamente.], [Errado. Tente mais uma vez.], [Não desista!], [Não. Continue tentando.]. Utilize geração de números aleatórios para escolher um número entre 1 e 4 que será utilizando para selecionar uma resposta apropriada para cada resposta. Utilize uma instrução switch para emitir as respostas.
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_36 
{
    public static SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number1;// primeiro número aleatório
        int number2;// segundo número aleatório
        int resposta = 1;

        while (resposta != 0) 
        {
            System.out.printf("Quanto e %d vezes %d ?%n(0 para sair)%n", number1 = number(), number2 = number());// pergunta
            resposta = input.nextInt();// resposta inserida pelo usuário
            if (resposta == 0)
                break;

            while (!resposta(resposta, number1, number2))// enquanto a resposta seja falsa
            {
                System.out.println(mensagem(false) + "\n");
                resposta = input.nextInt();
            }
            System.out.println(mensagem(true) + "\n");// se for certa imprime a mensagem
        }
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