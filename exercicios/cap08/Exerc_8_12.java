// 8.12 - Classe DateAndTime 
// Crie uma classe DateAndTime que combina a classe Time2 modificada do Exercício 8.7 e a classe Date modificada do Exercício 8.8. Modifique o método incrementHour para chamar o método nextDay se a data/hora for incrementada para o próximo dia. Modifique métodos toString e toUniversalString para gerar uma saída da data além da hora. Escreva um programa para testar a nova classe DateAndTime. Especificamente, teste o incremento de tempo para o próximo dia.
public class Exerc_8_12 
{
    public static void main(String[] args) 
    {
        Time2 time = new Time2(23, 10, 10);// Cria uma instância de Time2 com hora, minuto e segundo específicos
        Date data = new Date(12, 31, 2000);// Cria uma instância de Date com mês, dia e ano específicos

        DateAndTime dateAndTime = new DateAndTime(time, data);// Cria uma instância de DateAndTime usando as instâncias de Time2 e Date

        System.out.println(dateAndTime);// Imprime a data e hora iniciais  

        for (int i = 1; i <= 25; i++)// Incrementa a hora 25 vezes e imprime a nova data e hora após cada incremento
        {
            dateAndTime.incrementHour();
            System.out.println(dateAndTime);
        }
    }
}

class DateAndTime
{
    private Time2 time;
    private Date date;

    public DateAndTime(Time2 time, Date date)// Construtor que inicializa DateAndTime com instâncias de Time2 e Date
    {
        this.time = time;
        this.date = date;
    }

    public void incrementHour()// Incrementa a hora e chama nextDay se a hora for 0 após o incremento
    {
        time.incrementHour();
        
        if (time.getHour() == 0)
            date.nextDay();
    }

    public String toString()// Retorna uma string representando a data e a hora

    {
        return String.format("%s - %s", date, time);
    }
}
