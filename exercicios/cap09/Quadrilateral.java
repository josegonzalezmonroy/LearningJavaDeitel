// Classe base para representar um quadrilátero
public class Quadrilateral 
{
    private Point p1; // Primeiro ponto do quadrilátero
    private Point p2; // Segundo ponto do quadrilátero
    private Point p3; // Terceiro ponto do quadrilátero
    private Point p4; // Quarto ponto do quadrilátero

    // Construtor que inicializa os quatro pontos do quadrilátero
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) 
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // Método para obter o primeiro ponto
    public Point getP1() 
    {
        return p1; 
    }

    // Método para obter o segundo ponto
    public Point getP2() 
    {
        return p2; 
    }

    // Método para obter o terceiro ponto
    public Point getP3() 
    {
        return p3; 
    }

    // Método para obter o quarto ponto
    public Point getP4() 
    {
        return p4; 
    }

    // Método para calcular a área do quadrilátero
    // Este método é uma implementação básica que retorna 0.0,
    // e deve ser sobrescrito pelas subclasses que implementam a área específica.
    public double area() 
    {
        return 0.0;
    }

    // Representação em string do quadrilátero com os pontos formatados
    @Override
    public String toString() 
    {
        return String.format("%nP1: %s%nP2: %s%nP3: %s%nP4: %s", getP1(), getP2(), getP3(), getP4());
    }
}
