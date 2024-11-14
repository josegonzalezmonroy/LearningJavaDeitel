// Classe que representa um quadrado, herda de Rectangle
public class Square extends Rectangle 
{
    // Construtor que inicializa os quatro pontos do quadrado
    public Square(Point p1, Point p2, Point p3, Point p4) 
    {
        super(p1, p2, p3, p4); // Chama o construtor da superclasse Rectangle
    }

    // Método que calcula a área do quadrado
    @Override
    public double area() 
    {
        // Chama o método area da superclasse Rectangle,
        // pois o cálculo da área para um quadrado é o mesmo que o de um retângulo
        return super.area();
    }
}
