// Classe que representa uma esfera tridimensional
public class Sphere extends ThreeDimensionalShape 
{
    // Variável de instância para armazenar o raio da esfera
    private double radius;

    // Construtor da classe Sphere
    // Inicializa o raio da esfera com o valor fornecido
    public Sphere(double radius) 
    {
        this.radius = radius;
    }

    // Calcula e retorna a área da superfície da esfera
    @Override
    public double getArea() 
    {
        // A área da superfície de uma esfera é 4 * π * raio^2
        return 4 * Math.PI * radius * radius;
    }

    // Calcula e retorna o volume da esfera
    @Override
    public double getVolume() 
    {
        // O volume de uma esfera é (4/3) * π * raio^3
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    // Retorna uma descrição da esfera
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com o raio da esfera
        return String.format("Sphere with radius %.2f", radius);
    }
}
