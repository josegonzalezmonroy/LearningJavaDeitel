// 23.15 - Resumindo as palavras em um arquivo
// Reimplemente a Figura 17.17 usando fluxos paralelos. Use as técnicas de cronometragem da API Date/Time que você aprendeu na Seção 23.12 para comparar o tempo necessário para as versões sequenciais e paralelas do programa.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exerc_23_15
{
    public static void main(String[] args) throws IOException
    {
        // Define o padrao para separar as palavras com base em espacos em branco
        Pattern pattern = Pattern.compile("\\s+");

        // Caminho do arquivo a ser lido
        String filePath = "Chapter2Paragraph.txt";

        // Medicao do tempo para execucao sequencial
        Instant startSequential = Instant.now();

        // Conta a frequencia de cada palavra no arquivo usando fluxo sequencial
        Map<String, Long> wordCountsSequencial = Files.lines(Paths.get(filePath))
            .map(line -> line.replaceAll("(?!')\\p{P}", "")) // Remove pontuacao, exceto apostrofos
            .flatMap(line -> pattern.splitAsStream(line)) // Divide linhas em palavras
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
        
        Instant endSequential = Instant.now();

        // Calcula o tempo de execucao sequencial em milissegundos
        long timeSequential = Duration.between(startSequential, endSequential).toMillis();
        System.out.printf("Tempo de execucao sequencial: %d ms%n", timeSequential);
    
        // Medicao do tempo para execucao paralela
        Instant startParallel = Instant.now();

        // Conta a frequencia de cada palavra no arquivo usando fluxo paralelo
        Map<String, Long> wordCountsParallel = Files.lines(Paths.get(filePath))
            .parallel() // Usa fluxo paralelo
            .map(line -> line.replaceAll("(?!')\\p{P}", ""))
            .flatMap(line -> pattern.splitAsStream(line))
            .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
        
        Instant endParallel = Instant.now();

        // Calcula o tempo de execucao paralelo em milissegundos
        long timeParallel = Duration.between(startParallel, endParallel).toMillis();
        System.out.printf("Tempo de execucao paralela: %d ms%n", timeParallel);

        // Exibe palavras e contagens agrupadas pela primeira letra usando fluxo paralelo
        System.out.println("\nPalavras e suas contagens agrupadas por letra inicial (Fluxo Paralelo):");
        wordCountsParallel.entrySet()
            .stream()
            .collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
            .forEach((letter, wordList) -> {
                    System.out.printf("%n%C%n", letter); 
                    wordList.forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));});
    }
}
