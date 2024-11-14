// Figura 4.4 - Student.java
// Classe Student que armazena o nome e a média de um estudante.
public class Student 
{
   private String name; 
   private double average; 

   // construtor inicializa as variáveis de instância
   public Student(String name, double average)
   {
      this.name = name;

      // valida que a média é > 0.0 e <= 100.0; caso contrário,
      // mantém o valor padrão da variável de instância average (0.0)
      if (average > 0.0) 
         if (average <= 100.0)
            this.average = average; // atribui à variável de instância
   }

   // define o nome do estudante
   public void setName(String name)
   {
      this.name = name; 
   }

   // recupera o nome do estudante
   public String getName()
   {
      return name;
   }

   // define a média do estudante
   public void setAverage(double average)
   {
      // valida que a média é > 0.0 e <= 100.0; caso contrário,
      // mantém o valor atual da variável de instância average  
      if (average > 0.0) 
         if (average <= 100.0)
            this.average = average; // atribui à variável de instância
   }

   // recupera a média do estudante
   public double getAverage()
   {
      return average;
   }

   // determina e retorna a nota do estudante
   public String getLetterGrade()
   {
      String letterGrade = ""; // inicializado como String vazia

      if (average >= 90.0)
         letterGrade = "A";
      else if (average >= 80.0)
         letterGrade = "B";
      else if (average >= 70.0)
         letterGrade = "C";
      else if (average >= 60.0)
         letterGrade = "D";
      else
         letterGrade = "F";

      return letterGrade;
   }
} // fim da classe Student
