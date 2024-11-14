// 7.24 - Oito rainhas
/* Outro problema difícil para fãs de xadrez é o problema das oito rainhas, que pede o seguinte: é possível colocar oito rainhas em um tabuleiro de xadrez vazio de modo que nenhuma rainha esteja 'atacando' qualquer outra (isto é, sem que duas rainhas estejam na mesma linha, na mesma coluna ou na mesma diagonal)? Utilize a consideração desenvolvida no Exercício 7.22 a fim de formular uma heurística para resolver o problema das oito rainhas. Execute seu aplicativo. (Dica: É possível atribuir um valor para cada quadrado do tabuleiro de xadrez para indicar quantos quadrados de um tabuleiro de xadrez vazio 'são elimindos' se uma rainha for colocada nesse quadrado. Cada um dos cantos receberia o valor 22, como demonstrado na Figura 7.31. Uma vez que esses 'números de eliminação' são colocados em todos os 64 quadrados, uma heurística apropriada poderia ser como segue: coloque a próxima rainha no quadrado com o menor número de eliminação. Por que essa estratégia é intuitivamente atraente ?

                  ---------------------------------
                  | * | * | * | * | * | * | * | * |
                  ---------------------------------
                  | * | * |   |   |   |   |   |   |
                  ---------------------------------
                  | * |   | * |   |   |   |   |   |
                  ---------------------------------
                  | * |   |   | * |   |   |   |   |
                  ---------------------------------
                  | * |   |   |   | * |   |   |   |
                  ---------------------------------
                  | * |   |   |   |   | * |   |   |
                  ---------------------------------
                  | * |   |   |   |   |   | * |   |
                  ---------------------------------
                  | * |   |   |   |   |   |   | * |
                  ---------------------------------
         Figura 7.31 Os 22 quadrados eliminados posicionando uma rainha no
                     canto esquerdo superior
 */
///////////////////////////////////////////////////////////////
/////////// SO CONSEGUI RESOLVER O PROBLEMA 4 VEZES ///////////
/////////// O PROBLEMA TEM 92 SOLUCOES POSSIVEIS //////////////
/////////// E O ALGORITMO AINDA PRECISA SER MELHORADO /////////
///////////////////////////////////////////////////////////////

public class Exerc_7_24 
{
    public static void main(String[] args) 
    {
        int tentativas = 0;
        int soluciones = 0;
        for (int j = 0; j < 8; j++)// percorre as linhas
        {
            for (int k = 0; k < 8; k++)// percorre as colunas
            {
                int[][] accessibilityFutura = new int[8][8];                
                
                int[][] board = new int[8][8];// tabuleiro
                int[][] accessibility = 
                {
                    {21, 21, 21, 21, 21, 21, 21, 21},
                    {21, 23, 23, 23, 23, 23, 23, 21},
                    {21, 23, 25, 25, 25, 25, 23, 21},
                    {21, 23, 25, 27, 27, 25, 23, 21},
                    {21, 23, 25, 27, 27, 25, 23, 21},
                    {21, 23, 25, 25, 25, 25, 23, 21},
                    {21, 23, 23, 23, 23, 23, 23, 21},
                    {21, 21, 21, 21, 21, 21, 21, 21} 
                }; // clasificacao dos cuadrados (acessibilidade heuristica)
            
                int currentRow = j;// posicao inicial da linha
                int currentColumn = k;// posicao inicial da coluna
            
                for (int jogadas = 0; jogadas < 8; jogadas++)
                {
                    board[currentRow][currentColumn] = 1;

                    accesibilidadeReduzida(accessibility, currentRow, currentColumn);

                    int movimentoMinimo = movimentoMinimo(accessibility);
                    int vezes = valorMinimoVezes(accessibility, movimentoMinimo);
                    
                    if (movimentoMinimo == Integer.MAX_VALUE) break;
                    
                    if (vezes > 1)
                    {
                        accessibilityFutura = new int[8][8];
                        
                        for (int lin = 0; lin < accessibility.length; lin++)
                            for (int col = 0; col < accessibility[lin].length; col++)
                                if (accessibility[lin][col] == movimentoMinimo)
                                    accessibilityFutura[lin][col] = accesibilidadeReduzidaFutura(accessibility, lin, col);

                        int movimentoMinimoFuturo = movimentoMinimo(accessibilityFutura);
                        
                        for (int lin = 0; lin < accessibilityFutura.length; lin++)
                            for (int col = 0; col < accessibility[lin].length; col++)
                                if (accessibilityFutura[lin][col] == movimentoMinimoFuturo)
                                {
                                    currentRow = lin;
                                    currentColumn = col;
                                    lin = accessibility.length - 1;
                                }
                    }
                    else
                    {
                        for (int lin = 0; lin < accessibility.length; lin++)
                            for (int col = 0; col < accessibility[lin].length; col++)
                                if (accessibility[lin][col] == movimentoMinimo)
                                {
                                    currentRow = lin;
                                    currentColumn = col;
                                }
                    }
                }
                if (resolvido(board))
                {
                    soluciones++;
                    imprimeTabuleiro(board);
                    System.out.printf("Tentativa %02d%n", tentativas);
                }
                tentativas++;
            }
        }
    System.out.printf("Resolvidos: %02d%n", soluciones);    
}

