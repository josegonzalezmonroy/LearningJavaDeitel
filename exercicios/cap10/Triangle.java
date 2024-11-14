// Classe que representa um triângulo bidimensional
public class Triangle extends TwoDimensionalShape 
{
    // Variáveis de instância para armazenar a base e a altura do triângulo
    private double base;
    private double height;

    // Construtor da classe Triangle
    // Inicializa a base e a altura do triângulo com os valores fornecidos
    public Triangle(double base, double height) 
    {
        this.base = base;
        this.height = height;
    }

    // Calcula e retorna a área do triângulo
    @Override
    public double getArea() 
    {
        // A área de um triângulo é 0.5 vezes a base vezes a altura
        return 0.5 * base * height;
    }

    // Retorna uma descrição do triângulo
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com a base e a altura do triângulo
        return String.format("Triangle with base %.2f and height %.2f", base, height);
    }
}
