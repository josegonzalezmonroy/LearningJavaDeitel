//7.23 - Passeio do cavalo, abordagens de força bruta 
/* 
Na parte (c) do exercício 7.22, desenvolvemos uma solução para o problema do passeio do cavalo. A abordagem utilizada, chamada de 'acessibilidade heurística', gera muitas soluções e executa eficientemente. À medida que os computadores continuam crescendo em potência, seremos capazes de resolver cada vez mais problemas com a pura capacidade do computador e algoritmos relativamente simples. Vamos chamar essa abordagem de solução de problemas de abordagem de 'força bruta'. 

a) Utilize a geração de números aleatórios para permitir ao cavalo andar no tabuleiro de xadrez (em seus movimentos válidos em forma de L) de maneira aleatória. Seu aplicativo deve executar um passeio e exibir o tabuleiro final. Até onde o cavalo chegou?

b) Muito provavelmente, o aplicativo na parte (a) produziu um passeio relativamente curto. Agora modifique seu aplicativo para tentar mil passeios. Utilize um array unidimensional para monitorar o número de passeios de cada comprimento. Quando seu aplicativo terminar de tentar os mil passeios, ele deve exibir organizadamente essas informações em formato tabular. Qual foi o melhor resultado ?

c) Muito provavelmente, o aplicativo na parte (b) forneceu alguns passeios 'respeitáveis', mas nenhum passeio completo. (Atenção: Essa versão do aplicativo poderia executar durante horas em um computador poderoso.) Mais uma vez, mantenha uma tabela do número de passeios de cada comprimento e exiba essa tela quando o primeiro passeio completo for localizado. Quantos percursos seu aplicativo tenta antes de produzir um passeio completo ? Quanto tempo ele levou ? 

d) Compare a versão de força bruta do passeio do cavalo com a versão de acessibilidade heurística. Qual exigiu estudo mais cuidadoso do problema ? Qual algoritmo foi mais difícil de desenvolver ? Qual exigiu mais capacidade do computador ? Poderíamos ter certeza (com antecedência) de obter um passeio completo com a abordagem de acessibilidade heurística ? Poderíamos ter certeza (com antecedência) de obter um passeio completo com a abordagem de força bruta ? Argumente as vantagens e desvantagens de resolver problema de força bruta em geral.
*/
import java.security.SecureRandom;

public class Exerc_7_23 
{
    public static void main(String[] args) 
    {
        int[][] board = new int[8][8];// tabuleiro
        int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2}; // movimentos horizontais
        int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1}; // movimentos verticais
        int movimentos = 0;

        while (movimentos != 64)// enquanto não se complete um passeio completo
        {
            board = new int[8][8]; // novo tabuleiro
            int currentRow = movimentoAleatorio();// posicao inicial da linha
            int currentColumn = movimentoAleatorio();// posicao inicial da coluna
            int counter = 0;// contador
            boolean sentinela = false;
            
            while (!sentinela)
            {
                sentinela = true;// muda o sentinela para true, se nao existir nenhuma interacao na frente, o bucle se interrompe
                int[] movimentosNaoValidos = new int[8];// armazena os movimentos nao validos para cada tentativa
    
                while (movimentosIndisponiveis(movimentosNaoValidos) < 8)// enquanto movimentos nao validos seja menor a 8, ainda existen movimentos validos para testar
                {            
                    int movimento = movimentoAleatorio();// gera o movimento mediante numero aleatorio
    
                    if (movimentoValido(movimento, currentRow, currentColumn, vertical, horizontal, board))// se o movimento for valido
                    {
                        // atualiza a posicao atual para avançar
                        currentRow += vertical[movimento];
                        currentColumn += horizontal[movimento];
                    
                        sentinela = false;// modifica o sentinela para continuar o bucle
                        counter++;// aumenta +1 o contador
                        board[currentRow][currentColumn] = counter;// marca o tabuleiro com o numero do contador
                        break;
                    }
                    else//guarda o movimento para nao tentar de novo
                        movimentosNaoValidos[movimento] = 1;
                }
            }    
            movimentos = counter;
        }
        imprimeTabuleiro(board);// imprime o tabuleiro quando conseguir os 64 movimentos
        System.out.println("Movimentos: " + movimentos);// imprime a quantidade de movimentos
    }

    public static int movimentosIndisponiveis(int[] movimentosNaoValidos)
    {// metodo para saber quantos sao os movimentos indisponiveis
        int indisponiveis = 0;

        for (int movimento : movimentosNaoValidos)
            indisponiveis += movimento;

        return indisponiveis;
    }

    public static int movimentoAleatorio()// gera um numero aleatorio entre 0 e 7
    {
        SecureRandom randomNumbers = new SecureRandom();
        
        return randomNumbers.nextInt(8);
    }
    
    public static boolean movimentoValido(int moveNumber, int currentRow, int currentColumn, int[] vertical, int[] horizontal, int[][] board)// verifica os movimentos validos e retorna true o false dependendo da condicao, evitar mover o cavalo fora do tabuleiro
    {
        int newRow = currentRow + vertical[moveNumber];
        int newColumn = currentColumn + horizontal[moveNumber];

        return newRow >= 0 && newColumn >= 0 && newRow < board.length && newColumn < board.length && board[newRow][newColumn] == 0;
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
