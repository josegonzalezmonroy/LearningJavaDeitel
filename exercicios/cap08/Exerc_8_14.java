// 8.14 - Classe Data
/*
Crie uma classe Date com as seguintes capacidades:

    a) Gerar saída da data em múltiplos formatos, como

        MM/DD/YYYY
        June 14, 1992
        DDD YYYY
    
    b) Utilizar construtores sobrecarregados para criar objetos Date inicializados com datas dos formatos na parte (a). No primeiro caso, o construtor deve receber três valores inteiros. No segundo caso, deve receber uma String e dois valores inteiros. No terceiro caso, deve receber dois valores inteiros, o primeiro representando o número de dias no ano.

[Dica: para converter a representação de String do mês em um valor numérico, compare as Strings utilizando o método equals. Por exemplo, se s1 e s2 forem strings, a chamada de método s1.equals(s2) retornará true se as strings forem idênticas, caso contrário retornará false.]
*/
public class Exerc_8_14 
{
    public static void main(String[] args) 
    {
        Date2 date1 = new Date2(12, 31, 2024);
        Date2 date2 = new Date2("april", 30, 2023); 
        Date2 date3 = new Date2(60, 2024);
        System.out.println("Data 1:\n" + date1);
        System.out.println("\nData 2:\n" + date2);
        System.out.println("\nData 3:\n" + date3);        
    }
}

class Date2 
{
    private int month; 
    private int day;  
    private int year;
    private int dayOfYear;

    private static final int[] DAYSPERMONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static final String[] MONTHS = {
        "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    // Construtor para o formato MM/DD/YYYY
    public Date2(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
        this.dayOfYear = dayOfYear(month, day, year);
    }

    // Construtor para o formato "Month DD, YYYY"
    public Date2(String month, int day, int year)
    {
        this.month = monthStringToNumber(month);
        this.day = day;
        this.year = year;
        this.dayOfYear = dayOfYear(monthStringToNumber(month), day, year);
    }

    // Construtor para o formato DDD YYYY
    public Date2(int dayOfYear, int year)
    {
        this.month = daysToMonth(dayOfYear, year);
        this.day = daysToDay(dayOfYear, year);
        this.year = year;
        this.dayOfYear = dayOfYear;
    }

    // Converte dayOfYear para dia do mês
    public int daysToDay(int dayOfYear, int year)
    {
        int month = daysToMonth(dayOfYear, year);

        for (int i = 1; i < month; i++)
            if (i == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            {
                if (dayOfYear == 29) 
                    break;

                dayOfYear -= 29;
            }
            else
            {
                if (dayOfYear == DAYSPERMONTH[i]) 
                    break;

                dayOfYear -= DAYSPERMONTH[i];
            }
            
        return dayOfYear;
    }

    // Converte dayOfYear para mês
    public int daysToMonth(int dayOfYear, int year)
    {
        for (int i = 1; i < DAYSPERMONTH.length; i++)
            if (i == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            {
                if (dayOfYear <= 29)
                    return i;
                else
                    dayOfYear -= 29; 
            }
            else
            {
                if (dayOfYear <= DAYSPERMONTH[i])
                    return i;
                else 
                    dayOfYear -= DAYSPERMONTH[i];
            }
        
        return 0;
    }

    // Converte o nome do mês para número
    private int monthStringToNumber(String month)
    {
        String monthTittleCase = tittleCase(month);

        for (int i = 1; i < MONTHS.length; i++)
            if (monthTittleCase.equals(MONTHS[i]))
                return i;

        return 0;
    }

    // Converte a primeira letra do mês para maiúscula
    private String tittleCase(String input) 
    {
        if (input == null || input.isEmpty()) 
            return input;

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    // Calcula o dayOfYear a partir de mês, dia e ano
    public int dayOfYear(int month, int day, int year)
    {
        int dayOfYear = 0;

        for (int i = 1; i < month; i++)
            if (i == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
                dayOfYear += 29;
            else
                dayOfYear += DAYSPERMONTH[i];
        
        dayOfYear += day;

        return dayOfYear;
    }
    
    // Gera a saída da data em múltiplos formatos
    public String toString()
    {
        return String.format("%02d/%02d/%04d%n%s %02d, %04d%n%03d %04d", month, day, year, MONTHS[month], day, year, dayOfYear, year);
    }
}