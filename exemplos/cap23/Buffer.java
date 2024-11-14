// Figura 23.9 - Buffer.java
// Interface Buffer especifica os metodos chamados por Produtor e Consumidor.
public interface Buffer
{
   // coloca o valor int no Buffer
   public void blockingPut(int value) throws InterruptedException; 

   // obtem o valor int do Buffer
   public int blockingGet() throws InterruptedException; 
}
