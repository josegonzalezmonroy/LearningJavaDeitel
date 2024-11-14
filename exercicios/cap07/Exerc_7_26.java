// 7.26 - Passeio do cavalo: teste do passeio do cavalo
// No passeio do cavalo (Exercício 7.22), um passeio completo acontece quando o cavalo se move tocando cada um dos 64 quadrados do tabuleiro de xadrez unicamente uma vez. Um passeio fechado ocorre quando o 64º movimento cai no quadrado em que o cavalo iniciou o passeio. Modifique o aplicativo no Exercício 7.22 para testar o caso de um passeio fechado se um passeio completo tiver ocorrido.

public class Exerc_7_26 
{
    public static void main(String[] args) 
    {
        int jogo = 0;// contador das quantidades de jogos realizadas

        for (int j = 0; j < 8; j++)// percorre as linhas
        {
            for (int k = 0; k < 8; k++)// percorre as colunas
            {
                int[][] board = new int[8][8]; // tabuleiro
                int[][] accessibility = {
                {2, 3, 4, 4, 4, 4, 3, 2},
                {3, 4, 6, 6, 6, 6, 4, 3},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {3, 4, 6, 6, 6, 6, 4, 3},
                {2, 3, 4, 4, 4, 4, 3, 2}
                }; // clasificacao dos cuadrados (acessibilidade heuristica)
                int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2}; // movimentos horizontais
                int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1}; // movimentos verticais     
                int currentRow = j;// posicao inicial da linha
                int currentColumn = k;// posicao inicial da coluna
                int movimentacoes = 0;// contador para os movimentos 
                boolean sentinela = false;// permite controlar o bucle

                while (!sentinela) 
                {
                    sentinela = true;// muda o sentinela para true, se nao existir nenhuma interacao na frente, o bucle se interrompe

                    int[] movimentos = new int[8];// array que armazena cada possivel movimento valido
        
                    for (int moveAccess = 0; moveAccess < horizontal.length; moveAccess++) 
                    {// determina os movimentos futuros
                        if (movimentoValido(moveAccess, currentRow, currentColumn, vertical, horizontal, board))
                        // se o movimento for valido, vai armazenar o valor de accesibilidade em cada indice do array movimentos com o moveAccess
                            movimentos[moveAccess] = accessibility[currentRow + vertical[moveAccess]][currentColumn + horizontal[moveAccess]];
                        else
                        // se nao for valido vai armazenar o valor 2147483647 
                            movimentos[moveAccess] = Integer.MAX_VALUE; // movimiento no válido
                    }
        
                    int minimo = valorMinimo(movimentos);// chama o metodo valor minimo e o armacena na variavel minimo
                    int vezes = valorMinimoVezes(movimentos, minimo);// usando a variavel minimo, chama o metodo valorMinimoVezes para saber quantas veces aparece o valor minimo
        
                    if (minimo == Integer.MAX_VALUE)// se o valor minimo é 2147483647, que dizer que o array nao tem valores de movimentos validos, entao o cavalo nao pode avancar mais e o programa se fecha
                    {
                        if (movimentacoes != 64)// se acontecer em um momento diferente das 64 jogadas o programa vai mostrar a mensagem 
                            System.out.printf("O cavalo esta bloqueado na iteracao %d%n", movimentacoes);

                        // se acontecer com 64 movimentos quer dizer que o cavalo ocupou todos os espacos do tabuleiro e nao precisa mostrar a mensagem de erro, mesmo assim o programa se fecha
                        break;
                    }
        
                    if (vezes > 1)// se o movimento minimo se repete dois vezes ou mais, precisamos avaliar os possiveis movimentos mais favoraveis
                    {
                        board[currentRow][currentColumn] = movimentacoes;// marca a posicao atual para nao ser considerada na hora de calcular os movimentos validos futuros
        
                        int[] repetidos = indice(movimentos, minimo, vezes);// chama o metodo indice (que retorna um array) para saber em qual indice do array aparecem os valores minimos e os armazena no array repetidos, cada valor armacenado no array repetidos é um tipo de movimento valido disponivel

                        int menorJogada = Integer.MAX_VALUE;// cria uma valiavel menor jogada que é inicializada com um valor de movimento nao valido (2147483647)
        
                        for (int jogadas = 0; jogadas < repetidos.length; jogadas++) 
                        {// faz um bucle pelo array repetidos
                            int jogada = repetidos[jogadas];// atribui cada valor encontrado do array repetidos
        
                            // con o valor encontrado no array atualiza os valores de linha e coluna para a possivel jogada
                            currentRow += vertical[jogada];
                            currentColumn += horizontal[jogada];
        
                            for (int posicao = 0; posicao < 8; posicao++)// bucle para avaliar os possiveis movimentos validos
                            {
                                if (movimentoValido(posicao, currentRow, currentColumn, vertical, horizontal, board))// valida cada movimento valido possivel e armazena os valores de accesibilidade na lista movimentos
                                    movimentos[posicao] = accessibility[currentRow + vertical[posicao]][currentColumn + horizontal[posicao]];
                                else 
                                // armazena os movimentos nao validos no array movimentos
                                    movimentos[posicao] = Integer.MAX_VALUE; // movimiento no válido
                            }
        
                            int valorMinimoFuturo = valorMinimo(movimentos);// chama o metodo valorMinimo no array movimentos e armazena o valor na variavel
                            
                            if (valorMinimoFuturo < menorJogada)// se o valor minimo for menor a 2147483647
                            {
                                menorJogada = valorMinimoFuturo;// atribui o valorMinimo a variavel menorJogada para saber qual valor minimo futuo é o menor das jogadas possiveis
                                minimo = jogada;// atribui a jogda na variavel minimo 
                            }
        
                            // volta o cavalo a posicao anterior para avaliar os outros possiveis movimentos validos
                            currentRow -= vertical[jogada];
                            currentColumn -= horizontal[jogada];
                        }
                        
                        // depois de finaliza o bucle e avaliar os possiveis movimentos futuros e ter encontrado o valor minimo, vamos a validar o movimento possivel daquele valorMinimo para realizar a jogada
                        if (movimentoValido(minimo, currentRow, currentColumn, vertical, horizontal, board)) 
                        {
                            currentRow += vertical[minimo];
                            currentColumn += horizontal[minimo];

                            sentinela = false;// modifica o sentinela para continuar com o bucle
                            movimentacoes++;// aumenta +1 o contador
        
                            board[currentRow][currentColumn] = movimentacoes;// marca o tabuleiro com o numero do contador
                            accessibility[currentRow][currentColumn] = 0;// e como a posicao ja foi ocupada atualiza o numero de accesibilidade a 0
                        }
                    } 
                    else if (vezes == 1) // se o valor minimo aparece uma vez so
                    {
                        for (int indice = 0; indice < movimentos.length; indice++)// faz uma busca no array pelo valor minimo 
                        {
                            if (movimentos[indice] == minimo)// se encontrar o valor
                            {
                                minimo = indice;// o valor minimo vai ser igual ao indice, e o valor do indice que dizer o valor do tipo de movimento
                                break;// para o bucle
                            }
                        }
                        if (movimentoValido(minimo, currentRow, currentColumn, vertical, horizontal, board)) 
                        {// avalia o movimento e se for valido, avanca
                            currentRow += vertical[minimo];
                            currentColumn += horizontal[minimo];
        
                            sentinela = false;// modifica o sentinela para continuar com o bucle
                            movimentacoes++;// aumenta +1 o contador
        
                            board[currentRow][currentColumn] = movimentacoes;// marca o tabuleiro com o numero do contador
                            accessibility[currentRow][currentColumn] = 0;// e como a posicao ja foi ocupada atualiza o numero de accesibilidade a 0
                        }
                    }
        
                    // depois de ter avancado, fazemos uma atualizacao dos movimentos validos e da accesibilidade em cada movimento valido.
                    for (int posicao = 0; posicao < 8; posicao++) 
                    {
                        if (movimentoValido(posicao, currentRow, currentColumn, vertical, horizontal, board)) 
                            movimentos[posicao] = --accessibility[currentRow + vertical[posicao]][currentColumn + horizontal[posicao]]; 
                        else 
                            movimentos[posicao] = Integer.MAX_VALUE;
                    }
                }
                jogo++;

                if (j == currentRow && k == currentColumn)
                {
                    System.out.printf("Passeio fechado%nJogo: %02d%nMovimentos: %02d%nInicial: board[%d][%d]%nFinal: board[%d][%d]%n", jogo, movimentacoes, j, k, currentRow, currentColumn);
                    imprimeTabuleiro(board);
                }
            }
        }
    }

    public static int[] indice(int[] movimentos, int minimo, int vezes) 
    {// retorna o numero do indice no array onde aparece o valor minimo, quando o valor minimo se repete varias vezes
        int[] repetidos = new int[vezes];
        int counter = 0;

        for (int indice = 0; indice < movimentos.length; indice++) 
        {
            if (movimentos[indice] == minimo) 
            {
                repetidos[counter] = indice;
                counter++;
            }
        }

        return repetidos;
    }

    public static boolean movimentoValido(int moveNumber, int currentRow, int currentColumn, int[] vertical, int[] horizontal, int[][] board)// verifica os movimentos validos e retorna true o false dependendo da condicao, evitar mover o cavalo fora do tabuleiro
    {
        int newRow = currentRow + vertical[moveNumber];
        int newColumn = currentColumn + horizontal[moveNumber];

        return newRow >= 0 && newColumn >= 0 && newRow < board.length && newColumn < board.length && board[newRow][newColumn] == 0;
    }

    public static int valorMinimoVezes(int[] movimentos, int valorMinimo)// mostrar a quantidade de vezes que aparece o valor minimo
    {
        int vezes = 0;

        for (int valor : movimentos) 
            if (valor == valorMinimo) 
                vezes++;

        return vezes;
    }

    public static int valorMinimo(int[] movimentos)// mostra o valor minimo 
    {
        int valorMinimo = Integer.MAX_VALUE;// inicializa o valo minimo com un valor de movimento nao valido

        for (int movimento : movimentos) 
            if (movimento < valorMinimo)// se encontrar um valor menor ao valor minimo 
                valorMinimo = movimento;// se reatribui o valor

        return valorMinimo;
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
