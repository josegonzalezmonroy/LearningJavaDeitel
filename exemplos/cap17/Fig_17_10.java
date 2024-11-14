// Fig. 17.10: ProcessingEmployees.java
// Processamento de fluxos (streams) de objetos Employee.
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Fig_17_10 
{
   public static void main(String[] args)
   {
      // inicializa array de Employees (Funcionários)
      Employee[] employees = {
         new Employee("Jason", "Red", 5000, "IT"),
         new Employee("Ashley", "Green", 7600, "IT"),
         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
         new Employee("James", "Indigo", 4700.77, "Marketing"),
         new Employee("Luke", "Indigo", 6200, "IT"),
         new Employee("Jason", "Blue", 3200, "Sales"),
         new Employee("Wendy", "Brown", 4236.4, "Marketing")};

      // obtém uma visualização em List dos Employees
      List<Employee> list = Arrays.asList(employees);

      // exibe todos os Employees
      System.out.println("Lista completa de funcionários:");
      list.stream().forEach(System.out::println);
      
      // Predicate que retorna true para salários no intervalo $4000-$6000
      Predicate<Employee> fourToSixThousand = 
         e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

      // Exibe os Employees com salários no intervalo $4000-$6000
      // ordenados em ordem crescente de salário
      System.out.printf(
         "%nFuncionários que ganham entre $4000 e $6000 por mês, ordenados por salário:%n");
      list.stream()
          .filter(fourToSixThousand)
          .sorted(Comparator.comparing(Employee::getSalary))
          .forEach(System.out::println);

      // Exibe o primeiro Employee com salário no intervalo $4000-$6000
      System.out.printf("%nPrimeiro funcionário que ganha entre $4000 e $6000:%n%s%n",
         list.stream()
             .filter(fourToSixThousand)
             .findFirst()
             .get());

      // Funções para obter o primeiro e último nome de um Employee
      Function<Employee, String> byFirstName = Employee::getFirstName;
      Function<Employee, String> byLastName = Employee::getLastName;

      // Comparator para comparar Employees pelo último nome e depois pelo primeiro nome
      Comparator<Employee> lastThenFirst = 
         Comparator.comparing(byLastName).thenComparing(byFirstName);

      // ordena os employees por último nome, depois por primeiro nome
      System.out.printf(
         "%nFuncionários em ordem crescente por último nome e depois pelo primeiro:%n");
      list.stream()
          .sorted(lastThenFirst)
          .forEach(System.out::println);

      // ordena os employees em ordem decrescente por último nome, depois pelo primeiro nome
      System.out.printf(
         "%nFuncionários em ordem decrescente por último nome e depois pelo primeiro:%n");
      list.stream()
          .sorted(lastThenFirst.reversed())
          .forEach(System.out::println);

      // exibe sobrenomes únicos dos employees, ordenados
      System.out.printf("%nSobrenomes únicos dos funcionários:%n");
      list.stream()
          .map(Employee::getLastName)
          .distinct()
          .sorted()
          .forEach(System.out::println);

      // exibe apenas os primeiros e últimos nomes
      System.out.printf(
         "%nNomes dos funcionários em ordem de último nome e depois primeiro nome:%n"); 
      list.stream()
          .sorted(lastThenFirst)
          .map(Employee::getName)
          .forEach(System.out::println);

      // agrupa os Employees por departamento
      System.out.printf("%nFuncionários por departamento:%n"); 
      Map<String, List<Employee>> groupedByDepartment =
         list.stream()
             .collect(Collectors.groupingBy(Employee::getDepartment));
      groupedByDepartment.forEach(
         (department, employeesInDepartment) -> 
         {
            System.out.println(department);
            employeesInDepartment.forEach(
               employee -> System.out.printf("   %s%n", employee));
         }
      );

      // conta o número de Employees em cada departamento
      System.out.printf("%nContagem de funcionários por departamento:%n"); 
      Map<String, Long> employeeCountByDepartment =
         list.stream()
             .collect(Collectors.groupingBy(Employee::getDepartment, 
                Collectors.counting()));
      employeeCountByDepartment.forEach(
         (department, count) -> System.out.printf(
            "%s tem %d funcionário(s)%n", department, count));

      // soma dos salários dos Employees com o método sum de DoubleStream
      System.out.printf(
         "%nSoma dos salários dos funcionários (via método sum): %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)
             .sum());

      // calcula a soma dos salários dos Employees com o método reduce de Stream
      System.out.printf(
         "Soma dos salários dos funcionários (via método reduce): %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)
             .reduce(0, (value1, value2) -> value1 + value2));  

      // média dos salários dos Employees com o método average de DoubleStream
      System.out.printf("Média dos salários dos funcionários: %.2f%n",
         list.stream()
             .mapToDouble(Employee::getSalary)
             .average()
             .getAsDouble());      
   } // fim de main
}
