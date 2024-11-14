// 9.10  - Escreva uma linha do código  
// Escreva uma linha do código que realiza cada uma das seguintes tarefas: a) Especifique que a classe PieceWorker e herdada da classe Employee. b) Chame o metodo toString da superclasse Employee a partir do metodo toString da subclasse PieceWorker. c) Chame o construtor da superclasse Employee a partir do construtor da subclasse PieceWorker — suponha que o construtor da superclasse receba três Strings que representam o primeiro nome, o sobrenome e o número de seguro social.
public class PieceWorker extends EmployeePre
{
    public PieceWorker(String nome, String sobrenome, double salario)
    {
        super(nome, sobrenome, salario);
    }

    @Override
    public String toString() 
    {
        // Retornar uma string formatada com detalhes adicionais e a representacao em string da superclasse
        return String.format("Detalhes adicionais do PieceWorker%n%s", super.toString());
    }
}
