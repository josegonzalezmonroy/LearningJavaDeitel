// Classe que representa um ponto no plano cartesiano
public class Point 
{
    private double x; // Coordenada x do ponto
    private double y; // Coordenada y do ponto

    // Construtor que inicializa as coordenadas x e y do ponto
    public Point(double x, double y) 
    {
        this.x = x; // Define a coordenada x do ponto
        this.y = y; // Define a coordenada y do ponto
    }

    // Método para obter a coordenada x do ponto
    public double getX() 
    {
        return x;
    }

    // Método para obter a coordenada y do ponto
    public double getY() 
    {
        return y;
    }

    // Método para representar o ponto como uma string formatada
    @Override
    public String toString() 
    {
        return String.format("(%.2f, %.2f)", getX(), getY()); // Retorna a coordenada x e y com duas casas decimais
    }
}
