import java.util.Scanner;

public class Combustivel {
    public static void main(String[] args) 
    {
        int kmRodadosTotais = 0;
        int combustivelConsumidoTotal = 0;

        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite os km rodados ou finalize com -1: ");
        int kmRodados = input.nextInt();
        
        while (kmRodados != -1) // repetição por sentinela
        {
            kmRodadosTotais += kmRodados; // adiciona km rodado ao total 
            
            System.out.print("Digite os litros de combustivel consumidos: ");
            int combustivelConsumido = input.nextInt();
            combustivelConsumidoTotal += combustivelConsumido; // adiciona combustivel consumido ao total
            
            double kmPorLitro = (double) kmRodados / combustivelConsumido; // calcula o rendimento de km por litro
            System.out.printf("Consumo de km/l para a viagem: %.2f%n", kmPorLitro);
            
            System.out.print("Digite os km rodados ou finalize com -1: ");            
            kmRodados = input.nextInt();
        }

        if (kmRodadosTotais == 0) // imprime caso não tenha cadastro
            System.out.print("Sem viagens cadastradas");
        else // imprime os totais
        {
            System.out.printf("%nQuilometros totais: %d", kmRodadosTotais);
            System.out.printf("%nCombustivel consumido total: %d litros", combustivelConsumidoTotal);
        }
    }
}// fim da classe Combustivel
