import java.util.Scanner;

public class Salarios {
    public static void main(String[] args) {

        int funcionario = 1;
        double horasTrabalhadas = 0;
        double reaisPorHora = 0;

        Scanner input = new Scanner(System.in);

        while (funcionario <= 3) 
        {
            System.out.print("\nDigite as horas trabalhadas do funcionario: ");
            horasTrabalhadas = input.nextDouble();

            System.out.print("Digite o salario/hora (R$): ");
            reaisPorHora = input.nextDouble();
            
            if (horasTrabalhadas > 40) 
            {
                double horasExtras = (horasTrabalhadas - 40) * 1.5;

                horasTrabalhadas = 40 + horasExtras;
            }
            
            double salarioBruto = horasTrabalhadas * reaisPorHora;
            
            System.out.printf("Salario bruto do funcionario #%d %.2f%n", funcionario, salarioBruto);

            funcionario++;
        }
    }
    
}
