
// 6.35 - Instrução assistida por computador
// Os computadores estão desenpenhando um crescente papel na educação. Ecreva um programa que ajudará um estudante do ensino fundamental a aprender multiplicação. Utilize o método Random para produzir dois inteiros positivos de um algarismo. O programa então deve fazer ao usuário uma pergunta, como: How much is 6 times 7? O aluno insere então a resposta. Em seguida, o programa verifica a resposta do aluno, se estiver correta, exiba a mensagem "Very good!" e faça outra pergunta de multiplicação, se a resposta estiver errada, exiba a mensagem "No. Please try again!" e deixe que o estudante tente a mesma pergunta repetidamente até por fim responder corretamente. Um método separado deve ser utilizado para gerar cada nova pergunta. Esse método deve ser chamado uma vez quando a aplicação inicia a execução e toda vez quando o usuário responde corretamente.
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_35 {
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
                System.out.println("Nao por favor, tente de novo\n");
                resposta = input.nextInt();
            }
            System.out.println("Muito bem!\n");// se for certa imprime a mensagem
        }
    }

    public static boolean resposta(int c, int a, int b)// confirma se a resposta é verdadeira
    {
        return c == a * b;
    }

    public static int number()// gera os números aleatórios
    {
        SecureRandom randomNumber = new SecureRandom();

        return 1 + randomNumber.nextInt(9);
    }
}
