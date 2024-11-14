// Figura 8.15 - PackageDataTest.java
// Membros de acesso de pacote de uma classe permanecem acessiveis a outras classes 
// no mesmo pacote

public class Fig_8_15 
{
    public static void main(String[] args) 
    {
        PackageData packageData = new PackageData();

        // gera saida da representação String de packageData
        System.out.printf("After instantiation: %n%s%n", packageData);

        // muda os dados de acesso de pacote no objeto packageData
        packageData.number = 77;
        packageData.string = "Goodbye";

        // gera saida da representação String de packageData
        System.out.printf("After changing values: %n%s%n", packageData);
    }    
}// fim da classe PackageDataTest

// classe com variaveis de instancia de acesso de pacote 
class PackageData
{
    int number; // variavel de instancia de acesso de pacote 
    String string; // variavel de instancia de acesso de pacote

    // construtor
    public PackageData()
    {
        number = 0;
        string = "Hello";
    }

    // retorna a representação String do objeto PackageData
    public String toString()
    {
        return String.format("number: %d; string: %s", number, string);
    }
}// fim da classe PackageData
