// Classe abstrata que representa uma forma tridimensional
public abstract class ThreeDimensionalShape extends Shape 
{
    // Método abstrato que deve ser implementado pelas subclasses
    // Calcula e retorna a área da superfície da forma tridimensional
    public abstract double getArea();

    // Método abstrato que deve ser implementado pelas subclasses
    // Calcula e retorna o volume da forma tridimensional
    public abstract double getVolume();
}
