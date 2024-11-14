// 8.17 - Jogo da velha 
// Crie uma classe TicTacToe que permitira escrever um programa para reproduzir o jogo da velha. A classe contem um array bidimensional privado 3 por 3. Use um tipo enum para representar o valor em cada celula do array. As constantes enum devem ser nomeadas X, O e EMPTY (para uma posicao que nao contem X ou 0). O construtor deve inicializar os elementos do tabuleiro para EMPTY. Permita dois jogadores humanos. Para onde quer que o primeiro jogador se mova, coloque um X no quadrado especificado; coloque um O no local para o qual o segundo jogador se mover. Todo movimento deve ocorrer em um quadrado vazio. Depois de cada jogada, determine se o jogo foi ganho e se aconteceu um empate. Se voce se sentir motivado, modifique seu programa de modo que o computador faca o movimento para um dos jogadores. Alem disso, permita que o jogador especifique se quer ser o primeiro ou o segundo. Se voce se sentir excepcionalmente motivado, desenvolva um programa que jogue o Tic-Tac-Toe tridimensional em uma grade 4 por 4 por 4. [Observacao: isso e um projeto extremamente desafiador!]

import java.util.Scanner;

public class Exerc_8_17 
{
    public static void main(String[] args) 
    {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria uma nova instância do jogo da velha
        TicTacToe game = new TicTacToe();
    
        // Variável para controlar o fim do jogo
        boolean gameOver = false;
    
        // Define o jogador atual como 'X' para comecar
        TicTacToe.Cell currentPlayer = TicTacToe.Cell.X;
    
        // Exibe uma mensagem de boas-vindas ao jogo
        System.out.println("Bem-vindo ao Jogo da Velha!");
    
        // Exibe o estado atual do tabuleiro
        game.printBoard();
    
        // Loop principal do jogo que continua até que o jogo termine
        while (!gameOver) 
        {
            // Solicita ao jogador atual para fazer uma jogada
            System.out.println("Jogador " + currentPlayer + ", faca sua jogada (linha e coluna): ");
            int row = scanner.nextInt() - 1; // Lê a linha escolhida pelo jogador
            int col = scanner.nextInt() - 1; // Lê a coluna escolhida pelo jogador
    
            // Verifica se a jogada está dentro dos limites do tabuleiro
            if (row < 0 || row >= 3 || col < 0 || col >= 3) 
            {
                System.out.println("Posicao fora dos limites. Tente novamente.");
                continue; // Pede ao jogador para tentar novamente
            }
    
            try 
            {
                // Tenta definir a célula no tabuleiro com o valor do jogador atual
                game.setCell(row, col, currentPlayer);
    
                // Exibe o estado atual do tabuleiro após a jogada
                game.printBoard();
    
                // Verifica se o jogador atual venceu
                if (game.checkWin(currentPlayer)) 
                {
                    System.out.println("Jogador " + currentPlayer + " ganhou!");
                    gameOver = true; // Encerra o jogo se o jogador ganhou
                } 
                // Verifica se o jogo empatou
                else if (game.checkTie()) 
                {
                    System.out.println("O jogo empatou!");
                    gameOver = true; // Encerra o jogo se houver um empate
                } 
                else 
                    // Alterna para o próximo jogador
                    currentPlayer = (currentPlayer == TicTacToe.Cell.X) ? TicTacToe.Cell.O : TicTacToe.Cell.X;
            } 
            catch (IllegalArgumentException e) 
            {
                // Exibe a mensagem de erro caso a jogada seja inválida
                System.out.println(e.getMessage());
            }
        }
    }
}

class TicTacToe 
{
    // Enum para representar o valor em cada célula
    public enum Cell 
    {
        X, O, EMPTY
    }

    // Tabuleiro 3x3
    private Cell[][] board;

    // Construtor
    public TicTacToe() 
    {
        // Inicializa o tabuleiro 3x3
        board = new Cell[3][3];
        // Preenche o tabuleiro com EMPTY
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = Cell.EMPTY;
    }

    // Método para exibir o tabuleiro
    public void printBoard() 
    {
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length; j++) 
                System.out.print(getSymbol(board[i][j]) + " ");

            System.out.println();
        }
    }

    // Método para converter Cell para símbolo
    private String getSymbol(Cell cell) 
    {
        switch (cell) 
        {
            case X:
                return "X";
            case O:
                return "O";
            case EMPTY:
                return ".";
            default:// necesario para que o metodo compile
                return " ";
        }
    }

    // Método para definir o valor de uma célula
    public void setCell(int row, int col, Cell value) 
    {
        if (board[row][col] == Cell.EMPTY) 
            board[row][col] = value;
        else 
            throw new IllegalArgumentException("Posicao ja ocupada. Escolha outra posicao.");
    }

    // Método para verificar se o jogo foi ganho
    public boolean checkWin(Cell player) 
    {
        // Verifica linhas e colunas
        for (int i = 0; i < board.length; i++) 
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) 
                return true;

        // Verifica diagonais
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) 
            return true;

        return false;
    }

    // Método para verificar se o jogo empatou
    public boolean checkTie() 
    {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) 
                if (board[i][j] == Cell.EMPTY) 
                    return false;
                    
        return true;
    }
}
