// 6.39 - Instrução auxiliada por computador: variando os tipos de problema
// Modifique o programa para permitir que o usuário selecione os tipos de problemas aritméticos que ele deseja estudar. Uma opção de 1 significa apenas problemas de adição, 2 significa apenas problemas de subtração, 3 significa apenas problemas de multiplicação, 4 significa apenas problemas de divisão, e 5 significa uma combinação aleatória de problemas de todos esses tipos.
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_39 
{
    public static SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int number1;// primeiro número aleatório
        int number2;// segundo número aleatório
        int correta = 0;
        int incorreta = 0;

        System.out.println("Digite o tipo de problema aritmetico a ser estudado: \n1 - Adicao\n2 - Subtracao\n3 - Multiplicacao\n4 - Divisao\n5 - Aleatorio");
        int operacao = input.nextInt();// tipo de operacao

        System.out.println("Agora o nivel de dificultade das operacoes: \n1 - Um digito\n2 - Dois digitos\n3 - Tres digitos\n4 - Quatro digitos\n5 - Aleatorio");
        int dificuldade = input.nextInt(); // nivel de dificuldade

        for (int counter = 0; counter < 10; counter++)
        {
            int operacaoNova = opcaoAleatoria(operacao);// a cada ciclo calcula um novo tipo de operacao se precisar
            int dificuldadeNova = opcaoAleatoria(dificuldade);// a cada ciclo calcula um novo tipo de dificuldade se precisar

            System.out.printf("Quanto e %d %s %d ?%n", number1 = number(dificuldadeNova), tipoDeOperacao(operacaoNova), number2 = number(dificuldadeNova));// pergunta
            int resposta = input.nextInt();// resposta inserida pelo usuário

            if (resposta(operacaoNova, resposta, number1, number2)) 
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

    public static int opcaoAleatoria(int x)
    {
        int tipoDeOpcao = 0;
        if (x == 5)
            tipoDeOpcao = 1 + randomNumber.nextInt(4);
        else 
            tipoDeOpcao = x;

        return tipoDeOpcao;
    }

    public static String tipoDeOperacao(int x)
    {
        String operacao = "";
        switch (x) 
        {
            case 1:
                operacao = "+";
                break;
            case 2:
                operacao = "-";
                break;            
            case 3:
                operacao = "*";
                break;            
            case 4:
                operacao = "/";
                break;
        }
        return operacao;
    }

    public static boolean resposta(int d, int c, int a, int b)// confirma se a resposta é verdadeira
    {
        int operacao = 0;

        switch (d) 
        {
            case 1:
                operacao = a + b;
                break;
            case 2:
                operacao = a - b;
                break;            
            case 3:
                operacao = a * b;
                break;            
            case 4:
                operacao = a / b;
                break;
        }
        return c == operacao;
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