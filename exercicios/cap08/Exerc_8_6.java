// 8.6 - Classe Savings Account
// Crie uma classe SavingsAccount. Utilize uma variável static annualInterestRate para armazenar a taxa de juros anual para todos os correntistas. Cada objeto da classe contém uma variável de instância private savingsBalance para indicar a quantidade que o poupador atualmente tem em depósito. Forneça o método calculateMonthlyInterest para calcular os juros mensais multiplicando o savingsBalance por annualInterestRate dividido por 12 — esses juros devem ser adicionados ao savingsBalance. Forneça um método static modifyInterestRate que configure o annualInterestRate com um novo valor. Escreva um programa para testar a classe SavingsAccount. Instancie dois objetos savingsAccount, saver1 e saver2, com saldos de R$ 2.000,00 e R$ 3.000,00, respectivamente. Configure annualInterestRate como 4% e então calcule o juro mensal de cada um dos 12 meses e imprima os novos saldos para os dois poupadores. Em seguida, configure annualInterestRate para 5%, calcule a taxa do próximo mês e imprima os novos saldos para os dois poupadores.
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Exerc_8_6 
{
    public static void main(String[] args) 
    {
        SavingsAccount saver1 = new SavingsAccount(new BigDecimal("2000"));
        SavingsAccount saver2 = new SavingsAccount(new BigDecimal("3000"));

        // Taxa de juros ao ano 4%
        SavingsAccount.setAnnualInterestRate(4);
        System.out.printf("Inicial (%.2f%%)%nSaver1: %s%nSaver2: %s%n", SavingsAccount.getAnnualInterestRate(), saver1.getBalance(), saver2.getBalance());

        // Calculando os juros para 12 meses
        System.out.println("Saver1 - 12 meses de juros:");
        saver1.calculateMonthlyInterest(12);
        System.out.println("Saver2 - 12 meses de juros:");
        saver2.calculateMonthlyInterest(12);

        // Modificando a taxa de juros para 5%
        SavingsAccount.setAnnualInterestRate(5);
        System.out.printf("%nNovo saldo com %.2f%% de juros para um mes:%nSaver1: %s%nSaver2: %s%n", SavingsAccount.getAnnualInterestRate(), saver1.getBalance(), saver2.getBalance());

        // Mes adicional com a nova taxa
        System.out.printf("Saver1 - 1 mes de juros com %.2f%%:%n", SavingsAccount.getAnnualInterestRate());
        saver1.calculateMonthlyInterest(1);
        System.out.printf("Saver2 - 1 mes de juros com %.2f%%:%n", SavingsAccount.getAnnualInterestRate());
        saver2.calculateMonthlyInterest(1);
    }
}

class SavingsAccount
{
    private static double annualInterestRate;
    private BigDecimal savingsBalance;

    public SavingsAccount(BigDecimal savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }

    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double jurosAoAno)
    {
        annualInterestRate = jurosAoAno;
    }

    public String getBalance()
    {
        return NumberFormat.getCurrencyInstance().format(savingsBalance);
    }

    public void calculateMonthlyInterest(int months)
    {
        BigDecimal rate = BigDecimal.valueOf(annualInterestRate);// juros ao ano
        BigDecimal divisor = BigDecimal.valueOf(100);
        BigDecimal juro = rate.divide(divisor, 4, RoundingMode.HALF_EVEN);// 0,0400
        BigDecimal meses = BigDecimal.valueOf(12);
        BigDecimal resultado = juro.divide(meses, 4, RoundingMode.HALF_EVEN);// 0,0033

        // calcula quantidade de deposito para cada um dos meses
        for (int month = 1; month <= months; month++)
        {
            // calcula nova quantidade durante o mes especificado
            BigDecimal amount = savingsBalance.multiply(resultado);
            savingsBalance = savingsBalance.add(amount);

            // exibe o mes e a quantidade
            System.out.printf("%4d%20s%n", month, NumberFormat.getCurrencyInstance().format(savingsBalance));
        }
    }
}
