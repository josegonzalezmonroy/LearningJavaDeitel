// Figura 18.11 - TowersOfHanoi.java
// Solucao do problema das torres de hani com um metodo recursivo
public class Fig_18_11
{
   // move recursivamente os discos entre as torres
   public static void solveTowers(int disks, int sourcePeg, 
      int destinationPeg, int tempPeg)
   {
      // caso basico -- somente um disco a ser movido
      if (disks == 1)
      {
         System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
         return;
      } 
      // passo recursivo -- move os discos (disco - 1) do sourcePeg
      // para tempPeg usando destinationPeg
      solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);

      // move o ultimo disco de sourcePeg para destinationPeg
      System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);

      // move (disks - 1) discos de tempPeg para destinationPeg
      solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);

   }

   public static void main(String[] args)
   {
      int startPeg = 1; // valor 1 utilizado para indicar startPeg na saida
      int endPeg = 3; // valor 3 utilizado para indicar endPeg na saida
      int tempPeg = 2; // valor 2 utilizado para indicar tempPeg na saida
      int totalDisks = 30; // numero de discos
      
      // chamada nao recursiva inicial: move todos os discos
      solveTowers(totalDisks, startPeg, endPeg, tempPeg);
   }
}