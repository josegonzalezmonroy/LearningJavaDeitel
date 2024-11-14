// 6.29 - Cara ou coroa
// Escreva um aplicativo que simula o lançamento de uma moeda. Deixe o programa lançar uma moeda toda vez que o usuário escolher a opção 'Toss Coin' no menu. Conte o número de vezes que cada lado da moeda aparece. Exiba os resultados. O programa deve chamar um método separado flip que não aceita nenhum argumento e retorna false para coroa e true para cara. [Nota: Se o programa simular o arremesso de moeda de maneira realista, cada lado da moeda da moeda deve aparecer aproximadamente metade das vezes.]
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_29 
{
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        int opcao = 1;
        int cara = 0;
        int coroa = 0;

        while (opcao != 0) 
        {
            System.out.println("Digite 1 para jogar a moeda ou 0 para salir");// dependendo da resposta, lança a moeda ou fecha o programa
            opcao = input.nextInt();
            
            if (opcao == 0)// para evitar que flip() seja executado caso a resposta seja 0
                break;

            switch (flip())// gera o numero random
            {
                case 0:
                    cara++;
                    break;
            
                case 1:
                    coroa++;
                    break;
            }
        }

        if (cara + coroa == 0)// se não executar o programa pelo menos uma vez
            System.out.println("Ok cancelado");
        else
        {
            System.out.println(Coin.CARA + ": " + cara);
            System.out.println(Coin.COROA + ": " + coroa);
        }
    }

    public static int flip()// gera um numero random
    {
        return randomNumbers.nextInt(2);// o numero é entre 0 e 1
    }
    
    public enum Coin
    {
        CARA, COROA; // constantes
    }

}   

