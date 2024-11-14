// 8.4 - Classe Rectangle 
// Crie uma classe Rectangle com os atributos length e width, cada um dos quais assume o padrão de 1. Forneça os métodos que calculam o perímetro e a área do retângulo. A classe tem métodos set e get para o comprimento (length) e a largura (width). Os métodos set devem verificar se length e width são, cada um, números de ponto flutuante maiores que 0,0 e menores que 20,0. Escreva um programa para testar a classe Rectangle.

public class Exerc_8_4
{
    public static void main(String[] args) 
    {
        Rectangle rectangle1 = new Rectangle();

        try 
        {
            rectangle1.setLength(7.45);
            rectangle1.setWidth(4.10);

            System.out.printf("Length: %.2f%nWidth: %.2f%nPerimetro: %.2f%nArea: %.2f%n", rectangle1.getLength(), rectangle1.getWidth(), rectangle1.perimetro(), rectangle1.area());
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.printf("Erro: %s%n", e.getMessage());
        }
    }
}

class Rectangle
{
    private double length;
    private double width;
    private final String mensagemErro = "O valores inseridos deben ser\n > 0 e < 20";
     
    public Rectangle()
    {
        length = 1;
        width = 1;
    }

    double getLength()
    {
        return length;
    }

    double getWidth()
    {
        return width;
    }

    void setLength(double length)
    {
        if (length <= 0 || length >= 20)
            throw new IllegalArgumentException(mensagemErro);

        this.length = length;
    }

    void setWidth(double width)
    {
        if (width <= 0 || width >= 20)
            throw new IllegalArgumentException(mensagemErro);

        this.width = width;
    }

    double area()
    {
        return length * width;
    }

    double perimetro()
    {
        return 2 * (length + width);
    }
}