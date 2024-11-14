// 23.16 - Resumindo os caracteres em um arquivo
// Reimplemente o Exercício 17.9 usando fluxos paralelos. Use as técnicas de cronometragem da API Date/Time que você aprendeu na Seção 23.12 para comparar o tempo necessário para as versões sequenciais e paralelas do programa.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exerc_23_16
{
    public static void main(String[] args) throws IOException 
    {
        String filePath = "Chapter2Paragraph.txt"; // Defina o caminho do arquivo de texto

        // Contagem de letras com fluxo sequencial
        Instant startSequential = Instant.now();
        
        Map<String, Long> letterCountsSequential = Files.lines(Paths.get(filePath))
            .map(line -> line.replaceAll("[^a-zA-Z]+", "")) // Remove caracteres que não são letras
            .flatMap(word -> word.chars().mapToObj(c -> String.valueOf((char) c))) // Transforma caracteres em strings
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting())); // Conta letras
        
        Instant endSequential = Instant.now();
        long timeSequential = Duration.between(startSequential, endSequential).toMillis();
        System.out.printf("Tempo de execucao sequencial: %d ms%n", timeSequential);

        // Contagem de letras com fluxo paralelo
        Instant startParallel = Instant.now();

        Map<String, Long> letterCountsParallel = Files.lines(Paths.get(filePath))
            .parallel() // Habilita processamento paralelo
            .map(line -> line.replaceAll("[^a-zA-Z]+", ""))
            .flatMap(word -> word.chars().mapToObj(c -> String.valueOf((char) c)))
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

        Instant endParallel = Instant.now();
        long timeParallel = Duration.between(startParallel, endParallel).toMillis();
        System.out.printf("Tempo de execucao paralela: %d ms%n", timeParallel);

        // Exibe o resultado da contagem de letras (versão paralela)
        System.out.println("\nContagem de letras (Fluxo Paralelo):");
        letterCountsParallel.forEach((letter, count) -> 
            System.out.printf("%S: %d%n", letter, count)); // Exibe cada letra e sua contagem
    }
}
