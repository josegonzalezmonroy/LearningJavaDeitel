// Classe que representa um cubo tridimensional
public class Cube extends ThreeDimensionalShape 
{
    
    // Variável de instância que armazena o comprimento do lado do cubo
    private double side;

    // Construtor da classe Cube
    // Inicializa o comprimento do lado do cubo
    public Cube(double side) 
    {
        this.side = side;
    }

    // Calcula e retorna a área da superfície do cubo
    @Override
    public double getArea() 
    {
        // A área da superfície de um cubo é 6 vezes o quadrado do comprimento do lado
        return 6 * side * side;
    }

    // Calcula e retorna o volume do cubo
    @Override
    public double getVolume() 
    {
        // O volume de um cubo é o comprimento do lado elevado à terceira potência
        return side * side * side;
    }

    // Retorna uma descrição do cubo
    @Override
    public String getDescription() 
    {
        // Formata e retorna uma descrição com o comprimento do lado do cubo
        return String.format("Cube with side %.2f", side);
    }
}
