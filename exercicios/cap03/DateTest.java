import java.util.Scanner;

public class DateTest {

    public static void main(String[] args)
    {
        Date date = new Date(0, 0, 0);

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        int novoDia = input.nextInt();
        date.setDia(novoDia);

        System.out.print("Digite o mes: ");
        int novoMes = input.nextInt();
        date.setMes(novoMes);

        System.out.print("Digite o ano: ");
        int novoAno = input.nextInt();
        date.setAno(novoAno);

        System.out.print(date.displayDate());

    }
    
}
