// Figura 7.14 - GradeBook.java
// Classe GradeBook utilizando um array para armazenar notas de teste

public class GradeBook 
{
    private String courseName;// nome do curso que essa GradeBoo representa 
    private int[] grades; // array de notas de aluno

    // construtor
    public GradeBook(String courseName, int[] grades)
    {
        this.courseName = courseName;
        this.grades = grades;
    }

    // metodo para configurar o nome do curso
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    // metodo para recuperar o nome do curso
    public String getCourseName()
    {
        return courseName;
    }

    // realiza várias operações nos dados 
    public void processGrades()
    {
        // gera saída de array de notas 
        outputGrades();

        // chama metodo getAverage para calcular a nota media
        System.out.printf("%nClass average is %.2f%n", getAverage());

        // chama métodos getMinimum e getMaximum
        System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n", 
            getMinimum(), getMaximum());
        
        // chama outputBarChart para imprimir gráfico de distribuição de nota 
        outputBarChart();
    }

    // localiza nota mínima 
    public int getMinimum()
    {
        int lowGrade = grades[0];// supõe que grades[0] é a menor nota 

        // faz um loop pelo array de notas
        for (int grade : grades)
        {
            // se nota for mais baixa que lowGrade, atribui essa nota a lowGrade
            if (grade < lowGrade)
                lowGrade = grade;// nova nota mais baixa
        }

        return lowGrade;
    }

    // localiza nota máxima
    public int getMaximum()
    {
        int highGrade = grades[0];// supõe que grades[0] é a maior nota 

        // faz um loop pelo array de notas
        for (int grade : grades)
        {
            // se nota for maior que highGrade, atribui essa nota a highGrade
            if (grade > highGrade)
                highGrade = grade;// nova nota mais alta
        }

        return highGrade;
    }

    // determina media para o teste 
    public double getAverage()
    {
        int total = 0;

        // soma notas de um aluno
        for (int grade : grades)
            total += grade;
        
        // retorna a media de notas
        return (double) total / grades.length;
    }

    // gera a saída do gráfico de barras exibindo distribuição de notas
    public void outputBarChart()
    {
        System.out.println("Grade distribution:");

        // armazena frequencia de notas em cada intervalo de 10 notas
        int[] frequency = new int[11];

        // para cada nota, incrementa a frequencia apropriada
        for (int grade : grades)
            ++frequency[grade / 10];
        
        // para cada frequencia de nota, imprime barra do grafico
        for (int count = 0; count < frequency.length; count++)
        {
            // gera saída do rótulo de barra ("00 - 09: ", ..., "90 - 99: ", "100: ")
            if (count == 10)
                System.out.printf("%5d: ", 100);
            else
                System.out.printf("%02d-%02d: ",
                    count * 10, count * 10 + 9);
            
            // imprime a barra de asteriscos
            for (int stars = 0; stars < frequency[count]; stars++)
                System.out.print("*");
            
            System.out.println();
        }
    }

    // gera a saída do conteúdo do array de notas
    public void outputGrades()
    {
        System.out.printf("The grades are: %n%n");

        // gera a saída da nota de cada aluno
        for (int student = 0; student < grades.length; student++)
            System.out.printf("Student %2d: %3d%n",
                student + 1, grades[student]);
    }
}// fim da classe GradeBook
