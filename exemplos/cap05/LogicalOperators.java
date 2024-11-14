// Figura 5.20 - LogicalOperators.java
// Operadores lógicos.

public class LogicalOperators 
{
   public static void main(String[] args)
   {
      // cria tabela verdade para && (E condicional)
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "E condicional (&&)", "falso && falso", (false && false),
         "falso && verdadeiro", (false && true), 
         "verdadeiro && falso", (true && false),
         "verdadeiro && verdadeiro", (true && true));

      // cria tabela verdade para || (OU condicional)
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "OU condicional (||)", "falso || falso", (false || false),
         "falso || verdadeiro", (false || true),
         "verdadeiro || falso", (true || false),
         "verdadeiro || verdadeiro", (true || true));

      // cria tabela verdade para & (E lógico booleano)
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "E lógico booleano (&)", "falso & falso", (false & false),
         "falso & verdadeiro", (false & true),
         "verdadeiro & falso", (true & false),
         "verdadeiro & verdadeiro", (true & true));

      // cria tabela verdade para | (OU inclusivo lógico booleano)
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "OU inclusivo lógico booleano (|)",
         "falso | falso", (false | false),
         "falso | verdadeiro", (false | true),
         "verdadeiro | falso", (true | false),
         "verdadeiro | verdadeiro", (true | true));

      // cria tabela verdade para ^ (OU exclusivo lógico booleano)
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "OU exclusivo lógico booleano (^)", 
         "falso ^ falso", (false ^ false),
         "falso ^ verdadeiro", (false ^ true),
         "verdadeiro ^ falso", (true ^ false),
         "verdadeiro ^ verdadeiro", (true ^ true));

      // cria tabela verdade para ! (negação lógica)
      System.out.printf("%s%n%s: %b%n%s: %b%n", "NÃO lógico (!)",
         "!falso", (!false), "!verdadeiro", (!true));
   } 
} // fim da classe LogicalOperators
