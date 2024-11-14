// Figura 7.18 - GradeBookBi.java
// Classe GradeBook utilizando um array bidimensional para armazenar notas de teste

public class GradeBookBi 
{
    private String courseName;// nome do curso que essa GradeBoo representa 
    private int students;
    private int tests;
    private int[][] grades;// array bidimensional de notas de aluno
    
    // construtor de tres argumentos inicializa courseName, students e tests
    public GradeBookBi(String courseName, int students, int tests)
    {
        this.courseName = courseName;
        this.students = students;
        this.tests = tests;

        grades = new int[students][tests];
        semNota(grades);
    }

    public void semNota(int[][] grades)// inicializa cada elemento com -1 
    {
        for (int i = 0; i < grades.length; i++)
            for (int j = 0; j < grades[i].length; j++)
                grades[i][j] = -1;
    }

    public void setGrade(int aluno, int test, int grade)// modifica uma nota por vez, por exame especifico e aluno particular
    {
        grades[aluno][test] = grade;
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

        // chama métodos getMinimum e getMaximum
        System.out.printf("%n%s %d%n%s %d%n%n", 
            "Lowest grade in the grade book is", getMinimum(), 
            "Highest grade in the grade book is", getMaximum());
        
        // chama outputBarChart para imprimir gráfico de distribuição de nota 
        outputBarChart();
    }

    // localiza nota mínima 
    public int getMinimum()
    {
        // supõe que grades[0][0] é a menor nota
        int lowGrade = grades[0][0]; 

        // faz um loop pelas linhas do array de notas
        for (int[] studentGrades : grades)
        {
            // faz um loop pelas colunas da limha atual
            for (int grade : studentGrades)
            {
                // se nota for mais baixa que lowGrade, atribui essa nota a lowGrade
                if (grade < lowGrade)
                lowGrade = grade;// nova nota mais baixa
            }
        }

        return lowGrade;
    }

    // localiza nota máxima
    public int getMaximum()
    {
        // supõe que grades[0][0] é a maior nota
        int highGrade = grades[0][0]; 

        // faz um loop pelas linhas do array de notas
        for (int[] studentGrades : grades)
        {
            // faz um loop pelas colunas da linha atual
            for (int grade : studentGrades)
            {
                // se nota for maior que highGrade, atribui essa nota a highGrade
                if (grade > highGrade)
                highGrade = grade;// nova nota mais alta
            }
        }

        return highGrade;
    }

    // determina media do conjunto particular de notas 
    public double getAverage(int[] setOfGrades)
    {
        int total = 0;

        // soma notas de um aluno
        for (int grade : setOfGrades)
            total += grade;
        
        // retorna a media de notas
        return (double) total / setOfGrades.length;
    }

    // gera a saída do gráfico de barras exibindo distribuição de notas
    public void outputBarChart()
    {
        System.out.println("Overall grade distribution:");

        // armazena frequencia de notas em cada intervalo de 10 notas
        int[] frequency = new int[11];

        // para cada nota, incrementa a frequencia apropriada
        for (int[] studentGrades : grades)
        {
            for (int grade : studentGrades)
                ++frequency[grade / 10];
        }
        
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
        System.out.print("            ");// alinha titulos de coluna

        // cria um titulo de coluna para cada um dos testes
        for (int test = 0; test < grades[0].length; test++)
            System.out.printf("Test %d  ", test + 1);
        
        System.out.println("Average");// titulo da coluna de media do aluno

        // cria linhas/ colunas de texto que representam notas de array
        for (int student = 0; student < grades.length; student++)
        {
            System.out.printf("Student %2d", student + 1);

            for (int test : grades[student])// gera saida de notas do aluno
                System.out.printf("%8d", test);
            
            // chama método getAverage para calcular a media do aluno
            // passa linha de notas como o argumento para getAverage
            double average = getAverage(grades[student]);
            System.out.printf("%9.2f%n", average);
        }
    }
}// fim da classe GradeBook
