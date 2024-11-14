// 7.39 - GradeBook avançada
// Modifique a classe GradeBook da Figura 7.18 para que o construtor aceite como parâmetros o número de alunos e o número de exames e, então, construa um array bidimensional de tamanho adequado, em vez de receber um array bidimensio nal pré-inicializado como ele faz agora. Defina cada elemento do novo array bidimensional como -1 para indicar que nenhuma nota fol inserida para esse elemento. Adicione um método setGrade que defina uma nota para um aluno especifico em um exame particular. Modifique a classe GradeBookTest da Figura 7.19 para inserir o número de alunos e o número de exames para GradeBook e para permitir que o instrutor insira uma nota de cada vez.
import java.util.Scanner;

public class Exerc_7_39
{
    // metodo main inicia a execução de programa
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite");
        System.out.print("Nome do curso: ");
        String nome = input.nextLine().toUpperCase();// nome do curso

        System.out.print("Numero de estudantes: ");
        int estudantes = input.nextInt();// numero de estudantes

        System.out.print("Numero de exames: ");
        int exames = input.nextInt();// numero de exames
            
        GradeBookBi myGradeBook = new GradeBookBi(nome, estudantes, exames);// inicializa o objeto

        System.out.printf("%nWelcome to the grade book for%n%s%n%n", myGradeBook.getCourseName());
        
        System.out.println("Insira as notas dos alunos:\n---------------------------");

        // pede para o usuario inserir nota de cada aluno e exame
        for (int i = 0; i < estudantes; i++)
        {
            System.out.printf("ALUNO %02d%n", i + 1);
            for (int j = 0; j < exames; j++)
            {
                System.out.printf("Exame %02d ", j + 1);
                int grade = input.nextInt();

                myGradeBook.setGrade(i, j, grade);
            }
            System.out.println("------------");
        }
    
        // imprime os resultados
        myGradeBook.processGrades();
    }
}
