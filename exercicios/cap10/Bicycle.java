// Classe que representa uma bicicleta, que implementa a interface CarbonFootprint
public class Bicycle implements CarbonFootprint 
{
    private double manufacturingEmission; // Emissão de CO2 na fabricação em kg
    private double maintenanceEmission; // Emissão de CO2 com manutenção em kg

    // Construtor para inicializar as emissões de fabricação e manutenção
    public Bicycle(double manufacturingEmission, double maintenanceEmission) 
    {
        this.manufacturingEmission = manufacturingEmission;
        this.maintenanceEmission = maintenanceEmission;
    }

    // Implementação do método getCarbonFootprint para calcular a pegada de carbono da bicicleta
    @Override
    public double getCarbonFootprint() 
    {
        // Exemplo de cálculo: soma das emissões de fabricação e manutenção
        return manufacturingEmission + maintenanceEmission;
    }

    @Override
    public String toString() 
    {
        return String.format("Bicycle with manufacturing emission: %.2f kg CO2 and maintenance emission: %.2f kg CO2", manufacturingEmission, maintenanceEmission);
    }
}
