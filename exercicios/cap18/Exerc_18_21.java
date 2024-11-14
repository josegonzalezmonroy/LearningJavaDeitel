import java.security.SecureRandom;

public class Exerc_18_21
{
    private static SecureRandom random = new SecureRandom();
    private static final int SIZE = 12; // Tamanho do labirinto
    private static char[][] labirinto = new char[SIZE][SIZE];

    private static int linhaEntrada;
    private static int colunaEntrada = 0;
    public static void main(String[] args) 
    {
        // Gera um labirinto aleatório
        do 
        {
            mazeGenerator(labirinto);
            System.out.println("Labirinto gerado aleatoriamente:");
            Exerc_18_20.imprimirLabirinto(labirinto);
        } 
        while (!Exerc_18_20.mazeTraversal(labirinto, linhaEntrada, colunaEntrada, linhaEntrada, colunaEntrada));

        System.out.println("\nLabirinto resolvido:");
        Exerc_18_20.imprimirLabirinto(labirinto);
    }

    public static int linhaEntrada()
    {
        return linhaEntrada;
    }

    // Metodo para gerar um labirinto aleatoriamente
    public static void mazeGenerator(char[][] labirintoBase) 
    {
        int linhaLength = labirintoBase.length;
        int colunaLength = labirintoBase[0].length;
        
        linhaEntrada = 1 + random.nextInt(linhaLength - 2);
        int linhaSaida = 1 + random.nextInt(linhaLength - 2);
        int colunaSaida = colunaLength - 1;


        // Preenche o labirinto com paredes ('#') e caminhos ('.')
        for (int i = 0; i < linhaLength; i++) 
            for (int j = 0; j < colunaLength; j++) 
                // Bordas externas sempre serão paredes
                if ((i == 0 || i == linhaLength - 1 || j == 0 || j == colunaLength - 1) && !(i == linhaEntrada && j == colunaEntrada && i == linhaSaida && j == colunaLength)) 
                    labirintoBase[i][j] = '#';
                else 
                    // Gera aleatoriamente paredes e caminhos
                    labirintoBase[i][j] = random.nextBoolean() ? '.' : '#';

        // Define as posições de entrada e saída como caminhos
        labirintoBase[linhaEntrada][colunaEntrada] = '.'; // Entrada
        labirintoBase[linhaSaida][colunaSaida] = '.'; // Saída
    }
}
