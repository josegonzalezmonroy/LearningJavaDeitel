// 6.31 - Adivinhe o número modificado 
// Modifique o programa do Exercício 6.30 para contar o número de suposições que o jogador faz. Se o número for 10 ou menos, exiba 'Either you know the secret or you got lucky' [Você sabe o segredo ou tem muita sorte!] se o jogador adivinhar o número em 10 tentativas, exiba 'Aha, you know the secret!' [Aha, você sabe o segredo!]. Se o jogador fizer mais que 10 adivinhações, exiba 'You should be able do to better!' [Você é capaz de fazer melhor!]. Por que esse jogo não deve precisar mais que 10 suposições? Bem, a cada 'boa suposição' o jogador deve ser capaz de eliminar metade dos números. Agora mostre por que qualquer número 1 a 1.000 pode ser advinhado em 10 ou menos tentativas.
import java.security.SecureRandom;
import java.util.Scanner;
public class Exerc_6_31 
{
    private static final SecureRandom randomNumbers = new SecureRandom();
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int x = 1 + randomNumbers.nextInt(1000); // gera um numero aleatorio entre 1 e 1000
        int palpite = 0; // variavel inicializada
        int palpites = 0; // acumulador de palpites

        while (palpite != x)// enquanto o palpite seja diferente ao numero
        {
            System.out.println("Digite seu palpite entre 1 e 1000");
            palpite = input.nextInt();
            palpites++;
            
            if (palpite == x)// se acertar o numero
            {
                System.out.println("Parabens, voce adivinhou o numero");
                if (x <= 10)// se o palpite for menor a 10
                    System.out.println("Voce sabe o segredo ou tem muita sorte");
                else if (x > 10 && palpites <= 10)// se a quantidade de palpites for menor a 10 e o numero a encontar for maior a 10, voce sabe o segredo
                    System.out.println("Aha! Voce sabe o segredo!");
                if (palpites > 10)
                    System.out.println("Voce deve ser capaz de fazer melhor");
            }
                else if (palpite > x)// se o palpite for maior do que o numero
                System.out.println("Muito alto, tente novamente");
            else// se o palpite for menor do que o numero
                System.out.println("Muito baixo, tente novamente");
        }
    }    
}
