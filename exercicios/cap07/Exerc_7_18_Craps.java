import java.security.SecureRandom;

public class Exerc_7_18_Craps 
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

static int rolagem;// acumulador de rolagens

// joga uma partida de craps 
public boolean play()
{
    int myPoint = 0; // pontos se não ganhar ou perdera na primeira rolagem
    Status gameStatus; // pode conter CONTINUE, WON ou LOST

    int sumOfDice = rollDice(); // primeira rolagem dos dados

    boolean resultado = false; // valor que retorna o metodo play

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
        resultado = true;
        
        return resultado;
}

// lança os dados, calcula a soma e exibe os resultados 
public static int rollDice()
{
    rolagem++;// adiciona 1 na varivel para cada rolagem

    // seleciona valores aleatórios do dado
    int die1 = 1 + randomNumbers.nextInt(6); // primeiro lançamento do dado
    int die2 = 1 + randomNumbers.nextInt(6); // segundo lançamento do dado
    int sum = die1 + die2; // soma os valores dos dados

    return sum;
}
} // fim da classe Craps
