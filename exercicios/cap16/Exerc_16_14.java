// 16.14 - Contando letras
// Modifique o programa da Figura 16.18 para contar o número de ocorrências de cada letra em vez do número de cada palavra. Por exemplo, a string "HELLO THERE" contém dois Hs, três Es, dois Ls, um O, um T e um R. Exiba os resultados.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exerc_16_14 
{
    public static void main(String[] args) 
    {
        // Cria HashMap para armazenar chaves Character e valores Integer
        Map<Character, Integer> myMap = new HashMap<>();

        createMap(myMap); // Cria mapa com base na entrada do usuário
        displayMap(myMap); // Exibe o conteúdo do mapa
    }

    // Cria mapa de entrada de usuário
    private static void createMap(Map<Character, Integer> map) 
    {
        Scanner scanner = new Scanner(System.in); // Cria o scanner
        System.out.println("Digite uma string:"); // Solicita a entrada do usuário
        String input = scanner.nextLine().toUpperCase(); // Converte para letras maiúsculas

        // Processa cada caractere individualmente
        for (char letra : input.toCharArray()) 
            if (letra >= 'A' && letra <= 'Z') // Conta apenas letras de A a Z
                // Se o mapa já contiver a letra
                if (map.containsKey(letra))
                {
                    int count = map.get(letra); // Obtém a contagem atual
                    map.put(letra, count + 1); // Incrementa a contagem
                } 
                else 
                    map.put(letra, 1); // Adiciona nova letra com contagem 1
        
    }

    // Exibe o conteúdo do mapa
    private static void displayMap(Map<Character, Integer> map) 
    {
        Set<Character> keys = map.keySet(); // Obtém as chaves (letras)

        // Classifica as chaves (letras) em ordem alfabética
        TreeSet<Character> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nO mapa contem:%nLetra\t\tQuantidade%n");

        // Exibe cada letra no mapa
        for (Character key : sortedKeys) 
            System.out.printf("%-10s%10d%n", key, map.get(key));

        System.out.printf("%nTamanho: %d%nEsta vazio: %b%n", map.size(), map.isEmpty());
    }
}
