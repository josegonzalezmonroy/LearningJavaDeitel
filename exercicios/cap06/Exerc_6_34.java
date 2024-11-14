// 6.38 - Tabela de numeros binarios, octais e hexadecimais
// Escreva um aplicativo que exibe uma tabela de equivalentes binários, octal e hexadecimal dos números decimais no intervalo 1 a 256. Se você não estiver familiarizado com esses sistemas numéricos, leia o apêndice J primeiro.
public class Exerc_6_34 
{
    public static void main(String[] args) 
    {
        System.out.printf("%-8s %-12s %-8s %-11s%n", "Decimal", "Binario", "Octal", "Hexadecimal");
        for (int number = 1; number <= 256; number++)
        {// imprime entre 1 e 256
            System.out.printf("%-8d %-12s %-8s %-11s%n", number, conversor(number, 2), conversor(number, 8), conversor(number, 16));
        }
    }
    
    public static String conversor(int x, int tipo)// x é o valor; y é o tipo (binario, octal ou hexadecimal)
    {
        String valor = "";
    
        while (x > 0) 
        {
            int resto = x % tipo;

            if (tipo == 16)// caso a conversao seja hexadecimal
            {
                switch (resto) // caso o resto seja entre 10 e 15
                {
                    case 10:
                        valor = "A" + valor;
                        break;
                    case 11:
                        valor = "B" + valor;
                        break;
                    case 12:
                        valor = "C" + valor;
                        break;                   
                    case 13:
                        valor = "D" + valor;
                        break;                   
                    case 14:
                        valor = "E" + valor;
                        break;                   
                    case 15:
                        valor = "F" + valor;
                        break;
                    default:
                        valor = resto + valor;
                        break;
                }
            }
            else                        
                valor = resto + valor;// caso o resto seja entre 0 e 9   
            
            x = x / tipo;         
        }
        return valor;
    }
}
