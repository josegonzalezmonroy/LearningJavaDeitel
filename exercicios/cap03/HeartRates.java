import java.time.LocalDate;
import java.time.Period;

public class HeartRates 
{
    private String nome;
    private String sobrenome;
    private int dia;
    private int mes;
    private int ano;
    
    public HeartRates(String nome, String sobrenome, int ano, int mes, int dia) //construtor
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    //nome
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    //sobrenome
    public String getSobrenome()
    {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    //Data de nascimento
    public int getDia()
    {
        return dia;
    }
    public void setDia(int dia)
    {
        this.dia = dia;
    }

    public int getMes()
    {
        return mes;
    }
    public void setMes(int mes)
    {
        this.mes = mes;
    }

    public int getAno()
    {
        return ano;
    }
    public void setAno(int ano)
    {
        this.ano = ano;
    }

    //Idade
    public int idadeAnos()
    {
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

        Period periodo = Period.between(dataNascimento, dataHoje);

        return periodo.getYears();
    }

    public int freCardiMax()
    {
        return 220 - idadeAnos();
    }
    public double freCardiAlvoMin()
    {
        return freCardiMax() * 0.5;
    }
    public double freCardiAlvoMax()
    {
        return freCardiMax() * 0.85;
    }
}
