// 7.12 - EnhancedForTest.java
// Utilizando a instrução for aprimorada para somar inteiros em um array

public class Fig_7_12 
{
    public static void main(String[] args) 
    {
        int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
        int total = 0;

        // adiciona o valor de cada elemento ao total
        for (int number : array)
            total += number;
        
        System.out.printf("Total of array elements: %d%n", total);
    }    
}
