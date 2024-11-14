// 9.8 - Hierarquia de heranca Quadrilateral
// Escreva uma hierarquia de heranca para as classes Quadrilateral, Trapezoid, Parallelogram, Rectangle e Square. Utilize Quadrilateral como a superclasse da hierarquia. Crie e use uma classe Point para representar os pontos em cada forma. Faça a hierarquia o mais profunda possivel (isto e, com muitos niveis). Especifique as variaveis de instancia e os metodos para cada classe. As variaveis de instancia private de Quadrilateral devem ser os pares de coordenadas x-y para os quatro pontos que delimitam o Quadrilateral. Escreva um programa que instancia objetos de suas classes e gera saida da area de cada objeto (exceto Quadrilateral).

// Classe principal para testar a hierarquia de herança dos quadriláteros
public class Exerc_9_8 
{
    public static void main(String[] args) 
    {
        // Criação dos pontos que serão utilizados para definir as formas
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);

        // Criação dos objetos de quadriláteros usando os pontos definidos
        Quadrilateral trapezoid = new Trapezoid(p1, p2, p3, p4);
        Quadrilateral parallelogram = new Parallelogram(p1, p2, p3, p4);
        Quadrilateral rectangle = new Rectangle(p1, p2, p3, p4);
        Quadrilateral square = new Square(p1, p2, p3, p4);

        // Exibição das informações e da Area do Trapézio
        System.out.println("Trapezoid: " + trapezoid);
        System.out.println("Area do Trapezoide: " + trapezoid.area());

        // Exibição das informações e da Area do Paralelogramo
        System.out.println("Parallelogram: " + parallelogram);
        System.out.println("Area do Paralelogramo: " + parallelogram.area());

        // Exibição das informações e da Area do Retangulo
        System.out.println("Rectangle: " + rectangle);
        System.out.println("Area do Retangulo: " + rectangle.area());

        // Exibição das informações e da Area do Quadrado
        System.out.println("Square: " + square);
        System.out.println("Area do Quadrado: " + square.area());
    }
}
