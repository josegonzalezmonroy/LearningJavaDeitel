// 10.13 - Projeto: hierarquia Shape
// Implemente a hierarquia Shape mostrada na Figura 9.3. Cada TwoDimensionalShape deve conter o método getArea para calcular a área da forma bidimensional. Cada ThreeDimensionalShape deve ter métodos getArea e getVolume para calcular a área do volume e superfície, respectivamente, da forma tridimensional. Crie um programa que utiliza um array de referências Shape para objetos de cada classe concreta na hierarquia. O programa deve imprimir uma descrição de texto do objeto ao qual cada elemento no array se refere. Além disso, no loop que processa todas as formas no array, determine se cada forma é uma TwoDimensionalShape ou uma ThreeDimensionalShape. Se for uma TwoDimensionalShape, exiba sua área. Se for uma ThreeDimensionalShape, exiba sua área e volume.
public class ShapeTest 
{
    public static void main(String[] args) 
    {
        // Cria um array de objetos Shape com 6 elementos
        Shape[] shapes = new Shape[6];

        // Inicializa o array com diferentes formas
        shapes[0] = new Circle(6);              // Círculo com raio 6
        shapes[1] = new Square(4);              // Quadrado com lado 4
        shapes[2] = new Triangle(3, 6);         // Triângulo com base 3 e altura 6
        shapes[3] = new Sphere(2);              // Esfera com raio 2
        shapes[4] = new Cube(3);                // Cubo com lado 3
        shapes[5] = new Tetrahedron(2);         // Tetraedro com lado 2

        // Itera sobre cada forma no array
        for (Shape shape : shapes) 
        {
            // Imprime a descrição da forma
            System.out.println(shape.getDescription());

            // Verifica se a forma é uma TwoDimensionalShape
            if (shape instanceof TwoDimensionalShape) 
            {
                // Faz o downcast para TwoDimensionalShape
                TwoDimensionalShape two = (TwoDimensionalShape) shape;
                // Imprime a área da forma
                System.out.printf("Area: %.2f%n", two.getArea());
            } 
            // Verifica se a forma é uma ThreeDimensionalShape
            else if (shape instanceof ThreeDimensionalShape) 
            {
                // Faz o downcast para ThreeDimensionalShape
                ThreeDimensionalShape three = (ThreeDimensionalShape) shape;
                // Imprime a área e o volume da forma
                System.out.printf("Area: %.2f%nVolume: %.2f%n", three.getArea(), three.getVolume());
            }
            // Adiciona uma linha em branco para separar as saídas
            System.out.println();
        }
    }
}
