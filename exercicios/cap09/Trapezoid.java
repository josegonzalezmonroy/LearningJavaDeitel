// Classe que representa um trapézio, herda de Quadrilateral
public class Trapezoid extends Quadrilateral 
{
    // Construtor que inicializa os quatro pontos do trapézio
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) 
    {
        super(p1, p2, p3, p4); // Chama o construtor da superclasse Quadrilateral
    }

    // Método que calcula a área do trapézio
    @Override
    public double area() 
    {
        // Calcula o comprimento das bases do trapézio
        double base1 = distance(getP1(), getP2()); // Distância entre P1 e P2
        double base2 = distance(getP3(), getP4()); // Distância entre P3 e P4
        
        // Calcula a altura do trapézio
        double height = Math.abs(getP1().getY() - getP3().getY()); // Suposição simplificada

        // Calcula e retorna a área do trapézio
        return 0.5 * (base1 + base2) * height;
    }

    // Método auxiliar que calcula a distância entre dois pontos
    private double distance(Point p1, Point p2) 
    {
        // Calcula a distância euclidiana entre os pontos p1 e p2
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
