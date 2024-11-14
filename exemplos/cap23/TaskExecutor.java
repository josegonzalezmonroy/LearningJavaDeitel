// Figura 23.4 - TaskExecutor.java
// Usando um ExecutorService para executar Runnables.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor
{
   public static void main(String[] args)
   {
      // cria e nomeia cada runnable
      PrintTask task1 = new PrintTask("task1");
      PrintTask task2 = new PrintTask("task2");
      PrintTask task3 = new PrintTask("task3");
        
      System.out.println("Iniciando Executor");

      // cria ExecutorService para gerenciar threads
      ExecutorService executorService = Executors.newCachedThreadPool();

      // inicia as tres PrintTasks
      executorService.execute(task1); // inicia task1	
      executorService.execute(task2); // inicia task2
      executorService.execute(task3); // inicia task3

      // encerra o ExecutorService--ele decide quando encerrar as threads
      executorService.shutdown(); 

      System.out.printf("Tarefas iniciadas, main termina.%n%n");
   } 
} // fim da classe TaskExecutor

