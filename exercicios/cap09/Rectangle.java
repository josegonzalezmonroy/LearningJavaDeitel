// Classe que representa um retângulo, herda de Parallelogram
public class Rectangle extends Parallelogram 
{
    // Construtor que inicializa os quatro pontos do retângulo
    public Rectangle(Point p1, Point p2, Point p3, Point p4) 
    {
        super(p1, p2, p3, p4); // Chama o construtor da superclasse Parallelogram
    }

    // Método que calcula a área do retângulo
    @Override
    public double area() 
    {
        // Chama o método area da superclasse Parallelogram, 
        // pois o cálculo da área para um retângulo é o mesmo que o de um paralelogramo
        return super.area();
    }
}
