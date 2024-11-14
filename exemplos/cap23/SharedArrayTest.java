// Figura 23.7 - SharedArrayTest.java
// Executando dois Runnables para adicionar elementos a um SimpleArray compartilhado.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest
{
   public static void main(String[] arg)
   {
      // constrói o objeto compartilhado
      SimpleArray sharedSimpleArray = new SimpleArray(6);

      // cria duas tarefas para escrever no SimpleArray compartilhado
      ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
      ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

      // executa as tarefas com um ExecutorService
      ExecutorService executorService = Executors.newCachedThreadPool();
      executorService.execute(writer1);
      executorService.execute(writer2);

      executorService.shutdown();

      try
      {
         // espera 1 minuto para ambos os escritores terminarem de executar
         boolean tasksEnded = 
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded)
         {
            System.out.printf("%nConteudo do SimpleArray:%n");
            System.out.println(sharedSimpleArray); // imprime o conteudo
         }
         else
            System.out.println(
               "Tempo esgotado enquanto esperava as tarefas terminarem.");
      } 
      catch (InterruptedException ex)
      {
         ex.printStackTrace();
      } 
   } // fim de main
} // fim da classe SharedArrayTest
