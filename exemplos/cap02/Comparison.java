// Figura 2.15 - Comparison.java
// Compara inteiros usando instruções if, operadores relacionais
// e operadores de igualdade.
import java.util.Scanner; // o programa utiliza a classe Scanner

public class Comparison 
{
   // método main começa a execução da aplicação Java
   public static void main(String[] args)
   {
      // cria um Scanner para obter entrada da linha de comando
      Scanner input = new Scanner(System.in);

      int number1; // primeiro número a ser comparado
      int number2; // segundo número a ser comparado

      System.out.print("Digite o primeiro inteiro: "); // mensagem
      number1 = input.nextInt(); // lê o primeiro número do usuário 

      System.out.print("Digite o segundo inteiro: "); // mensagem
      number2 = input.nextInt(); // lê o segundo número do usuário 
      
      if (number1 == number2) 
         System.out.printf("%d == %d%n", number1, number2);

      if (number1 != number2)
         System.out.printf("%d != %d%n", number1, number2);

      if (number1 < number2)
         System.out.printf("%d < %d%n", number1, number2);

      if (number1 > number2)
         System.out.printf("%d > %d%n", number1, number2);

      if (number1 <= number2)
         System.out.printf("%d <= %d%n", number1, number2);

      if (number1 >= number2)
         System.out.printf("%d >= %d%n", number1, number2);
   } // fim do método main
} // fim da classe Comparison
