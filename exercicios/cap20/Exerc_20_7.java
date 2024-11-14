// 20.7 - Método genérico isEqualTo
// Escreva uma versão genérica simples do método isEqualTo que compara seus dois argumentos com o método equals e retorna true se forem iguais e false caso contrário. Utilize esse método genérico em um programa que chama isEqualTo com uma variedade de tipos predefinidos, como Object ou Integer. Qual resultado você obtém ao tentar executar esse programa?

public class Exerc_20_7 
{
    public static void main(String[] args) 
    {
        System.out.printf("10 is equal to 10: %b%n", isEqualTo(10, 10)); // Integer
        System.out.printf("\"hello\" is equal to \"hello\": %b%n", isEqualTo("hello", "hello")); // String
        System.out.printf("5.5 is equal to 5.5: %b%n", isEqualTo(5.5, 5.5)); // Double
        System.out.printf("true is equal to false: %b%n", isEqualTo(true, false)); // Boolean
    }
    
    public static <T> boolean isEqualTo(T value1, T value2)
    {
        return value1.equals(value2);
    }
}
