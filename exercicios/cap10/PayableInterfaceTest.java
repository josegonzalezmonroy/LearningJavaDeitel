// 10.15 - Modificação do sistema de contas a pagar
// Neste exercício, modificamos o aplicativo de contas a pagar das figuras 10.11 a 10.15 a fim de incluir a funcionalidade completa do aplicativo de folha de pagamento das figuras 10.4 a 10.9. O aplicativo ainda deve processar dois objetos Invoice, mas agora deve processar um objeto de cada uma das quatro subclasses Employee. Se o objeto atualmente processado for uma BasePlusCommissionEmployee, o aplicativo deverá aumentar o salário-base de BasePlusCommissionEmployee em 10%. Por fim, o aplicativo deve gerar a saída da quantia de pagamento para cada objeto. Complete os seguintes passos para criar o novo aplicativo: a) Modifique as classes HourlyEmployee (Figura 10.6) e CommissionEmployee (Figura 10.7) para colocá-las na hierarquia Payable como subclasses da versão de Employee (Figura 10.13) que implementa Payable. [Dica: altere o nome do método earnings para getPaymentAmount em cada subclasse, de modo que a classe satisfaça seu contrato herdado com a interface Payable.] b) Modifique a classe BasePlusCommissionEmployee (Figura 10.8) para que ela estenda a versão da classe CommissionEmployee criada na parte (a). c) Modifique PayableInterfaceTest (Figura 10.15) para processar polimorficamente duas Invoice, uma SalariedEmployee, uma HourlyEmployee, uma CommissionEmployee e uma BasePlusCommissionEmployee. Primeiro gere uma representação String de cada objeto Payable. Em seguida, se um objeto for uma BasePlusCommissionEmployee, aumente seu salário-base em 10%. Por fim, gere a saída da quantia de pagamento para cada objeto Payable.

public class PayableInterfaceTest 
{
    public static void main(String[] args) 
    {
        Payable[] payables = new Payable[6];

        payables[0] = new Invoice("01234", "seat", 2, 375.00);
        payables[1] = new Invoice("56789", "tire", 4, 79.95);
        payables[2] = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(1, 15, 1980), 800.00);
        payables[3] = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(2, 24, 1985), 16.75, 40);
        payables[4] = new CommissionEmployee("Sue", "Jones", "333-33-3333", new Date(3, 30, 1990), 10000, .06);
        payables[5] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", new Date(4, 15, 1995), 5000, .04, 300);

        for (Payable currentPayable : payables) 
        {
            System.out.printf("%n%s %nPayment Due: $%,.2f%n", currentPayable.toString(), currentPayable.getPaymentAmount());

            if (currentPayable instanceof BasePlusCommissionEmployee) 
            {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                System.out.printf("New base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }
        }
    }
}
