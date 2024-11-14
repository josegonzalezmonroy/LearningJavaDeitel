public class Date 
{
    private int dia;
    private int mes;
    private int ano; 
    
    Date(int dia, int mes, int ano)
    {
        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }

    public void setDia(int dia)
    {
        this.dia = dia;
    }
    public int getDia()
    {
        return dia;
    }

    public void setMes(int mes)
    {
        this.mes = mes;
    }
    public int getMes()
    {
        return mes;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }
    public int getAno()
    {
        return ano;
    }

    public String displayDate()
    {
        String dataBarra = "Data: " + getDia() + "/" + getMes() + "/" + getAno();

        return dataBarra;
    }
}
