// Classe que representa um círculo bidimensional
public class Circle extends TwoDimensionalShape 
{
    // Variável de instância para armazenar o raio do círculo
    private double radius;

    // Construtor da classe Circle
    // Inicializa o raio do círculo com o valor fornecido
    public Circle(double radius) 
    {
        this.radius = radius;
    }

    // Calcula e retorna a área do círculo
    @Override
    public double getArea() 
    {
        // A área de um círculo é π * raio^2
        return Math.PI * radius * radius;
    }

    // Retorna uma descrição do círculo
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com o raio do círculo
        return String.format("Circle with radius %.2f", radius);
    }
}
