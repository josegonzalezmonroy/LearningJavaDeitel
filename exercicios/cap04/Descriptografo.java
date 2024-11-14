public class Descriptografo 
{
    public static void main(String[] args) 
    {
        int number = 7802;
        int counter = 1;
        int chave = 7;

        int bernum = (number%100) * 100 + (number/100); // 8295
        int numberDesCrip = 0;

        while (counter < 10000) 
        {
            int n = (bernum % 10);

            if (n > 6 && n < 10)
                n = (n + 10 - chave) % 10 ; 
            else
                n = (n + 10 - chave);
            
            numberDesCrip += n * counter;

            bernum /= 10;
            counter *= 10;     
        }
    
        System.out.print(numberDesCrip);
    }
}
