// 5.29 - A canção "The Twelve Days of Christmas"
// Escreva um aplicativo qur utiliza instruções de repetição e switch para imprimir a canção "The Twelve Days of Christmas". Uma instrução switch deve ser utilizada para imprimir o dia ("primeiro", "segundo", etc.). Uma instrução switch separada deve ser utilizada para imprimir o restante de cada verso.

public class Exerc_5_29 
{
    public static void main(String[] args) 
    {
        String day = "";
        String first = "";
        String second = ""; 
        String third = "";
        String fourth = "";
        String fifth = "";
        String sixth = "";
        String seventh = "";
        String eighth = "";
        String ninth = "";
        String tenth = "";
        String eleventh = "";
        String twelfth = "";
        String end = "\nAnd a partridge in a pear tree.\n";
        
        for (int i = 1; i <= 12; i++)
        {
            switch (i) 
            {
                case 1:
                    day = "first";
                    first = "\nA partridge in a pear tree\n";
                    break;
                case 2:
                    day = "second";
                    second = "\nTwo turtle doves,";
                    break;
                case 3:
                    day = "third";
                    third = "\nThree French hens,";
                    break;
                case 4: 
                    day = "fourth";
                    fourth = "\nFour calling birds,";
                    break;
                case 5: 
                    day = "fifth";
                    fifth = "\nFive gold rings,";
                    break;
                case 6: 
                    day = "sixth";
                    sixth = "\nSix geese a-laying,";
                    break;
                case 7: 
                    day = "seventh";
                    seventh = "\nSeven swans a-swimming,";
                    break;
                case 8: 
                    day = "eighth";
                    eighth = "\nEight maids a-milking,";
                    break;
                case 9: 
                    day = "ninth";
                    ninth = "\nNine ladies dancing,";
                    break;
                case 10: 
                    day = "tenth";
                    tenth = "\nTen lords a-leaping,";
                    break;
                case 11: 
                    day = "eleventh";
                    eleventh = "\nEleven pipers piping,";
                    break;
                case 12: 
                    day = "twelfth";
                    twelfth = "\nTwelve drummers drumming,";
                    break;
            }
            System.out.printf("%nOn the %s day of Christmas my true love sent to me", day);

            if (i == 1) {
                System.out.printf("%s", first);
            }
            else
                System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s", twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, end);
        }    
    }
}
