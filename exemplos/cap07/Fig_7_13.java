// Figura 7.13 - PassArray.java
// Passando arrays e elementos do arrays individuais aos metodos

public class Fig_7_13 
{
    // main cria array e chama modifyArray e modifyElement
    public static void main(String[] args) 
    {
        int[] array = { 1, 2, 3, 4, 5 };
        
        System.out.printf(
            "Effects of passing reference to entire array:%n" + 
            "The values of the original array are:%n");

            // gera saída de elementos do array original
            for (int value : array)
                System.out.printf("   %d", value);
            
            modifyArray(array);// passa a referencia do array
            System.out.printf("%n%nThe values of the modified array are:%n");

            // gera saída de elementos do array modificado
            for (int value : array)
                System.out.printf("   %d", value);
            
            System.out.printf(
                "%n%nEffects of passing array element value:%n" + 
                "array[3] before modifyElement: %d%n", array[3]);

            modifyElement(array[3]);// tenta modificar o array[3]
            System.out.printf(
                "array[3] after modifyElement: %d%n", array[3]);
    }
    
    // multiplica cada elemento de um array por 2
    public static void modifyArray(int[] array2)
    {
        for (int counter = 0; counter < array2.length; counter++)
            array2[counter] *= 2;
    }

    // multiplica o argumento por 2
    public static void modifyElement(int element)
    {
        element *= 2;
        System.out.printf(
            "Value of element in modifyElement: %d%n", element);
    }
}// fim da classe PassArray
