public class Date 
{
    private int month; // 1-12
    private int day; // 1-31 conforme o mes 
    private int year;// qualquer ano
    
    private static final int[] daysPerMonth = 
        { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    // construtor confirma o valor adequado para o mes e dia dado o ano
    public Date(int month, int day, int year)
    {
        // valida o ano
        if (year <= 0)
        throw new IllegalArgumentException(
            "year (" + year + ") must be greater than zero");

        //verifica se o mes esta no intervalo
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException(
                "month (" + month + ") must be 1-12");
        
        // veriica se day esta no intervalo para month
        if (day <= 0 ||
            (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + 
                ") out-of-range for the specified month and year");
        
        // verifique no ano bissexto se o mes e 2 e o dia e 29
        if (month == 2 && day == 29 && !(year % 400 == 0 || 
            (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + 
                ") out-of-range for the specified month and year");
    
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // incrementa +1 dia
    public void nextDay()
    {   
        day++;
        
        int days;// dias do mes
        if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            days = 29;// se o ano for bissexto
        else
            days = daysPerMonth[month];// senao

        if (day > days)
        {
            month++;
            if (month > 12)
            {
                year++;
                month = 1;
            }
            day = 1;
        }
    }

    // retorna uma string no formao mes/dia/ano
    public String toString()
    {
        return String.format("%02d/%02d/%d", month, day, year);
    }
}
