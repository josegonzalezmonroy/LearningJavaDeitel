// 7.25 - Oito rainhas: abordagem de força bruta
// Nesse exercício você desenvolverá várias abordagens da força bruta para resolver o problema das oito rainhas introduzido no exercício 7.24. a) Utilize a técnica da força bruta aleatória desenvolvida no exercício 7.23 para resolver o problema das oito rainhas. b) Utilize uma técnica exaustiva (isto é, tentar todas as combinações possíveis de oito rainhas no tabuleiro) para resolver esse problema. c) Por que a abordagem da força bruta exaustiva poderia não ser apropriada para resolver o problema do passeio do cavalo? d) Compare e contraste as abordagens de força bruta aleatória e da força bruta aleatória.

import java.security.SecureRandom;
import java.util.Arrays;

public class Exerc_7_25 
{
    public static void main(String[] args) 
    {
        int resolvidos = 0;// contador de resolvidos
        int[][] completos = new int[95][8];// array que armazena cada problema resolvido, teoricamente so existem 92 solucoes diferentes possiveis

        while (resolvidos < 92)// enquanto nao se resolvam 92 vezes
        {
            int[][] board = new int[8][8];// cria um novo tabuleiro para cada oportunidade
            zerarTabuleiro(board);// inicializa cada posicao do tabuleiro com o numero 9

            while (disponivel(board))// se ainda tiver movimentos disponiveis, isto é, se o tabuleiro ainda tem espaço para colocar outra rainha
            {
                int currentRow = movimentoAleatorio();// posicao aleatoria da linha
                int currentColumn = movimentoAleatorio();// posicao aleatoria da coluna

                if (movimentoValido(board, currentRow, currentColumn))
                {// se for um movimento valido
                    board[currentRow][currentColumn] = 1;// posiciona a rainha
                    accesibilidadeReduzida(board, currentRow, currentColumn);// atualiza o tabuleiro com as novas posicoes disponiveis
                }
            }

            int rainhas = quantidadeRainhas(board);// determina a quantidade de rainhas tem o tabuleiro

            if (rainhas == 8)// se completar o tabuleiro
            {   
                int[] oitoRainhas = new int[8];// cria um array para guardar as posicoes exatas das rainhas
                movimentos(board, oitoRainhas);// pega as posicoes do tabuleiro e as armazena no array oitoRainhas

                boolean igual = false;//inicializa a variavel igual com o valor false

                for (int linha = 0; linha < completos.length; linha++)
                {//bucle para passar pelo array completos para saber se ja existe a solucao atual
                    if (Arrays.equals(oitoRainhas, completos[linha]))
                    {//se a solucao for igual a qualquer solucao que ja existe no array completos
                        igual = true;// o valor muda para true 
                        break;// e se fecha o buble, nao precisa buscar mais
                    }
                } 

                if (!igual)// se a solucao for diferente as solucoes armacenadas no array completos
                {
                    completos[resolvidos++] = oitoRainhas;// se adiciona a solucao no array completos
                    System.out.printf("%d%n", resolvidos);    
                    imprimeTabuleiro(board);
                }
            }
        }
        System.out.printf("Total resolvidos: %d%n", resolvidos);  
            
    }

    public static void movimentos(int[][] board, int[] oitoRainhas)
    {
        for (int linha = 0; linha < board.length; linha++)
            for (int coluna = 0; coluna < board[linha].length; coluna++)
                if (board[linha][coluna] == 1)
                {
                    oitoRainhas[linha] = coluna;
                }        
    }

    public static boolean disponivel(int[][] board)
    {
        int disponiveis = 0;
        for (int j = 0; j < board.length; j++)
            for (int k = 0; k < board[j].length; k++)
                if (board[j][k] == 9)
                    disponiveis++;    
             
        if (disponiveis > 0)
            return true;
        else
            return false;

    }

    public static void zerarTabuleiro(int[][] board)
    {
        for (int j = 0; j < board.length; j++)
            for (int k = 0; k < board[j].length; k++)
                board[j][k] = 9;
    }

    public static int movimentoAleatorio()// gera um numero aleatorio entre 0 e 7
    {
        SecureRandom randomNumbers = new SecureRandom();
        
        return randomNumbers.nextInt(8);
    }

    public static int quantidadeRainhas(int[][] board)
    {
        int rainhas = 0;

        for (int lin = 0; lin < board.length; lin++)
            for (int col = 0; col < board[lin].length; col++)
                if (board[lin][col] == 1)
                    rainhas++;
        
        return rainhas;
    }

    public static boolean movimentoValido(int[][] board, int currentRow, int currentColumn)
    {
        if (board[currentRow][currentColumn] != 9)
            return false;
        return true;
    }
    
    public static void accesibilidadeReduzida(int[][] board, int currentRow, int currentColumn)
    {
        // marca a coluna
        for (int coluna = 0; coluna < board.length; coluna++)
        {
            if (board[currentRow][coluna] == 1)
                continue;     
            board[currentRow][coluna] = 0;
        }

        // marca a linha
        for (int linha = 0; linha < board.length; linha++)
        {
            if (board[linha][currentColumn] == 1)
                continue;  
            board[linha][currentColumn] = 0;
        }

        int linea = currentRow;
        int columna = currentColumn;

        // superior esquerda
        while (linea > 0 && columna > 0)
            board[--linea][--columna] = 0;

        linea = currentRow;
        columna = currentColumn;
        
        // inferior direita
        while (linea < board.length - 1 && columna < board.length - 1)
            board[++linea][++columna] = 0;

        linea = currentRow;
        columna = currentColumn;
        
        // superior direita
        while (linea <= board.length - 1 && columna < board.length - 1 && linea > 0 && columna >= 0)
            board[--linea][++columna] = 0;

        linea = currentRow;
        columna = currentColumn;
        
        // inferior esquerda
        while (linea < board.length - 1 && columna <= board.length - 1 && linea >= 0 && columna > 0)
            board[++linea][--columna] = 0;
    }

    public static void imprimeTabuleiro(int[][] board)// imprime o tabuleiro 
    {
        System.out.print("    ");

        for (int coluna = 0; coluna < board.length; coluna++) 
            System.out.printf("%2d ", coluna);
            
        System.out.println("\n");

        for (int linha = 0; linha < board.length; linha++) 
        {
            System.out.print(linha + "   ");

            for (int coluna : board[linha])
                System.out.printf("%2d ", coluna);

            System.out.println();
        }
        System.out.println();
    }

}
