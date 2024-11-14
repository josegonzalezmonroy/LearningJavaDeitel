// 8.15 - Numeros racionais 
// Crie uma classe chamada Rational para realizar aritmetica com fracoes. Escreva um programa para testar sua classe. Use variaveis de inteiros para representar as variaveis de instancia private da classe — o numerator e o denominator. Forneca um construtor que permita que um objeto dessa classe seja inicializado quando ele for declarado. O construtor deve armazenar a fracoes em uma forma reduzida. A fracoes 2/4 equivalente a 1/2 e seria armazenada no objeto como 1 no numerator e 2 no denominator. Forneca um construtor sem argumento com valores padrao caso nenhum inicializador seja fornecido. Forneca metodos public que realizam cada uma das operacoes a seguir: a) Somar dois numeros Rational: o resultado da adicao deve ser armazenado na forma reduzida. Implemente isso como um metodo static. b) Subtrair dois numeros Rational: o resultado da subtracao deve ser armazenado na forma reduzida. Implemente isso como um metodo static. c) Multiplicar dois numeros Rational: o resultado da multiplicacao deve ser armazenado na forma reduzida. Implemente isso como um metodo static. d) Dividir dois numeros Rational: o resultado da divisao deve ser armazenado na forma reduzida. Implemente isso como um metodo static. e) Retorne uma representacao String de um numero Rational na forma a/b, onde a e o numerator e b e o denominator. f) Retorne uma representacao String de um numero Rational no formato de ponto flutuante. (Considere a possibilidade de fornecer capacidades de formatacao que permitam que o usuario da classe especifique o numero de digitos de precisao a direita do ponto de fracao decimal.)

public class Exerc_8_15 
{
    public static void main(String[] args) 
    {
        Rational rational1 = new Rational(5,6);
        Rational rational2 = new Rational(7, 8);
        Rational rational3 = new Rational();

        System.out.println("Valor padrao: " + rational3 + " = " + rational3.toStringDouble(4));
        System.out.println("Valor 01: " + rational1);
        System.out.println("Valor 02: " + rational2);

        System.out.println(rational1.getNumerator() + "/" + rational1.getDenominator() + " + " + rational2.getNumerator() + "/" + rational2.getDenominator() + " = " + Rational.soma(rational1, rational2) + " = " + Rational.soma(rational1, rational2).toStringDouble(4));

        System.out.println(rational1.getNumerator() + "/" + rational1.getDenominator() + " - " + rational2.getNumerator() + "/" + rational2.getDenominator() + " = " + Rational.subtracao(rational1, rational2) + " = " + Rational.subtracao(rational1, rational2).toStringDouble(4));

        System.out.println(rational1.getNumerator() + "/" + rational1.getDenominator() + " * " + rational2.getNumerator() + "/" + rational2.getDenominator() + " = " + Rational.multiplicacao(rational1, rational2) + " = " + Rational.multiplicacao(rational1, rational2).toStringDouble(4));

        System.out.println(rational1.getNumerator() + "/" + rational1.getDenominator() + " / " + rational2.getNumerator() + "/" + rational2.getDenominator() + " = " + Rational.divisao(rational1, rational2) + " = " + Rational.divisao(rational1, rational2).toStringDouble(4));
    }
}

class Rational
{
    private int numerator;
    private int denominator;

    // Construtor com parâmetros
    public Rational(int numerator, int denominator) 
    {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int mcd = mcdEuclides(numerator, denominator);
        this.numerator = numerator / mcd;
        this.denominator = denominator / mcd;
    
        // Manter o denominador positivo
        if (this.denominator < 0) 
        {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Construtor sem parâmetros com valores padrão
    public Rational() 
    {
        this(0, 1); // Fracção padrão 0/1
    }

    // Método para calcular o MCD
    private static int mcdEuclides(int a, int b) 
    {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) 
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método para calcular o MCM
    private static int mcm(int denominator1, int denominator2)
    {
        return denominator1 * denominator2 / mcdEuclides(denominator1, denominator2);
    }

    // Métodos estáticos para operações aritméticas
    public static Rational soma(Rational rational1, Rational rational2)
    {
        int mcm = mcm(rational1.denominator, rational2.denominator);
        int numerator1 = rational1.numerator * mcm / rational1.denominator;
        int numerator2 = rational2.numerator * mcm / rational2.denominator;
        return new Rational(numerator1 + numerator2, mcm);
    }

    public static Rational subtracao(Rational rational1, Rational rational2)
    {
        int mcm = mcm(rational1.denominator, rational2.denominator);
        int numerator1 = rational1.numerator * mcm / rational1.denominator;
        int numerator2 = rational2.numerator * mcm / rational2.denominator;
        return new Rational(numerator1 - numerator2, mcm);
    }

    public static Rational multiplicacao(Rational rational1, Rational rational2)
    {
        return new Rational(rational1.numerator * rational2.numerator, rational1.denominator * rational2.denominator);
    }

    public static Rational divisao(Rational rational1, Rational rational2)
    {
        if (rational2.numerator == 0) 
            throw new ArithmeticException("Division by zero.");

        return new Rational(rational1.numerator * rational2.denominator, rational1.denominator * rational2.numerator);
    }

    // Representação em forma de string
    public String toString()
    {
        return String.format("%d/%d", numerator, denominator);
    }

    // Representação em ponto flutuante com precisão personalizada
    public String toStringDouble(int precisao)
    {
        return String.format("%." + precisao + "f", (double) numerator / denominator);
    }

    // Métodos de acesso
    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }
}