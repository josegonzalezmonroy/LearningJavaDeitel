// Classe que representa um edifício, que implementa a interface CarbonFootprint
public class Building implements CarbonFootprint 
{
    private double electricityUsage; // Consumo de eletricidade em kWh
    private double gasUsage; // Consumo de gás em metros cúbicos

    // Construtor para inicializar os consumos de eletricidade e gás
    public Building(double electricityUsage, double gasUsage) 
    {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
    }

    // Implementação do método getCarbonFootprint para calcular a pegada de carbono do edifício
    @Override
    public double getCarbonFootprint() 
    {
        // Exemplo de cálculo: CO2 emitido por kWh de eletricidade e m³ de gás
        return (electricityUsage * 0.5) + (gasUsage * 2.2);
    }

    @Override
    public String toString() 
    {
        return String.format("Building with electricity usage: %.2f kWh and gas usage: %.2f m³", electricityUsage, gasUsage);
    }
}
