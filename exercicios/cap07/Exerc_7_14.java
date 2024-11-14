// 7.14 - Lista de argumento de comprimento variavel 
// Escreva um aplicativo que calcule o produto de uma série de inteiros que são passados para o método product utilizando uma lista de argumentos de comprimento variável. Teste seu método com variáveis chamadas, cada uma com um número diferente de argumentos.

public class Exerc_7_14 
{
    public static void main(String[] args) 
    {
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        int p4 = 4;
        int p5 = 5;
        int p6 = 6;
        int p7 = 7;
        int p8 = 8;
        int p9 = 9;
        int p10 = 10;
        int p11 = 11;
        int p12 = 12;

        System.out.println("Produto 01: " + product(p1, p2, p3, p4));// quatro argumentos
        System.out.println("Produto 02: " + product(p5, p6, p7));// tres argumentos
        System.out.println("Produto 03: " + product(p8, p9, p10, p11, p12));// cinco argumentos

    }
    
    public static int product(int... numbers)// calcula o produto con lista variavel de argumentos
    {
        int produto = 1;// variavel inicializada

        for (int valor : numbers)
            produto *= valor;

        return produto;
    }
}
