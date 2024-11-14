// 9.10  - Escreva uma linha do código  
// Escreva uma linha do código que realiza cada uma das seguintes tarefas: a) Especifique que a classe PieceWorker e herdada da classe Employee. b) Chame o metodo toString da superclasse Employee a partir do metodo toString da subclasse PieceWorker. c) Chame o construtor da superclasse Employee a partir do construtor da subclasse PieceWorker — suponha que o construtor da superclasse receba três Strings que representam o primeiro nome, o sobrenome e o número de seguro social.

public class Exerc_9_10 
{
    public static void main(String[] args) 
    {
        // Criar um objeto PieceWorker
        PieceWorker funcionario = new PieceWorker("Juan", "Perez", 3000.0);

        // Imprimir o resultado de toString
        System.out.println(funcionario.toString());
    }
}
