// 6.8 - Taxas de estacionamento
// Um estacionamento cobra uma taxa mínima de $ 2 para estacionar por até 3 horas. Um adicional de $ 0,50 por hora não necessariamente inteira é cobrado após as três primeiras horas. A carga máxima para qualquer dado período de 24 horas é $ 10. Suponha que nenhum carro fica estacionado por mais de 24 horas por vez. Escreva um aplicativo que calcule e exiba as taxas de estacionamento para cada cliente que estacionou nessa garagem ontem. Você deve inserir as horas de estacionamento para cada cliente. O programa deve exibir a cobrança para o cliente atual e calcular e exibir o total dos recibos de ontem. O programa deve utilizar o método calculateCharges para determinar a cobrança para cada cliente.
import java.util.Scanner;

public class Exerc_6_8 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a quantidade de horas de estacionamento: ");
        double horas = input.nextDouble();
        
        System.out.printf("Total a pagar: %nR$ %.2f", calculateCharges(horas));
    }
    
    public static double calculateCharges(double tempo)
    {
        double horas = Math.ceil(tempo); // arredonda o valor para cima

        int horasMinimo = 3; // quantidade minima de horas a cobrar
        int tarifaMinima = 2; // tarifa minima a cobrar até 3 horas
        int tarifaMaxima = 10; // tarifa maxima a cobrar
        double adicionalPorHora = 0.5; // adicional por hora a partir de 3 horas 
        double tarifa = 0;

        if (horas <= horasMinimo) // se o tempo for minimo a 3 horas
        {
            horas = horasMinimo;
            tarifa = tarifaMinima;
        }

        horas -= horasMinimo;
        tarifa = (horas * adicionalPorHora) + tarifaMinima;
        
        if (tarifa > tarifaMaxima) // se o total da tarifa for maior a R$ 10
            tarifa = tarifaMaxima; // tarifa será R$ 10

        return tarifa;
    }
}
