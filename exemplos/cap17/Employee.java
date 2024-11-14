// Figura 17.9 - Employee.java
// Classe Employee 
public class Employee 
{
   private String firstName;   // Primeiro nome do funcionário
   private String lastName;    // Sobrenome do funcionário
   private double salary;      // Salário do funcionário
   private String department;  // Departamento onde o funcionário trabalha

   // Construtor da classe Employee
   public Employee(String firstName, String lastName, 
      double salary, String department)
   {
      this.firstName = firstName;   // Inicializa o primeiro nome
      this.lastName = lastName;     // Inicializa o sobrenome
      this.salary = salary;         // Inicializa o salário
      this.department = department; // Inicializa o departamento
   } 

   // Define o primeiro nome
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   // Retorna o primeiro nome
   public String getFirstName()
   {
      return firstName;
   }

   // Define o sobrenome
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   // Retorna o sobrenome
   public String getLastName()
   {
      return lastName;
   }

   // Define o salário
   public void setSalary(double salary)
   {
      this.salary = salary;
   }

   // Retorna o salário
   public double getSalary()
   {
      return salary;
   }

   // Define o departamento
   public void setDepartment(String department)
   {
      this.department = department;
   }

   // Retorna o departamento
   public String getDepartment()
   {
      return department;
   }

   // Retorna o nome completo (primeiro nome e sobrenome) do funcionário
   public String getName()
   {
      return String.format("%s %s", getFirstName(), getLastName());
   }

   // Retorna uma String contendo as informações do funcionário
   @Override
   public String toString() 
   {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
   } // fim do método toString
} // fim da classe Employee