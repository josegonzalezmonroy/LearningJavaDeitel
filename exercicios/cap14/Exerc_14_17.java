import java.util.Scanner;

public class Exerc_14_17 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira uma palavra com cinco letras
        System.out.println("Digite uma palavra com cinco letras:");
        String palavra = scanner.nextLine();

        // Verifica se a palavra tem exatamente cinco letras
        if (palavra.length() != 5) 
            System.out.println("Por favor, insira uma palavra com exatamente cinco letras.");
        else 
        {
            System.out.println("Possiveis combinacoes de tres letras:");

            // Gera todas as combinacoes possiveis de tres letras
            for (int i = 0; i < palavra.length(); i++) 
            {
                for (int j = 0; j < palavra.length(); j++) 
                {
                    if (j == i) 
                        continue;
                    for (int k = 0; k < palavra.length(); k++) 
                    {
                        if (k == i || k == j) 
                            continue;

                        // Exibe a combinacao gerada
                        System.out.printf("%s%s%s%n", palavra.charAt(i), palavra.charAt(j), palavra.charAt(k));
                    }
                }
            }
        }
    }
}
