// Figura 23.3 - PrintTask.java
// Classe PrintTask dorme por um tempo aleatorio de 0 a 5 segundos
import java.security.SecureRandom;

public class PrintTask implements Runnable 
{
   private final static SecureRandom generator = new SecureRandom();
   private final int sleepTime; // tempo aleatorio de espera para a thread
   private final String taskName; // nome da tarefa
    
   // construtor
   public PrintTask(String taskName)
   {
      this.taskName = taskName;
        
      // escolhe um tempo aleatorio de espera entre 0 e 5 segundos
      sleepTime = generator.nextInt(5000); // milissegundos
   } 

   // metodo run contem o codigo que uma thread executara
   public void run() 
   {
      try  
      {// coloca a thread para dormir pelo tempo de sleepTime
         System.out.printf("%s vai dormir por %d milissegundos.%n", 
            taskName, sleepTime);
         Thread.sleep(sleepTime); // coloca a thread para dormir
      }       
      catch (InterruptedException exception)
      {
         exception.printStackTrace();
         Thread.currentThread().interrupt(); // reinterrompe a thread
      } 
        
      // imprime o nome da tarefa
      System.out.printf("%s terminou de dormir%n", taskName); 
   } 
} // fim da classe PrintTask