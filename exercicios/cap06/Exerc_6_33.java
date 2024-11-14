// Exercicio 6.33 - Modificação do jogo craps 
// Modifique o programa de jogo de dados da figura 6.9 para permitir apostas. Inicialize a variável bankBalance com $ 1.000. Peça ao jogador para inserir um wager (uma aposta). Verifique se o wager é menor ou igual a bankBalance e, se não o for, faça o usuário reinserir o wager até um wager válido inserido. Depois que um wager correto foi inserido, execute um jogo de dados. Se o jogador ganhar, aumente o bankBalance por wager e exiba o novo bankBalance. Se o jogador perder, diminua o bankBalance por wager, exiba o novo bank balance, verifique se bankBalance tornou-se zero e, se tiver ocorrido, exiba a mensagem "Sorry. You busted." ["Desculpe, mas você faliu."]. Enquanto o jogo se desenvolve, exiba várias mensagens para criar uma 'conversa', como "Oh, you're going for broke, huh?" ["Oh, parece que você vai quebrar, hein?"] ou "Aw, c'mon, take a chance" ["Ah, vamos lá, dê uma chance para sua sorte!"] ou "You're up big. No's the time to cash in your chips!" [Você está montado na grana. Agora é hora de trocar essas fichas e embolsar o dinheiro!"]. Implemente a 'conversa' como um método separado que escolhe aleatóriamente a string a exibir.

import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_6_33

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
        Scanner input = new Scanner(System.in);
        double bankBalance = 1000;// saldo inicial
        double sentinela = 1;

        System.out.println("Saldo: " + bankBalance);// exibe o saldo inicial
        while (sentinela != 0) 
        {
            if (bankBalance == 0)// se acabar o saldo, fecha o programa
                break;
            
            System.out.println("Insira sua aposta (0 para sair): ");
            double wager = input.nextDouble();// digita o valor da aposta

            while (wager > bankBalance)
            {
                System.out.printf("Saldo insuficiente, insira um valor nao maior a %.2f (0 para sair)%n", bankBalance);
                wager = input.nextDouble();// valor corrigido
            }

            if (wager == 0)// cancela o jogo
            {
                sentinela = 0;
                break;
            }

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
                    System.out.printf("O ponto e %d%n", myPoint);
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
            {
                bankBalance += wager;// aumenta o dinheiro
                System.out.println("\nVoce GANHOU :D");
            } 
            else
            {
                bankBalance -= wager;// diminui do saldo o valor da aposta
                System.out.println("\nVoce PERDEU :(");
            }
            if (bankBalance == 0)
                System.out.println("Desculpe, mas voce faliu!");// exibe o novo saldo
                
            
            if (bankBalance > 0) // se nao falir, insira a conversa
                System.out.println("\n" + conversa() + "\n");    
            
            System.out.println("Saldo: " + bankBalance);// exibe o novo saldo

        }
    }

    public static String conversa()// retorna uma mensagem aleatória
    {
        int value = randomNumbers.nextInt(3);// valor aleatorio

        String mensagem = ""; // variavel inicializada
        switch (value) 
        {
            case 0:
                mensagem = "Oh, parece que voce vai quebrar, hein?"; 
                break;
            case 1:
                mensagem = "Ah, vamos la, de uma chance para sua sorte";
                break;
            case 2:
                mensagem = "Voce esta montado na grana, agora e hora de trocar essas fichas e embolsar o dinheiro";
                break;
        }

        return mensagem;// mensagem retornada
    }

    // lança os dados, calcula a soma e exibe os resultados 
    public static int rollDice()
    {
        // seleciona valores aleatórios do dado
        int die1 = 1 + randomNumbers.nextInt(6); // primeiro lançamento do dado
        int die2 = 1 + randomNumbers.nextInt(6); // segundo lançamento do dado

        int sum = die1 + die2; // soma os valores dos dados

        // exibe os resultados desse lançamento
        System.out.printf("Jogador lancou %d + %d = %d%n", 
            die1, die2, sum);

        return sum;
    }
} // fim da classe Craps
