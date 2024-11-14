// 6.38 - Instrução auxiliada por computador: niveis de dificuldade
// As questões 6.35 a 6.37 desenvolveram um programa de instrução auxiliada por computador para ensinar multiplicação a um estudante do ensino fundamental. Realize os seguintes aprimoramentos: a) Modifique o programa para permitir que o usuário insira uma capacidade de nível de dificuldade. Um nível de dificuldade de 1 significa que o programa deve utilizar somente números de um dígito nos problemas, um nível de dificuldade de 2 significa que o programa deve utilizar número de dois dígitos, e assim por diante.
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_38 
{
    public static SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int number1;// primeiro número aleatório
        int number2;// segundo número aleatório
        int dificuldade;
        int correta = 0;
        int incorreta = 0;

        System.out.println("Digite o nivel de dificultade da operacao: \n1 - Um digito\n2 - Dois digitos\n3 - Tres digitos\n4 - Quatro digitos");
        dificuldade = input.nextInt();

        for (int counter = 0; counter < 10; counter++)
        {
            System.out.printf("Quanto e %d vezes %d ?%n", number1 = number(dificuldade), number2 = number(dificuldade));// pergunta
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

    public static int number(int x)// gera os números aleatórios
    {
        int limite = 0;
        switch (x) // x representa a quantidade de digitos da operacao
        {
            case 1:
                limite = 9;// ate um digito
                break;
            case 2:
                limite = 99;// ate dois digitos
                break;
            case 3:
                limite = 999;// ate tres digitos
                break;            
            case 4:
                limite = 9999;// ate quatro digitos
                break;
        }
        return 1 + randomNumber.nextInt(limite);
    }
}
