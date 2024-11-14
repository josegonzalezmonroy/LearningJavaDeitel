// 18.20 - Percurso para sair de um labirinto utilizando retorno recursivo
// A grade de #s e pontos (.) na Figura 18.22 é uma representação bidimensional do array de um labirinto. Os #s representam as paredes do labirinto, e os pontos, as localizações nos possíveis caminhos por ele. Um movimento só é permitido nas posições do array que contiverem um ponto. Escreva um método recursivo (mazeTraversal) para percorrer labirintos como o da Figura 18.22. O método deve receber como argumentos o array de caracteres de 12 por 12 representando o labirinto e a localização atual nele (na primeira vez que esse método é chamado, a localização atual deve ser o ponto de entrada no labirinto). À medida que mazeTraversal tenta localizar a saída, ele deve colocar o caractere x em cada quadrado no caminho. Há um algoritmo simples para percorrer um labirinto que garante a localização da saída (assumindo que existe uma saída). Se não houver nenhuma saída, você chegará à localização inicial novamente. O algoritmo é como segue: a partir da localização atual no labirinto, tente mover-se um espaço em qualquer uma das possíveis direções (para baixo, para a direita, para cima ou para a esquerda). Se for possível ir pelo menos para uma direção, chame mazeTraversal recursivamente, passando o novo local no labirinto como o atual. Caso não consiga caminhar em nenhuma direção, "volte" a um local anterior no labirinto e tente um novo sentido a partir desse local (esse é um exemplo do retorno recursivo). Programe o método para exibir o labirinto depois de cada movimento a fim de que o usuário possa observar enquanto uma solução para ele é procurada. A saída final do labirinto deve exibir somente o caminho necessário para resolvê-lo — na hipótese de que seguir por uma direção resulte em um caminho sem saída, o x para marcar esses passos não deve ser exposto. [Dica: para mostrar apenas o caminho final, pode ser útil marcar os locais que resultam em um caminho sem saída com outro caractere (como '0').]
public class Exerc_18_20 
{
    private static char[][] labirinto = {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
        {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
        {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
        {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
        {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public static void main(String[] args) 
    {
        int linha = 2;
        int coluna = 0;
        int entradaLinha = linha;
        int entradaColuna = coluna;

        System.out.println("Labirinto inicial:");
        imprimirLabirinto(labirinto);

        // Inicia a busca pela saída
        if (mazeTraversal(labirinto, linha, coluna, entradaLinha, entradaColuna)) 
            System.out.println("\nLabirinto resolvido:");
        else 
            System.out.println("\nNao ha saida.");

        imprimirLabirinto(labirinto); // Exibe o labirinto final
    }


    // Método recursivo para percorrer o labirinto
    public static boolean mazeTraversal(char[][] labirintoBase, int linha, int coluna, int entradaLinha, int entradaColuna) 
    {
        int linhaLength = labirintoBase.length;
        int colunaLength = labirintoBase[0].length;

        // Verifica se a posição atual é uma parede ou já foi visitada
        if (!movimentoValido(labirintoBase, linha, coluna)) 
            return false; // Se não é um movimento válido, retorna

        // Marca a posição atual com 'x' (parte do caminho)
        labirintoBase[linha][coluna] = 'x';

        // Verifica se a posição atual é a borda (saída)
        if ((linha == 0 || linha == linhaLength - 1 || coluna == 0 || coluna == colunaLength - 1) && !(linha == entradaLinha && coluna == entradaColuna))        
            return true;

        // Tenta mover para baixo
        if (mazeTraversal(labirintoBase, linha + 1, coluna, entradaLinha, entradaColuna)) 
            return true;

        // Tenta mover para a direita
        if (mazeTraversal(labirintoBase, linha, coluna + 1, entradaLinha, entradaColuna)) 
            return true;

        // Tenta mover para cima
        if (mazeTraversal(labirintoBase, linha - 1, coluna, entradaLinha, entradaColuna)) 
            return true;

        // Tenta mover para a esquerda
        if (mazeTraversal(labirintoBase, linha, coluna - 1, entradaLinha, entradaColuna)) 
            return true;

        // Se nenhuma direção foi válida, marca como sem saída e retorna
        labirintoBase[linha][coluna] = '0'; // Marca a posição como sem saída
        return false;
    }

    // Verifica se o movimento para a nova posição é válido
    public static boolean movimentoValido(char[][] labirintoBase, int linha, int coluna) 
    {
        return linha >= 0 && linha < labirintoBase.length && coluna >= 0 && coluna < labirintoBase[0].length && labirintoBase[linha][coluna] == '.';
    }

    // Método auxiliar para imprimir o labirinto
    public static void imprimirLabirinto(char[][] labirintoBase) 
    {
        for (int i = 0; i < labirintoBase.length; i++) 
        {
            for (int j = 0; j < labirintoBase[i].length; j++) 
                System.out.print(labirintoBase[i][j] + " ");

            System.out.println();
        }
        System.out.println();
    }
}
