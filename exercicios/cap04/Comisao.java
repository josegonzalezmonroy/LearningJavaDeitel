import java.util.Scanner;

public class Comisao {
    public static void main(String[] args) {
        
        int valorFixo = 200;
        double venda = 0;
        double vendasTotais = 0;

        Scanner input = new Scanner(System.in);
        
        while (venda != -1) 
        {
            vendasTotais += venda;
            System.out.print("Digite o valor da venda ou -1 para cancelar: ");
            venda = input.nextDouble();
        }

        if (vendasTotais > 0)
        {
            double rendimento = vendasTotais * 0.09 + valorFixo;
            System.out.println(vendasTotais);
            System.out.printf("Rendimento total: %.2f", rendimento);
            
        }else
        System.out.print("Sem rendimentos para mostrar");
    }
}
