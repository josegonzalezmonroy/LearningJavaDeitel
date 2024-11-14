// Figura 17.17 - StreamOfLines.java
// Contando ocorrências de palavras em um arquivo de texto.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Fig_17_17 
{
    public static void main(String[] args) throws IOException
   {
      // Regex que corresponde a um ou mais espaços em branco consecutivos
      Pattern pattern = Pattern.compile("\\s+"); 

      // Conta as ocorrências de cada palavra em um Stream<String> e ordena por palavra
      Map<String, Long> wordCounts = 
         Files.lines(Paths.get("Chapter2Paragraph.txt")) // Lê as linhas do arquivo de texto
              .map(line -> line.replaceAll("(?!')\\p{P}", "")) // Remove pontuações (exceto apóstrofos)
              .flatMap(line -> pattern.splitAsStream(line)) // Divide as linhas em palavras usando o padrão de espaços em branco
              .collect(Collectors.groupingBy(String::toLowerCase, // Agrupa as palavras em minúsculas
                 TreeMap::new, Collectors.counting())); // Armazena em um TreeMap (ordem alfabética) e conta as ocorrências
      
      // Exibe as palavras agrupadas pela letra inicial
      wordCounts.entrySet() // Obtém as entradas (palavra e contagem) do mapa
         .stream() // Cria um stream das entradas
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), // Agrupa as palavras pela primeira letra
               TreeMap::new, Collectors.toList())) // Armazena em um TreeMap para manter a ordem alfabética
         .forEach((letter, wordList) ->  // Para cada letra e sua lista de palavras correspondentes:
            { 
               System.out.printf("%n%C%n", letter); // Exibe a letra inicial
               wordList.stream().forEach(word -> System.out.printf(
                  "%13s: %d%n", word.getKey(), word.getValue())); // Exibe cada palavra e sua contagem
            });
   }
}
