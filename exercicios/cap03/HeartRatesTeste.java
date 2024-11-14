import java.util.Scanner;

public class HeartRatesTeste {

    public static void main(String[] args)
    {
        HeartRates person = new HeartRates(null, null, 0, 0, 0);

        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o nome: ");
        String newName = input.nextLine();
        person.setNome(newName);

        System.out.print("Digite o sobrenome: ");
        String newSobrenome = input.nextLine();
        person.setSobrenome(newSobrenome);

        System.out.print("Dia de nascimento: ");
        int newDia = input.nextInt();
        person.setDia(newDia);

        System.out.print("Mes de nascimento: ");
        int newMes = input.nextInt();
        person.setMes(newMes);

        System.out.print("Ano de nascimento: ");
        int newAno = input.nextInt();
        person.setAno(newAno);

        System.out.println("");
        System.out.println("Nome: " + person.getNome() + " " + person.getSobrenome());
        System.out.println("Idade: " + person.idadeAnos());
        System.out.println("Frecuencia cardiaca maxima: " + person.freCardiMax());
        System.out.println("Frecuencia cardiaca alvo: " + person.freCardiAlvoMin() +" - "+ person.freCardiAlvoMax());
    }
    
}
