// Figura 14.18 - TokenTest.java
// Objeto StringTokenizer usado para tokenizar strings

import java.util.Scanner;

public class Fig_14_18 
{
    // executa o aplicativo
    public static void main(String[] args) 
    {
        // obtem a frase
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence and press Enter");
        String sentence = scanner.nextLine();

        // processa a frase do usuario
        String[] tokens = sentence.split(" ");
        System.out.printf("Numbers of elements: %d%nThe tokens are:%n", 
            tokens.length);
        
        for (String token : tokens) 
            System.out.println(token);
    }    
}
