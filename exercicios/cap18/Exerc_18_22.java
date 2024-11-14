// 18.22 - Labirintos de qualquer tamanho
// Generalize os métodos mazeTraversal e mazeGenerator da Questão 18.20 e da Questão 18.21 para processar labirintos de qualquer largura e altura.
public class Exerc_18_22 
{
    public static void main(String[] args) 
    {
        // Definindo o tamanho do labirinto (número de linhas e colunas)
        int linhaSize = 20; // Número de linhas do labirinto
        int colunaSize = 30; // Número de colunas do labirinto
        
        // Inicializa a matriz que representará o labirinto
        char[][] labirintoBase = new char[linhaSize][colunaSize];
        
        int linhaEntrada; // Variável para armazenar a linha de entrada do labirinto

        // Loop para gerar o labirinto até que um labirinto solucionável seja encontrado
        do 
        {
            // Gera um labirinto aleatório
            Exerc_18_21.mazeGenerator(labirintoBase);
            
            // Obtém a linha de entrada do labirinto
            linhaEntrada = Exerc_18_21.linhaEntrada();
        } 
        // Continua gerando até encontrar um labirinto que possa ser solucionado
        while (!Exerc_18_20.mazeTraversal(labirintoBase, linhaEntrada, 0, linhaEntrada, 0));
        
        // Exibe o labirinto já resolvido
        System.out.println("\nLabirinto resolvido:");
        Exerc_18_20.imprimirLabirinto(labirintoBase);
        
        // Exibe as dimensões do labirinto
        System.out.println("Linhas: " + linhaSize + "\nColunas: " + colunaSize);
    }   
}
