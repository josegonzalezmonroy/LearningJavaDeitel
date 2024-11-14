import java.util.Scanner;

public class Exerc_21_11 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma frase para verificar se e um palindromo: ");

        String frase = input.nextLine();
        
        System.out.printf("%s um palindromo", isPalindrome(frase) ? "E" : "Nao e");
    }
    
    public static boolean isPalindrome(String frase)
    {
        Stack<Character> pilha = new Stack<>();

        StringBuilder stringLimpa = new StringBuilder();

        for (int i = 0; i < frase.length(); i++)
        {
            char c = Character.toLowerCase(frase.charAt(i));

            if (Character.isLetterOrDigit(c))
            {
                stringLimpa.append(c);
                pilha.push(c);
            }
        }

        for (int i = 0; i < stringLimpa.length(); i++)
            if (stringLimpa.charAt(i) != pilha.pop()) 
                return false;
                
        return true;
    }
}
