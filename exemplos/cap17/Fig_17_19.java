// Figura 17.19 - RandomIntStream.java
// Lançando um dado 6.000.000 de vezes
import java.security.SecureRandom; // Classe para gerar números aleatórios seguros
import java.util.function.Function; // Interface Function para funções lambda
import java.util.stream.Collectors; // Classe Collectors para realizar operações de coleta em streams

public class Fig_17_19 
{
    public static void main(String[] args)
    {
       SecureRandom random = new SecureRandom(); // Objeto para gerar números aleatórios
 
       // Lança o dado 6.000.000 de vezes e resume os resultados
       System.out.printf("%-6s%s%n", "Face", "Frequência"); // Cabeçalho da tabela (Face do dado e Frequência)
       
       random.ints(6_000_000, 1, 7) // Gera um stream de 6 milhões de números inteiros entre 1 e 6 (faces de um dado)
             .boxed() // Converte de IntStream para Stream<Integer> para permitir operações de coleta
             .collect(Collectors.groupingBy( // Agrupa os números gerados com base na face do dado
                Function.identity(), // Função que usa a própria face como chave (1, 2, 3, 4, 5, ou 6)
                Collectors.counting())) // Conta quantas vezes cada face apareceu
             .forEach((face, frequency) ->  // Para cada face e sua frequência, imprime o resultado
                System.out.printf("%-6d%d%n", face, frequency)); // Exibe a face e a frequência formatadas
    } 
}
