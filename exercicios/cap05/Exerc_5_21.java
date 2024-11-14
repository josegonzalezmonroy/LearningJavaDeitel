// 5.21 - Triplos de pitagoras
// Um triangulo retangulo pode ter lados cujos comprimentos são todos inteiros. Escreva um aplicativo para exibir uma tabela dos triplos de pitagoras para side1, side2 e hypotenuse, todos não maiores que 500.

public class Exerc_5_21 
{
    public static void main(String[] args) 
    {
        // a² + b² = c²
        int side1;
        int side2;
        int hypotenuse;
        
        for (int c = 1; c <= 500; c++)//c
        {
            hypotenuse = c*c;

            for (int a = 1; a <= c; a++)//a
            {
                side1 = a*a;
                
                for (int b = 1; b <= c; b++)//b
                {
                    side2 = b*b;
                                        
                    if (side1+side2 == hypotenuse)
                    {  
                        System.out.printf("%d\u00B2 + %d\u00B2 = %d\u00B2\n", a, b, c);
                    }                    
                }
            }
        }
    }
}
