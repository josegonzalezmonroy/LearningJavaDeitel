// 8.11 - Números complexos) 
/* 
Crie uma classe chamada Complex para realizar aritmética com números complexos. Os números complexos têm a forma parteReal + parteImaginária * i 

Escreva um programa para testar sua classe. Utilize variáveis de ponto flutuante para representar os dados private da classe. Forneça um construtor que permita que um objeto dessa classe seja inicializado quando ele for declarado. Forneça um construtor sem argumento com valores padrão caso nenhum inicializador seja fornecido. Forneça métodos public que realizam as seguintes operações:

a) Somar dois números Complex: as partes reais são somadas de um lado e as partes imaginárias, de outro.

b) Subtrair dois números Complex: a parte real do operando direito é subtraída da parte real do operando esquerdo e a parte imaginária do operando direito é subtraída da parte imaginária do operando esquerdo.

c) Imprima números Complex na forma (parteReal, parteImaginária).
*/

public class Exerc_8_11 
{
    public static void main(String[] args) 
    {
        // Inicializa dois números complexos com valores específicos
        Complex complex1 = new Complex(7, -2);
        Complex complex2 = new Complex(5.5, -4);
        
        // Inicializa um número complexo com valores padrão (0, 0)
        Complex complex3 = new Complex();

        // Exibe os números complexos criados
        System.out.println("Complex:");
        System.out.printf("01: %s%n", complex1); // Exibe complex1 no formato (parteReal + parteImaginaria * i)
        System.out.printf("02: %s%n", complex2); // Exibe complex2 no formato (parteReal + parteImaginaria * i)
        System.out.printf("03: %s%n", complex3); // Exibe complex3 no formato (parteReal + parteImaginaria * i)

        // Calcula e exibe a soma dos dois números complexos
        System.out.printf("(%s) + (%s) = %s%n", complex1, complex2, Complex.soma(complex1, complex2));

        // Calcula e exibe a subtração dos dois números complexos
        System.out.printf("(%s) - (%s) = %s%n", complex1, complex2, Complex.subtracao(complex1, complex2));
    }
}

class Complex 
{
    private double parteReal; // Parte real do número complexo
    private double parteImaginaria; // Parte imaginária do número complexo

    // Construtor com argumentos para inicializar partes real e imaginária
    public Complex(double parteReal, double parteImaginaria) 
    {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Construtor sem argumentos, inicializa as partes como 0
    public Complex() 
    {
        this(0, 0);
    }

    // Método estático para somar dois números complexos
    public static Complex soma(Complex complex1, Complex complex2) 
    {
        double novaParteReal = complex1.parteReal + complex2.parteReal;
        double novaParteImaginaria = complex1.parteImaginaria + complex2.parteImaginaria;
        return new Complex(novaParteReal, novaParteImaginaria);
    }

    // Método estático para subtrair um número complexo de outro
    public static Complex subtracao(Complex complex1, Complex complex2) 
    {
        double novaParteReal = complex1.parteReal - complex2.parteReal;
        double novaParteImaginaria = complex1.parteImaginaria - complex2.parteImaginaria;
        return new Complex(novaParteReal, novaParteImaginaria);
    }

    // Método para representar o número complexo como uma string no formato "parteReal + parteImaginaria * i"
    public String toString() 
    {
        // Formata as partes real e imaginária para uma casa decimal
        String parteRealString = String.format("%.1f", parteReal);
        String parteImaginariaString = String.format("%.2f", (parteImaginaria >= 0 ? parteImaginaria : -(parteImaginaria)));

        // Monta e retorna a string representando o número complexo
        return parteRealString + (parteImaginaria >= 0 ? " + " : " - ") + parteImaginariaString + "i";
    }
}
