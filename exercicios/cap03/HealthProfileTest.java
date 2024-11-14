public class HealthProfileTest {
    
    public static void main(String[] args)
    {
        HealthProfile pessoa = new HealthProfile("Jazmin", "Pinto", "f", 20, 06, 1994, 1.58, 62);

        //Dados da pessoa

        // 1 - Nome completo
        System.out.println("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome());

        // 2 - Sexo
        System.out.println("Sexo: " + pessoa.getSexo());

        // 3 - Data de nascimento
        System.out.println("Data de nascimento: " + pessoa.getDia() + "/" + pessoa.getMes() + "/" + pessoa.getAno());

        // 4 - Altura
        System.out.println("Altura: " + pessoa.getAltura() + " metros");

        // 5 - Peso
        System.out.println("Peso: " + pessoa.getPeso() + " quilos");

        // 6 - Idade em anos
        System.out.println("Idade: " + pessoa.idadeAnos() + " anos");

        // 7 - IMC
        String resultIMC = "";

        if (pessoa.imc() < 18.5)
            resultIMC = "baixo peso";
        if (pessoa.imc() >= 18.5 && pessoa.imc() < 25)
            resultIMC = "normal";
        if (pessoa.imc() >= 25 && pessoa.imc() < 30)
            resultIMC = "sobrepeso";
        if (pessoa.imc() > 30)
            resultIMC = "sobrepeso";
        
        System.out.printf("IMC: %.2f - %s%n", pessoa.imc(), resultIMC);        
        
        // 8 - Frecuencia cardiaca maxima
        System.out.println("Frecuencia cardiaca maxima: " + pessoa.freCardiMax());
        
        // 9 - Frecuencia cardiaca alvo
        System.out.println("Frecuencia cardiaca alvo: " + pessoa.freCardiAlvoMin() + " - " + pessoa.freCardiAlvoMax());
    }// fim da classe main
}
