// Classe que representa um tetraedro tridimensional
public class Tetrahedron extends ThreeDimensionalShape 
{
    // Variável de instância para armazenar o comprimento do lado do tetraedro
    private double side;

    // Construtor da classe Tetrahedron
    // Inicializa o comprimento do lado do tetraedro com o valor fornecido
    public Tetrahedron(double side) 
    {
        this.side = side;
    }

    // Calcula e retorna a área da superfície do tetraedro
    @Override
    public double getArea() 
    {
        // A área da superfície de um tetraedro regular é √3 vezes o quadrado do comprimento do lado
        return Math.sqrt(3) * side * side;
    }

    // Calcula e retorna o volume do tetraedro
    @Override
    public double getVolume() 
    {
        // O volume de um tetraedro regular é (lado^3) / (6 * √2)
        return Math.pow(side, 3) / (6 * Math.sqrt(2));
    }
    
    // Retorna uma descrição do tetraedro
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com o comprimento do lado do tetraedro
        return String.format("Tetrahedron with side %.2f", side);
    }
}
