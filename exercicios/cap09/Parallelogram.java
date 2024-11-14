// Classe que representa um paralelogramo, herda de Quadrilateral
public class Parallelogram extends Quadrilateral 
{
    // Construtor que inicializa os quatro pontos do paralelogramo
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) 
    {
        super(p1, p2, p3, p4); // Chama o construtor da superclasse Quadrilateral
    }

    // Método que calcula a área do paralelogramo
    @Override
    public double area() 
    {
        // Calcula o comprimento da base do paralelogramo
        double base = distance(getP1(), getP2()); // Distância entre P1 e P2

        // Calcula a altura do paralelogramo
        double height = Math.abs(getP1().getY() - getP3().getY()); // Suposição simplificada
        
        // Calcula e retorna a área do paralelogramo
        return base * height;
    }

    // Método auxiliar que calcula a distância entre dois pontos
    private double distance(Point p1, Point p2) 
    {
        // Calcula a distância euclidiana entre os pontos p1 e p2
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
