public class CodigoMorse 
{
    // Arrays paralelos para letras e seus respectivos códigos Morse
    private static final char[] LETRAS = 
    {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    
    private static final String[] MORSE = 
    {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", 
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", 
        "..-", "...-", ".--", "-..-", "-.--", "--..", 
        "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
    };

    // Método para codificar uma string em código Morse
    public static String encodeToMorse(String text) 
    {
        // StringBuilder para construir o código Morse
        StringBuilder morseCode = new StringBuilder();

        // Loop para percorrer cada caractere da string
        for (int i = 0; i < text.length(); i++)
            // Verifica se o caractere é um espaço em branco (separação entre palavras)
            if (text.charAt(i) == ' ')
                morseCode.append("   "); // Adiciona três espaços entre palavras
            else 
            {
                // Obtém o índice do caractere na tabela Morse
                int index = getCharIndex(text.toUpperCase().charAt(i));
                
                // Verifica se o caractere foi encontrado na tabela Morse
                if (index != -1) 
                    // Adiciona o código Morse correspondente ao caractere
                    morseCode.append(MORSE[index]).append(" ");
            }

        // Retorna o código Morse completo, removendo espaços extras no final
        return morseCode.toString().trim();
    }

    // Método para decodificar uma string de código Morse para texto
    public static String decodeFromMorse(String morseCode) 
    {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split("   "); // Divide por três espaços (entre palavras)

        for (String word : words) 
        {
            for (String letter : word.split(" ")) 
            { // Divide por um espaço (entre letras)
                int index = getMorseIndex(letter);
                if (index != -1) 
                    text.append(LETRAS[index]);
            }
            text.append(' '); // Adiciona espaço entre as palavras
        }

        return text.toString().trim();
    }

    // Método auxiliar para encontrar o índice de um caractere
    private static int getCharIndex(char c) 
    {
        for (int i = 0; i < LETRAS.length; i++) 
            if (LETRAS[i] == c) 
                return i;
        return -1; // Se o caractere não for encontrado
    }

    // Método auxiliar para encontrar o índice de um código Morse
    private static int getMorseIndex(String code) 
    {
        for (int i = 0; i < MORSE.length; i++) 
            if (MORSE[i].equals(code)) 
                return i;
        return -1; // Se o código Morse não for encontrado
    }
}