    public static boolean resolvido(int[][] board)
    {
        int rainhas = 0;

        for (int lin = 0; lin < board.length; lin++)
            for (int col = 0; col < board[lin].length; col++)
                if (board[lin][col] == 1)
                    rainhas++;
        
        if (rainhas == 8)
            return true;
        else
            return false;
    }

    public static int valorMinimoVezes(int[][] accessibility, int valorMinimo)// mostrar a quantidade de vezes que aparece o valor minimo
    {
        int vezes = 0;

        for (int lin = 0; lin < accessibility.length; lin++)
            for (int col = 0; col < accessibility[lin].length; col++)
                if (accessibility[lin][col] == valorMinimo)
                    vezes++;

        return vezes;
    }

    public static int movimentoMinimo(int[][] accessibility)
    {
        int movMin = Integer.MAX_VALUE;

        for (int lin = 0; lin < accessibility.length; lin++)
            for (int col = 0; col < accessibility[lin].length; col++)
                if (accessibility[lin][col] < movMin)
                    if (accessibility[lin][col] != 0)
                        movMin = accessibility[lin][col];

        return movMin;
    }

    public static int accesibilidadeReduzidaFutura(int[][] accessibility, int linhaAtual, int colunaAtual)
    {
        int total = 0;

        // marca a coluna
        for (int coluna = 0; coluna < accessibility.length; coluna++)
            if (coluna != colunaAtual && accessibility[linhaAtual][coluna] != 0)
                total++;

        // marca a linha
        for (int linha = 0; linha < accessibility.length; linha++)
            if (linha != linhaAtual && accessibility[linha][colunaAtual] != 0)
                total++;

        int linea = linhaAtual;
        int columna = colunaAtual;

        // superior esquerda
        while (linea > 0 && columna > 0)
        {
            linea--;
            columna--;

            if (accessibility[linea][columna] != 0)
                total++;
        }
        linea = linhaAtual;
        columna = colunaAtual;
        
        // inferior direita
        while (linea < accessibility.length - 1 && columna < accessibility.length - 1)
        {
            linea++;
            columna++;

            if (accessibility[linea][columna] != 0)
                total++;
        }
        linea = linhaAtual;
        columna = colunaAtual;
        
        
        // superior direita
        while (linea > 0 && columna < accessibility.length - 1)
        {
            linea--;
            columna++;
            
            if (accessibility[linea][columna] != 0)
                total++;
        }
        linea = linhaAtual;
        columna = colunaAtual;
        
        // inferior esquerda
        while (linea < accessibility.length - 1 && columna > 0)
        {
            linea++;
            columna--;
            
            if (accessibility[linea][columna] != 0)
                total++;
        }

        return total;
    }

    public static void accesibilidadeReduzida(int[][] accessibility, int linhaAtual, int colunaAtual)
    {
        // marca a coluna
        for (int coluna = 0; coluna < accessibility.length; coluna++)     
            accessibility[linhaAtual][coluna] = 0;

        // marca a linha
        for (int linha = 0; linha < accessibility.length; linha++)
            accessibility[linha][colunaAtual] = 0;

        int linea = linhaAtual;
        int columna = colunaAtual;

        // superior esquerda
        while (linea > 0 && columna > 0)
            accessibility[--linea][--columna] = 0;

        linea = linhaAtual;
        columna = colunaAtual;
        
        // inferior direita
        while (linea < accessibility.length - 1 && columna < accessibility.length - 1)
            accessibility[++linea][++columna] = 0;

        linea = linhaAtual;
        columna = colunaAtual;
        
        // superior direita
        while (linea <= accessibility.length - 1 && columna < accessibility.length - 1 && linea > 0 && columna >= 0)
            accessibility[--linea][++columna] = 0;

        linea = linhaAtual;
        columna = colunaAtual;
        
        // inferior esquerda
        while (linea < accessibility.length - 1 && columna <= accessibility.length - 1 && linea >= 0 && columna > 0)
            accessibility[++linea][--columna] = 0;
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



