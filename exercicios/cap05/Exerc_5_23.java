// 5.22 - Leis de De Morgan
//      !(condicao1 && condicao2) = !condicao1 || !condicao2
//      !(condicao1 || condicao2) = !condicao1 && !condicao2
public class Exerc_5_23 
{
    public static void main(String[] args) 
    {
        int x = 6;
        int y = 6;
//                                     true         true
        System.out.println("a) " + ( !(x < 5) && !(y >= 7) )); //true
        System.out.println("a ) " + ( !(x < 5 || y >= 7) )); //true
        System.out.println();

        int a = 5;
        int b = 6;
        int g = 4;
//                                     true         false
        System.out.println("b) " + ( !(a == b) || !(g != 5) )); //true
        System.out.println("b ) " + ( !(a == b && g != 5) )); //true
        System.out.println();

//                                      true         true
        System.out.println("c) " + ( !((x <= 8) && (y > 4)) ));//false
        System.out.println("c ) " + ( !(x <= 8) || !(y > 4) ));//false
        System.out.println();

        int i = 5;
        int j = 5;     
//                                      true        true
        System.out.println("d) " + ( !((i > 4) || (j <= 6)) )); // false
        System.out.println("d ) " + ( !(i > 4) && !(j <= 6) )); // false
    }    
}
