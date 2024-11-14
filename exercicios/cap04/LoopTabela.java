public class LoopTabela {
    public static void main(String[] args) {
        
        int counter = 1;
        
        System.out.print("N   10*N   100*N   1000*N\n\n");

        while (counter <= 5) {
            
            System.out.printf("%d   %d     %d     %d%n", counter, counter*10, counter*100, counter*1000);
            counter++;
        }
    }
}
