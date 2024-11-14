// 17.9 - Resumindo os caracteres em um arquivo
// Modifique o programa da Figura 17.17 para resumir o número de ocorrências de cada caractere no arquivo.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exerc_17_9
{
    public static void main(String[] args) throws IOException 
    {
        // Lê as linhas do arquivo de texto
        Map<String, Long> letterCounts = 
        Files.lines(Paths.get("Chapter2Paragraph.txt")) // Altere para o caminho do seu arquivo
            .map(line -> line.replaceAll("[^a-zA-Z]+", "")) // Remove pontuações (exceto apóstrofos)
            .flatMap(word -> word.chars() // Converte cada palavra em um IntStream de caracteres
                .mapToObj(c -> String.valueOf((char) c))) // Converte int para String
            .collect(Collectors.groupingBy(String::toLowerCase, // Agrupa as letras em minúsculas
                TreeMap::new, Collectors.counting())); // Armazena em um TreeMap (ordem alfabética) e conta as ocorrências

    // Exibe as letras e suas contagens
    letterCounts.forEach((letter, count) -> 
        System.out.printf("%S: %d%n", letter, count)); // Imprime cada letra e sua contagem
}
}
