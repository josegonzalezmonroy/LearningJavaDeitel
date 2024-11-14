// Figura 5.12 - AutoPolicyTest.java
// Demonstrando Strings em switch.

public class AutoPolicyTest
{
   public static void main(String[] args)
   {
      // criar dois objetos AutoPolicy
      AutoPolicy policy1 = 
         new AutoPolicy(11111111, "Toyota Camry", "NJ");
      AutoPolicy policy2 = 
         new AutoPolicy(22222222, "Ford Fusion", "ME");

      // exibir se cada apólice está em um estado sem culpa
      policyInNoFaultState(policy1);
      policyInNoFaultState(policy2);
   }

   // método que exibe se uma AutoPolicy 
   // está em um estado com seguro automotivo sem culpa 
   public static void policyInNoFaultState(AutoPolicy policy)
   {
      System.out.println("A apólice de automóvel:");
      System.out.printf(
         "Número da conta: %d; Carro: %s;%nEstado %s %s um estado sem culpa%n%n", 
         policy.getAccountNumber(), policy.getMakeAndModel(), 
         policy.getState(), 
         (policy.isNoFaultState() ? "é": "não é"));
   } 
} // fim da classe AutoPolicyTest
