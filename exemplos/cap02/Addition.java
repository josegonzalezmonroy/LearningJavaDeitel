// Figura 2.7 - Addition.java
// Programa de adição que exibe a soma de dois números.
import java.util.Scanner; // o programa utiliza a classe Scanner

public class Addition 
{
   // método main começa a execução da aplicação Java
   public static void main(String[] args)
   {
      // cria um Scanner para obter entrada da janela de comando
      Scanner input = new Scanner(System.in);

      int number1; // primeiro número a ser somado
      int number2; // segundo número a ser somado
      int sum; // soma de number1 e number2

      System.out.print("Digite o primeiro inteiro: "); // mensagem
      number1 = input.nextInt(); // lê o primeiro número do usuário

      System.out.print("Digite o segundo inteiro: "); // mensagem
      number2 = input.nextInt(); // lê o segundo número do usuário

      sum = number1 + number2; // soma os números e armazena o total em sum

      System.out.printf("A soma é %d%n", sum); // exibe a soma
   } // fim do método main
} // fim da classe Addition
