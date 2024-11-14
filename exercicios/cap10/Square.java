// Classe que representa um quadrado bidimensional
public class Square extends TwoDimensionalShape 
{
    // Variável de instância para armazenar o comprimento do lado do quadrado
    private double side;

    // Construtor da classe Square
    // Inicializa o comprimento do lado do quadrado com o valor fornecido
    public Square(double side) 
    {
        this.side = side;
    }

    // Calcula e retorna a área do quadrado
    @Override
    public double getArea() 
    {
        // A área de um quadrado é o quadrado do comprimento do lado
        return side * side;
    }

    // Retorna uma descrição do quadrado
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com o comprimento do lado do quadrado
        return String.format("Square with side %.2f", side);
    }
}
