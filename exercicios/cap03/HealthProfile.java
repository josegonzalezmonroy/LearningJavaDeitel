import java.time.LocalDate;
import java.time.Period;

public class HealthProfile 
{
    private String nome;
    private String sobrenome;
    private String sexo;
    private int dia;
    private int mes;
    private int ano;
    private double altura;
    private double peso;

    public HealthProfile(String nome, String sobrenome, String sexo, int dia, int mes, int ano, double altura, double peso)//construtor
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    public String getSexo()
    {
        if (sexo == "f")
            sexo =  "Femenino";
        if (sexo == "m")
            sexo = "Masculino";

        return sexo;
    }
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

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

    public double getAltura()
    {
        return altura;
    }
    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public double getPeso()
    {
        return peso;
    }
    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    // 1 - Idade
    public int idadeAnos()
    {
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

        Period periodo = Period.between(dataNascimento, dataHoje);

        return periodo.getYears();
    }

    // 2 - Frecuencia cardiaca maxima
    public int freCardiMax()
    {
        return 220 - idadeAnos();
    }

    // 3 - Frecuencia cardiaca alvo
    public double freCardiAlvoMin()
    {
        return freCardiMax() * 0.5;
    }
    public double freCardiAlvoMax()
    {
        return freCardiMax() * 0.85;
    }

    // 4 - Indice de massa corporal
    public double imc()
    {
        return peso / (altura*altura);
    }

}
