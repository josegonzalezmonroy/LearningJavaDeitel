import java.util.Scanner;

public class Limite 
{
    public static void main(String[] args) {
        
        int conta = 0;
        int saldoInicial = 0;
        int itensDoMes = 0;
        int creditos = 0;
        int limiteDeCredito = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o numero da conta: ");
        conta = input.nextInt();

        System.out.print("Saldo no inicio do mes: ");
        saldoInicial = input.nextInt();

        System.out.print("Total de compras do mes: ");
        itensDoMes = input.nextInt();

        System.out.print("Total de creditos do mes: ");
        creditos = input.nextInt();

        System.out.print("Limite de credito: ");
        limiteDeCredito = input.nextInt();

        int saldo = saldoInicial + itensDoMes - creditos;

        if (saldo > limiteDeCredito) 
        {
            System.out.printf("Limite de credito da conta %d excedido", conta);
        }else
            System.out.printf("Conta: %d%nSaldo: %d", conta, saldo);
    }    
}
