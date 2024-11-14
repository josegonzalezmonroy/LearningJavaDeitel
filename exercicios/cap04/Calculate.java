// Exercicio 4.6: Calculate.java
// Calcula a soma dos inteiros de 1 a 10
public class Calculate
{
    public static void main(String[] args)
    {
        int sum = 0;
        int x = 1;

        while (x <= 10) //enquanto x é menor ou igual a 10
        {
            sum += x;// adiciona a soma
            ++x; //incrementa x
        }

        System.out.printf("The sum is %d%n", sum);
    }
}//fim da classe Calculate 