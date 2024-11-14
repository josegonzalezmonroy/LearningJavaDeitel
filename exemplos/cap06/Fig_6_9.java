// Figura 6.9 - Scope.java
// A classe Scope demonstra os escopos de campo e de variável local

public class Fig_6_9 
{
    // campo acessível para todos os métodos dessa classe
    private static int x = 1;
    
    // O método main cria e inicializa a variável local x
    // e chama os métodos useLocalVariable e useField
    public static void main(String[] args) 
    {
        int x = 5; // variável local x do método sombreia o campo x
        
        System.out.printf("local x in main is %d%n", x);

        useLocalVariable(); // useLocalVariable tem uma variável local x
        useField(); // useField utiliza o campo x da classe Scope
        useLocalVariable(); // useLocalVariable reinicializa a variável local x
        useField(); // campo da classe Scope retém seu valor

        System.out.printf("local x in main is %d%n", x);
    }

    // cria e inicializa a variável local x durante cada chamada
    public static void useLocalVariable()
    {
        int x = 25; // inicializada toda vez que useLocalVariable é chamado

        System.out.printf(
            "%nlocal x on entering method useLocalVariable is %d%n", x);
        ++x; // modifica a variável local x desse método
        System.out.printf(
            "local before exiting method useLocalVariable is %d%n", x);
    }

    // modifica o campo x da classe Scope durante cada chamada
    public static void useField()
    {
        System.out.printf(
            "%nfield x on entering method useField is %d%n", x);
            x *= 10; // modifica o campo x da classe Scope
        System.out.printf(
            "field x before exiting method useField is %d%n", x);
    }
} // fim da classe Scope
