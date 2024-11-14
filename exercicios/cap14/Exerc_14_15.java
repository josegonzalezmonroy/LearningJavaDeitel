import java.util.Scanner;

public class Exerc_14_15
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuario
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuario que insira um codigo inteiro
        System.out.println("Digite um codigo inteiro (0 a 255):");
        int code = scanner.nextInt();

        // Verifica se o codigo esta no intervalo valido
        if (code >= 0 && code <= 255) 
        {
            // Converte o codigo inteiro para o caractere correspondente
            char character = (char) code;
            // Exibe o caractere
            System.out.println("O caractere correspondente ao codigo " + code + " e: " + character);
        } 
        else 
            System.out.println("Codigo invalido. O codigo deve estar entre 0 e 255.");
        
        // Exibe todos os codigos e caracteres correspondentes no intervalo de 0 a 255
        System.out.println("Cod | Caract");
        System.out.println("----------------------");
                
        for (int i = 0; i <= 255; i++) 
        {
        // Converte o codigo inteiro para o caractere correspondente
        char character = (char) i;
        // Exibe o codigo e o caractere
        System.out.printf("%03d | %c%n", i, character);
        }
    }
}
