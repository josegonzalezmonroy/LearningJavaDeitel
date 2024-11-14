// Classe que representa um carro, que implementa a interface CarbonFootprint
public class Car implements CarbonFootprint 
{
    private double fuelConsumption; // Consumo de combustível em litros por 100 km
    private double kilometersDriven; // Quilômetros dirigidos

    // Construtor para inicializar o consumo de combustível e quilômetros dirigidos
    public Car(double fuelConsumption, double kilometersDriven) 
    {
        this.fuelConsumption = fuelConsumption;
        this.kilometersDriven = kilometersDriven;
    }

    // Implementação do método getCarbonFootprint para calcular a pegada de carbono do carro
    @Override
    public double getCarbonFootprint() 
    {
        // Exemplo de cálculo: CO2 emitido por litro de combustível
        return (fuelConsumption / 100) * kilometersDriven * 2.31;
    }

    @Override
    public String toString() 
    {
        return String.format("Car with fuel consumption: %.2f L/100km and kilometers driven: %.2f km", fuelConsumption, kilometersDriven);
    }
}
