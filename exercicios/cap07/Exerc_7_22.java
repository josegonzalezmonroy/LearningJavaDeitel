// 7.22 - Passeio do cavalo
/* Um dos problemas mais difíceis e interessantes para os fãs de xadrez é o problema do 'passeio do cavalo', originalmente proposto pelo matemático Euller. A peça de chadrez chamada cavalo pode mover-se em um tabuleiro vazio e tocar cada um dos 64 quadrados uma vez e unicamente uma vez? Aqui, estudaremos esse intrigante problema em profundidadde. O cavalo só faz movimentos em forma de L (dois espaços em uma direção e outro em direção perpendicular). Portanto, como mostrado na Figura 7.32, partindo de um quadrado próximo do centro de um tabuleiro de xadrez vazio, o cavalo (rotulado K) pode fazer oito movimentos diferentes (numerados de 0 a 7).

                0   1   2   3   4   5   6   7                
            -----------------------------------              
            0 |   |   |   |   |   |   |   |   |                    -----------------------------------                 
            1 |   |   |   | 2 |   | 1 |   |   |                    -----------------------------------                 
            2 |   |   | 3 |   |   |   | 0 |   |                    -----------------------------------                 
            3 |   |   |   |   | K |   |   |   |                    -----------------------------------                
            4 |   |   | 4 |   |   |   | 7 |   |                    -----------------------------------                 
            5 |   |   |   | 5 |   | 6 |   |   |                    -----------------------------------                 6 |   |   |   |   |   |   |   |   |                    -----------------------------------                 7 |   |   |   |   |   |   |   |   |                    
            -----------------------------------         
            Figura 7.32 Os oito possíveis movimentos do cavalo      
                     
a) Desenhe um tabuleiro de xadrez oito por oito em uma folha de papel e tente o passeio do cavalo manualmente. Coloque um 1 no quadrado inicial, um 2 no segundo quadrado, um 3 no terceiro e assim por diante. Antes de iniciar o passeio, estime até onde você chegará, lembrando-se que um passeio completo consiste de 64 movimentos. Até onde você foi? Isso foi próximo de sua estimativa?

b) Agora vamos desenvolver um aplicativo que moverá o cavalo pelo tabuleiro. O tabuleiro é representado por um array bidimensional oito por oito 'board'. Cada quadro é inicializado como zero. Descrevemos cada um dos oito movimentos possíveis em termos de seus componentes vertical e horizontal. Por exemplo, um movimento do tipo 0 como mostrado na Figura 7.32 consiste em mover dois quadrados horizontalmente para a direita e um quadrado verticalmente para cima. Um movimento do tipo 2 consiste em mover um quadrado horizontalmente para a esquerda e dois quadrados e dois quadrados verticalmente para cima. Movimentos horizontais para a esquerda e movimentos verticais para cima são indicados com números negativos. Os oitos movimentos podem ser descritos por dois arrays unidimensionais, 'horizontal' e 'vertical', como segue:

            horizontal[ 0 ] =  2        vertical[ 0 ] = -1
            horizontal[ 1 ] =  1        vertical[ 1 ] = -2                  
            horizontal[ 2 ] = -1        vertical[ 2 ] = -2                  
            horizontal[ 3 ] = -2        vertical[ 3 ] = -1                  
            horizontal[ 4 ] = -2        vertical[ 4 ] =  1                  
            horizontal[ 5 ] = -1        vertical[ 5 ] =  2                  
            horizontal[ 6 ] =  1        vertical[ 6 ] =  2                  
            horizontal[ 7 ] =  2        vertical[ 7 ] =  1         
                    
Faça com que as variáveis currentRow e currentColumn indiquem, respectivamente, a linha e a coluna da posição atual do cavalo. Para fazer um movimento do tipo moveNumber, que que moveNumber está entre 0 e 7, seu aplicativo deve utilizar as instruções 

            currentRow += vertical[ moveNumber ];  
            currentColumn += horizontal[ moveNumber ]; 

Escreva um aplicativo para mover o cavalo pelo tabuleiro. Mantenha um contador que varia de 1 para 64. Registre a última contagem em cada quadrado para que o cavalo se move. Teste cada movimento potencial para assegurar que o cavalo não saia fora do tabuleiro. Execute o aplicativo. Quantos movimentos o cavalo fez ?

c) Depois de tentar escrever e executar um aplicativo para o passeido do cavalo, você provavelmente desenvolveu algumas idéias valiosas. Utilizaremos essas percepções para desenvolver uma heurística (ou 'regra geral') para mover o cavalo. A heurística não garante sucesso, mas a heurística cuidadosamente desenvolvida aumenta signifivamente a a chance de sucesso. Você pode ter observado que os quadrados externos são mais incômodos que os quadrados próximos do centro do tabuleiro. De fato, os quadrados mais problemáticos ou inacessíveis são os quatro cantos. A intuição pode sugerir que você deva tentar mover o cavalo para os quatro mais problemáticos primeiro e deixar abertos aqueles que são fáceis de alcançar de modo que, quando o tabuleiro ficar congestionado próximo do fim do passeio, haja uma maior chance de sucesso. Poderíamos desenvolver uma 'acessibilidade heurística' classificando cada um dos quadrados de acordo com seu grau de acessibilidade e então sempre movendo o cavalo (utilizando os movimentos em forma de L) para o quadrado mais incessível. Rotulamos um array bidimensional 'accessibility' com números indicando apartir de quantos quadrados cada quadrado particular é acessível. Em um tabuleiro vazio, cada um dos 16 quadrados mais próximos do centro é avaliado como 8, o quadrado de cada canto é avaliado como 2, e os outros quadrados têm números de acessibilidade de 3, 4 ou 6 como segue:

            2  3  4  4  4  4  3  2
            3  4  6  6  6  6  4  3                          
            4  6  8  8  8  8  6  4                          
            4  6  8  8  8  8  6  4                          
            4  6  8  8  8  8  6  4                          
            4  6  8  8  8  8  6  4                          
            3  4  6  6  6  6  4  3                          
            2  3  4  4  4  4  3  2              
                    
Escreva uma versão do passeio do cavalo utilizando a heurística de acessibilidade. O cavalo sempre deve mover-se para o quadrado com o número de acessibilidade mais baixo. Em caso de um impasse, o cavalo pode mover-se para qualquer quadrado já visitado. Portanto, o passeio pode começar em qualquer um dos quatro cantos. [Nota: À medida que o cavalo se move pelo tabuleiro de xadrez, seu aplicativo deve reduzir os números de acessibilidade conforme mais quadrados se tornam ocupados. Dessa maneira, em qualquer dado momento durando o passeio, o número de acessibilidade de cada quadrado disponível permanecerá precisamente igual ao número de quadrados a partir dos quais esse quadrado pode ser alcançado.] Execute essa versão do aplicativo. Você obteve um passeio completo? Modifique o aplicativo para executar 64 passeios, um iniciando a partir de cada quadrado do tabuleiro de xadrez. Quantos passeios completos você obteve ?   

d) Escreva uma versão do aplicativo passeio do cavalo que, diante de um impasse entre dois ou mais quadrados decide qual quadrado escolher olhando para aqueles quadrados alcançáveis a partir dos quadrados gerados do impasse. Seu aplicatico deve mover para o quadrado empatado para o qual o próximo movimento chegaria a um quadrado com o número de acessibilidade mais baixo.
 */
public class Exerc_7_22 
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

                System.out.printf("Jogo: %02d - Movimentos: %02d - Inicial: board[%d][%d] - Final: board[%d][%d]%n", jogo, movimentacoes, j, k, currentRow, currentColumn);
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