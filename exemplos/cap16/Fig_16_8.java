// Figura 16.8 - TimeComparator.java
// Classe Comparator personalizada que compara dois ojetos Time2
import java.util.Comparator;

public class Fig_16_8 implements Comparator<Time2> 
{
    @Override
    public int compare(Time2 time1, Time2 time2)
    {
        int hourDifference = time1.getHour() - time2.getHour();

        if (hourDifference != 0)// testa a primeira hora
            return hourDifference;
        
        int minuteDifference = time1.getMinute() - time2.getMinute();

        if (minuteDifference != 0)// entao testa o minuto
            return minuteDifference;

        int secondDifference = time1.getSecond() - time2.getSecond();
        return secondDifference;
    }
}// fim da classe TimeComparator
