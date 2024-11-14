// Figura 4.15 - Increment.java
// Operadores de incremento prefixo e postfixo.

public class Increment 
{
   public static void main(String[] args)
   {   
      // demonstrar operador de incremento postfixo
      int c = 5; 
      System.out.printf("c antes do postincremento: %d%n", c); // imprime 5
      System.out.printf("    postincrementando c: %d%n", c++); // imprime 5
      System.out.printf(" c depois do postincremento: %d%n", c); // imprime 6

      System.out.println(); // pular uma linha

      // demonstrar operador de incremento prefixo
      c = 5; 
      System.out.printf(" c antes do preincremento: %d%n", c); // imprime 5
      System.out.printf("     preincrementando c: %d%n", ++c); // imprime 6
      System.out.printf("  c depois do preincremento: %d%n", c); // imprime 6
   } 
} // fim da classe Increment
