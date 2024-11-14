// Figura 6.8 - Craps.java
// A classe Craps simula o jogo de dados craps
import java.security.SecureRandom;

public class Fig_6_8 
{
    // cria um gerador seguro de numeros aleatórios para uso no método rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    // tipo enum com constantes que representam o estado do jogo
    private enum Status { CONTINUE, WON, LOST };

    // constantes que representam lançamentos comuns dos dados
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    // joga uma partida de craps 
    public static void main(String[] args) 
    {
        int myPoint = 0; // pontos se não ganhar ou perdera na primeira rolagem
        Status gameStatus; // pode conter CONTINUE, WON ou LOST

        int sumOfDice = rollDice(); // primeira rolagem dos dados

        // determina o estado do jogo e a pontuação com base no primeiro lançamento
        switch (sumOfDice) 
        {
            case SEVEN: // ganha com 7 no primeiro lançamento
            case YO_LEVEN: // ganha com 11 no primeiro lançamento
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: // perde com 2 no primeiro lançamento
            case TREY: // perde com 3 no primeiro lançamento
            case BOX_CARS: // perde com 12 no primeiro lançamento
                gameStatus = Status.LOST;
                break;
            default: // não ganhou nem perdeu, portanto registra a puntuação
                gameStatus = Status.CONTINUE; // jogo não terminou
                myPoint = sumOfDice; // informa a puntuação
                System.out.printf("Point is %d%n", myPoint);
                break;
        }

        // enquanto o jogo não estiver completo
        while (gameStatus == Status.CONTINUE) // nem WON nem LOST
        {
            sumOfDice = rollDice(); // lança os dados novamente

            // determina o estado do jogo
            if (sumOfDice == myPoint) // vitória por puntuação 
                gameStatus = Status.WON;
            else
                if (sumOfDice == SEVEN) // perde obtendo 7 antes de atingir a pontuação
                    gameStatus = Status.LOST;
        }

        // exibe uma mensagem ganhou ou perdeu 
        if (gameStatus == Status.WON) 
            System.out.println("Player wins");
        else
            System.out.println("Player loses");
    }

    // lança os dados, calcula a soma e exibe os resultados 
    public static int rollDice()
    {
        // seleciona valores aleatórios do dado
        int die1 = 1 + randomNumbers.nextInt(6); // primeiro lançamento do dado
        int die2 = 1 + randomNumbers.nextInt(6); // segundo lançamento do dado

        int sum = die1 + die2; // soma os valores dos dados

        // exibe os resultados desse lançamento
        System.out.printf("Player rolled %d + %d = %d%n", 
            die1, die2, sum);

        return sum;
    }
} // fim da classe Craps
