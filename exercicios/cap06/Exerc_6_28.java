// 6.28 - Escreva um método qualityPoints que insere a média de um aluno e retorna 4 se a média estiver entre 90 e 100, 3 se a média estiver entre 80 e 89, 2 se a média estiver entre 70 e 79, 1 se se a média estiver entre 60 e 69, e 0 se a média for mais baixa que 60. Incorpore o método a um aplicativo que lê um valor do usuário e exibe o resultado.
import java.util.Scanner;

public class Exerc_6_28 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a media do aluno: ");
        double media = input.nextDouble();

        System.out.println(qualityPoints(media));
    }
    
    public static int qualityPoints(double media)// retorna un valor inteiro
    {
        int result = 0;

        if (media >= 90 && media <= 100)
            result = 4;
        else if (media >= 80 && media < 90) 
            result = 3;
        else if (media >= 70 && media < 80)
            result = 2;
        else if (media >= 60 && media < 70)
            result = 1;
        else 
            result = 0;
        
        return result;
    }
}
