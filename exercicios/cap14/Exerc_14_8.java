// 14.8 - Tokenizando números de telefone
// Elabore um aplicativo que insere um número de telefone como uma string na forma (555) 555-5555. O aplicativo deve utilizar o método String split para extrair o código de área como um token, os três primeiros dígitos do número de telefone como um segundo token e os últimos quatro dígitos do número de telefone como um terceiro token. Os sete dígitos do número de telefone devem ser concatenados em uma string. O código de área e o número de telefone devem ser impressos. Lembre-se de que você que terá de alterar caracteres delimitadores durante o processo de tokenização.
import java.util.Scanner;

public class Exerc_14_8
{
    public static void main(String[] args) 
    {
        // Instancia o Scanner para ler a entrada do usuario
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuario que insira um numero de telefone
        System.out.println("Digite um numero de telefone no formato (555) 555-5555:");
        String phoneNumber = scanner.nextLine();

        // Remove os parênteses e os espaços do número de telefone
        // Substitui o parêntese esquerdo '(' por uma string vazia
        // Substitui o parêntese direito ')' por um hífen '-' para separar o código de área do restante do número
        // Remove todos os espaços em branco da string
        phoneNumber = phoneNumber.replace("(", "").replace(")", "-").replace(" ", "");
            
        // Divide o número de telefone em partes usando o hífen como delimitador
        // A função split('-') divide a string onde há hífens e retorna um array com os segmentos resultantes
        String[] parts = phoneNumber.split("-");

        // Extrai o codigo de area e os três segmentos do numero de telefone
        String areaCode = parts[0];
        String firstPart = parts[1];
        String secondPart = parts[2];

        // Concatena os segmentos do numero de telefone
        String fullNumber = areaCode + " " + firstPart + "-" + secondPart;

        // Exibe o codigo de area e o numero completo
        System.out.println("Codigo de area: " + areaCode);
        System.out.println("Numero completo: " + fullNumber);
    }
}
