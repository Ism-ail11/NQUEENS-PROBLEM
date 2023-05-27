import java.util.concurrent.CountDownLatch;

class NQueensProblem {
   static int NReines;
   static int[][] board;
   static CountDownLatch latch;

  // Méthode pour vérifier si la reine est en position attaquée

   public static boolean isAttack(int row, int col) {
      // Check in the same row
      for (int i = 0; i < col; i++)
         if (board[row][i] == 1)
            return true;

// Vérifier la diagonale supérieure du côté gauche

      for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
         if (board[i][j] == 1)
            return true;

// Vérifier la diagonale inférieure du côté gauche

      for (int i = row, j = col; j >= 0 && i < NReines; i++, j--)
         if (board[i][j] == 1)
            return true;

      return false;
   }

// Fonction principale pour résoudre le problème des N-Queens

   public static class SolverThread extends Thread {
      int col;
      public SolverThread(int col) {
         this.col = col;
      }

      public void run() {
// Essaie de placer des reines dans toutes les lignes de la colonne courante

         for (int i = 0; i < NReines; i++) {
            if (!isAttack(i, col)) {
               board[i][col] = 1;
               if (solveNQUtil(col + 1)) {
                  latch.countDown();
                  return;
               }
               board[i][col] = 0; // Backtracking
            }
         }
      }
   }

   public static boolean solveNQUtil(int col) {
// Cas de base : si toutes les reines sont placées

      if (col == NReines) {
         return true;
      }

// Cas de base : si toutes les reines sont placées

      SolverThread[] threads = new SolverThread[NReines];
      latch = new CountDownLatch(NReines);
      for (int i = 0; i < NReines; i++) {
         threads[i] = new SolverThread(col);
         threads[i].start();
      }

// Attend la fin de tous les threads

      try {
         latch.await();
      } catch (InterruptedException e) {
         System.out.println("InterruptedException caught");
      }

      return true;
   }

   public static void solveNQ() {
      if (solveNQUtil(0) == false) {
         System.out.println("No solution exists");
         return;
      }

 // Imprimer la solution

      for (int i = 0; i < NReines; i++) {
         for (int j = 0; j < NReines; j++)
            System.out.print(" " + board[i][j] + " ");
         System.out.println();
      }
   }
   
      public static void main(String[] args) {
        NReines = 4;
        board = new int[NReines][NReines];
        solveNQ();
     }}
  
  