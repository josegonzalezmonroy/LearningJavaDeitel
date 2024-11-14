// 14.16 - Definindo seus próprios métodos String
// Elabore suas próprias versões dos métodos de pesquisa String indexOf e lastIndexOf.

public class Exerc_14_16 
{
    public static void main(String[] args) 
    {
        String line = "Hookjhola";
    
        // Testa o método indexOf para encontrar a primeira ocorrência de 'l'
        System.out.print("Teste 1: Primeira ocorrência de 'l' em \"" + line + "\": ");
        int result = indexOf(line, 'l');
        System.out.println(result == 7 ? "\nPassou (índice: " + result + ")" : "\nFalhou (índice esperado: 7, obtido: " + result + ")");
    
        // Testa o método indexOf para encontrar 'a' começando a partir do índice 3
        System.out.print("Teste 2: Primeira ocorrência de 'a' em \"" + line + "\" começando no índice 3: ");
        result = indexOf(line, 'a', 3);
        System.out.println(result == 8 ? "\nPassou (índice: " + result + ")" : "\nFalhou (índice esperado: 8, obtido: " + result + ")");
    
        // Testa o método lastIndexOf para encontrar a última ocorrência de 'H'
        System.out.print("Teste 3: Última ocorrência de 'H' em \"" + line + "\": ");
        result = lastIndexOf(line, 'H');
        System.out.println(result == 0 ? "\nPassou (índice: " + result + ")" : "\nFalhou (índice esperado: 0, obtido: " + result + ")");
    
        // Testa o método lastIndexOf para encontrar 'o' começando a partir do índice 6, de trás para frente
        System.out.print("Teste 4: Última ocorrência de 'o' em \"" + line + "\" começando no índice 6: ");
        result = lastIndexOf(line, 'o', 6);
        System.out.println(result == 6 ? "\nPassou (índice: " + result + ")" : "\nFalhou (índice esperado: 6, obtido: " + result + ")");
    }

    // Implementa o método lastIndexOf para encontrar a última ocorrência de um caractere em uma string
    public static int lastIndexOf(String string, char character)
    {
        // Verifica se a string é nula ou se o caractere é um espaço em branco
        if (string == null || character == ' ')
            return -1;
    
        // Percorre a string de trás para frente procurando o caractere
        for (int i = string.length() - 1; i >= 0; i--)
            if (string.charAt(i) == character)
                return i;
        
        // Retorna -1 se o caractere não for encontrado
        return -1;
    }

    // Implementa o método lastIndexOf com um índice inicial, para encontrar a última ocorrência de um caractere em uma string
    public static int lastIndexOf(String string, char character, int index)
    {
        // Verifica se a string é nula, se o índice é inválido ou se o caractere é um espaço em branco
        if (string == null || index < 0 || index >= string.length() || character == ' ')
            return -1;
        
        // Percorre a string a partir do índice dado, de trás para frente, procurando o caractere
        for (int i = index; i >= 0; i--)
            if (string.charAt(i) == character)
                return i;
            
        // Retorna -1 se o caractere não for encontrado
        return -1;
    }
    
    // Implementa o método indexOf para encontrar a primeira ocorrência de um caractere em uma string
    public static int indexOf(String string, char character)
    {
        // Verifica se a string é nula ou se o caractere é um espaço em branco
        if (string == null || character == ' ')
            return -1;
        
        // Percorre a string procurando o caractere
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == character)
                return i;
            
        // Retorna -1 se o caractere não for encontrado
        return -1;
    }

    // Implementa o método indexOf com um índice inicial, para encontrar a primeira ocorrência de um caractere em uma string
    public static int indexOf(String string, char character, int index)
    {
        // Verifica se a string é nula, se o índice é inválido ou se o caractere é um espaço em branco
        if (string == null || index < 0 || index >= string.length() || character == ' ')
            return -1;
        
        // Percorre a string a partir do índice dado, procurando o caractere
        for (int i = index; i < string.length(); i++)
            if (string.charAt(i) == character)
                return i;
            
        // Retorna -1 se o caractere não for encontrado
        return -1;
    }
}
