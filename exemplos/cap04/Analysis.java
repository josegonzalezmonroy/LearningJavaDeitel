// Figura 4.12 - Analysis.java
// Análise dos resultados de exames usando instruções de controle aninhadas.
import java.util.Scanner; // a classe usa a classe Scanner

public class Analysis 
{
   public static void main(String[] args) 
   {
      // criar Scanner para obter entrada da janela de comando
      Scanner input = new Scanner(System.in);

      // inicializando variáveis nas declarações
      int passes = 0; 
      int failures = 0;
      int studentCounter = 1; 

      // processar 10 alunos usando um loop controlado por contador
      while (studentCounter <= 10) 
      {
         // solicitar entrada do usuário e obter valor do usuário
         System.out.print("Digite o resultado (1 = passar, 2 = falhar): ");
         int result = input.nextInt();

         // if...else está aninhado na instrução while           
         if (result == 1)         
            passes = passes + 1;   
         else                        
            failures = failures + 1; 

         // incrementar studentCounter para que o loop eventualmente termine
         studentCounter = studentCounter + 1;  
      } 

      // fase de término; preparar e exibir resultados
      System.out.printf("Passou: %d%nFalhou: %d%n", passes, failures);

      // determinar se mais de 8 alunos passaram
      if (passes > 8)
         System.out.println("Bônus para o instrutor!");
   } 
} // fim da classe Analysis
