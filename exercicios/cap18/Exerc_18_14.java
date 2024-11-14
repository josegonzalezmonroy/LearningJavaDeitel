// 18.14 - Palíndromos
// Um palíndromo é uma string que pode ser lida igualmente da esquerda para a direita e da direita para a esquerda. Alguns exemplos de palíndromos são "radar", "a cara rajada da jararaca" e "a bola da loba". Escreva um método recursivo testPalindrome que retorna o valor boolean true, se a string armazenada no array for um palíndromo, e false, caso contrário. O método deve ignorar espaços e pontuação na string.
public class Exerc_18_14
{
    public static void main(String[] args) 
    {
        String frase = "a cara rajada da jararaca"; // frase que sera testada
        
        // converte a frase para letras minusculas e remove espacos e pontuacao
        String fraseTeste = frase.toLowerCase().replaceAll("[^a-z]", "");
        
        // imprime o resultado, verificando se a frase e um palindromo
        System.out.printf("'%s' %s palindromo%n", frase, palindrome(fraseTeste, 0, fraseTeste.length() - 1) ? "e" : "nao e");   
    }

    // metodo recursivo para verificar se a frase e um palindromo
    public static boolean palindrome(String frase, int left, int right)
    {
        // caso base: se o indice esquerdo for maior ou igual ao direito, e palindromo
        if (left >= right) 
            return true;

        // compara os caracteres da esquerda e da direita
        if (frase.charAt(left) == frase.charAt(right))
            // chamada recursiva para verificar o restante da string
            return palindrome(frase, left + 1, right - 1);
        else
            return false; // se os caracteres forem diferentes, nao e palindromo
    }
} 
