public class Exerc_18_15 
{
    // Tamanho do tabuleiro (8x8)
    private static final int SIZE = 8;
    // Matriz que representa o tabuleiro
    private static int[][] tabuleiro = new int[SIZE][SIZE];
    
    public static void main(String[] args) 
    {
        // Inicia o processo de colocar as oito rainhas
        if (oitoRainhas(0)) 
            imprimirTabuleiro(); // Imprime o tabuleiro se a solucao for encontrada
        else 
            System.out.println("Nao ha solucao."); // Mensagem caso nao haja solucao

    }

    public static boolean oitoRainhas(int coluna) 
    {
        // Se todas as rainhas foram colocadas, retorna true
        if (coluna >= SIZE) 
            return true;

        // Tenta colocar uma rainha em cada linha da coluna atual
        for (int linha = 0; linha < SIZE; linha++) 
            if (movimentoValido(linha, coluna)) // Verifica se a posição é segura
            { 
                tabuleiro[linha][coluna] = 1; // Coloca a rainha na posição

                // Recursivamente tenta colocar as próximas rainhas
                if (oitoRainhas(coluna + 1))
                    return true; // Se a solucao foi encontrada, retorna true

                // Se não foi possível colocar as rainhas, remove a rainha
                tabuleiro[linha][coluna] = 0;
            }

        return false; // Se não foi possível colocar a rainha em nenhuma linha
    }

    // Método para verificar se é seguro colocar uma rainha
    public static boolean movimentoValido(int linha, int coluna) 
    {
        // Verifica se já existe uma rainha na mesma linha
        for (int i = 0; i < coluna; i++) 
            if (tabuleiro[linha][i] == 1) 
                return false; 

        // Verifica diagonal superior esquerda
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) 
            if (tabuleiro[i][j] == 1) 
                return false; 

        // Verifica diagonal inferior esquerda
        for (int i = linha, j = coluna; i < SIZE && j >= 0; i++, j--) 
            if (tabuleiro[i][j] == 1) 
                return false; 

        return true; // Se todas as verificações passaram, retorna true
    }

    // Método para imprimir o tabuleiro
    public static void imprimirTabuleiro() 
    {
        for (int i = 0; i < SIZE; i++)
        { 
            for (int j = 0; j < SIZE; j++) 
                if (tabuleiro[i][j] == 1) 
                    System.out.print(" Q "); // Imprime a rainha    
                else 
                    System.out.print(" . "); // Imprime um espaço vazio
            System.out.println(); // Nova linha após imprimir uma linha do tabuleiro
        }
    }
}
