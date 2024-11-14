// 6.30 - Adivinhe o número
// Escreva um aplicativo que joga 'adivinhe o número' como aseguir: Seu programa escolhe o número a ser adivinhado selecionando um inteiro aleatório no intervalo de 1 a 1.000. O aplicativo exibe o prompt 'Guess a number between 1 and 1.000' [Adivinhe um número entre 1 e 1.000]. O jogador insere uma primeira suposição. Se o palpite do jogador estiver incorreto, seu programa deve exibir 'Too high. Try again.' [Muito alto. Tente novamente.] ou 'Too low. Try again.' [Muito baixo. Tente novamente.]. Para ajudar o jogador a 'zerar' mediante uma resposta correta, o programa solicitar ao usuário o próximo palpite. Quando o jogador inserir uma resposta correta, exiba 'Congratulations. You guessed the number!' [Parabéns. Você adivinhou o número!] e permita ao jogador escolher se que jogar novamente. [Nota:  A técnica de adivinhação empregada nesse problema é semelhante a uma pesquisa binária, discutida no Capítulo 19.]
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_30 
{
    private static final SecureRandom randomNumbers = new SecureRandom();
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int x = 1 + randomNumbers.nextInt(1000); // gera um numero aleatorio entre 1 e 1000

        int palpite = 0; // variavel inicializada
        
        while (palpite != x)// enquanto o palpite seja diferente ao numero
        {
            System.out.println("Digite seu palpite entre 1 e 1000");
            palpite = input.nextInt();

            if (palpite == x)// se acertar o numero
                System.out.println("Parabens, voce adivinhou o numero");
            else if (palpite > x)// se o palpite for maior do que o numero
                System.out.println("Muito alto, tente novamente");
            else// se o palpite for menor do que o numero
                System.out.println("Muito baixo, tente novamente");
        }
    }    
}
