// 8.7 - Aprimorando a classe Time2
/* Modifique a classe Time2 da Figura 8.5 para incluir um método tick que incrementa a data/hora armazenada em um objeto Time2 em um segundo. Forneça um método incrementMinute para incrementar o minuto por um e o método incrementHour para incrementar a hora por uma. Escreva um programa que testa o método tick, o método incrementMinute e o método incrementHour para assegurar que eles funcionam corretamente. Certifique-se de testar os seguintes casos:

a) incrementar para o próximo minuto,

b) incrementar para a próxima hora e

c) incrementar para o próximo dia (isto é, 11:59:59 PM para 12:00:00 AM).
*/
public class Exerc_8_7 
{
    public static void main(String[] args) 
    {
        Time2 time = new Time2(23,45,59);// hora inicial

        System.out.println("Hora inicial: " + time);// imprimindo hora padrao

        time.tick();
        time.incrementMinute();
        time.incrementHour();

        System.out.println("Hora modificada: " + time);// imprimindo hora padrao

    }
}

