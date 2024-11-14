// Figura 5.11 - AutoPolicy.java
// Classe que representa uma apólice de seguro automotivo.

public class AutoPolicy
{
   private int accountNumber; // número da conta da apólice
   private String makeAndModel; // carro ao qual a apólice se aplica
   private String state; // abreviação do estado de duas letras

   // construtor
   public AutoPolicy(int accountNumber, String makeAndModel, String state)
   {
      this.accountNumber = accountNumber;
      this.makeAndModel = makeAndModel;
      this.state = state;
   }

   // define o accountNumber
   public void setAccountNumber(int accountNumber)
   {
      this.accountNumber = accountNumber;
   }

   // retorna o accountNumber
   public int getAccountNumber()
   {
      return accountNumber;
   } 

   // define o makeAndModel
   public void setMakeAndModel(String makeAndModel)
   {
      this.makeAndModel = makeAndModel;
   }

   // retorna o makeAndModel
   public String getMakeAndModel()
   {
      return makeAndModel;
   } 

   // define o state
   public void setState(String state)
   {
      this.state = state;
   }

   // retorna o state
   public String getState()
   {
      return state;
   }

   // método predicado retorna se o estado tem seguro sem culpa
   public boolean isNoFaultState()
   {
      boolean noFaultState; 
      
      // determina se o estado tem seguro automotivo sem culpa
      switch (getState()) // obtém a abreviação do estado do objeto AutoPolicy
      {
         case "MA": case "NJ": case "NY": case "PA":
            noFaultState = true;
            break;
         default:
            noFaultState = false;
            break;
      }

      return noFaultState;
   }
} // fim da classe AutoPolicy
