// Figura 8.5 - Time2.java
// declaracao da classe Time2 com construtores sobrecarregados

public class Time2
{
    private int hour; // 0-23
    private int minute; // 0-59
    private int second; // 0-59
    
    // Construtor sem argumento Time2:
    // inicializa cada variavel de instancia para zero
    public Time2()
    {
        this(0, 0, 0);// invoca o construtor com tres argumentos
    }

    // Construtor Time2: hora fornecida, minuto e segundo padronizados para 0
    public Time2(int hour)
    {
        this(hour, 0, 0);// invoca o construtor com tres argumentos
    }

    // Construtor Time2: hora e minuto fornecidos, segundo padronizado para 0
    public Time2(int hour, int minute)
    {
        this(hour, minute, 0);// invoca o construtor com tres argumentos
    }

    // Construtor Time2: hour, minute e second fornecidos 
    public Time2(int hour, int minute, int second)
    {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Construtor Time2: outro objeto Time2 fornecido
    public Time2(Time2 time)
    {
        // invoca o construtor com tres argumentos
        this(time.getHour(), time.getMinute(), time.getSecond()); 
    }

    // Metodos set
    // Configura um novo valor de tempo usando hora universal
    // valida os dados
    public void setTime(int hour, int minute, int second)
    {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
        
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // valida e configura a hora 
    public void setHour(int hour)
    {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        
        this.hour = hour;
    }

    // valida e configura os minutos
    public void setMinute(int minute)
    {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        
        this.minute = minute;
    }

    // valida e configura os segundos
    public void setSecond(int second)
    {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");
        
        this.second = second;
    }

    // Metodos get
    // obtem o valor da hora
    public int getHour()
    {
        return hour;
    }

    // obtem o valor dos minutos
    public int getMinute()
    {
        return minute;
    }

    // obtem o valor dos segundos
    public int getSecond()
    {
        return second;
    }

    // converte em String no formato de data/hora universal (HH:MM:SS)
    public String toUniversalString()
    {
        return String.format(
            "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // converte em String no formato padrão de data/hora (HH:MM:SS AM ou PM)
    public String toString()
    {
        return String.format("%02d:%02d:%02d %s", 
            ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
            getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}// fim da classe Time2
