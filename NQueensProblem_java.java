class NQueensProblem {
  static int NReines;
  static int[][] board;

  //méthode pour vérifier si la reine se trouve dans une position attaquée
  public static boolean isAttack(int row, int col) {
     //check in the same row
     for (int i = 0; i < col; i++)
        if (board[row][i] == 1)
           return true;

     //check upper diagonal on left side
     for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 1)
           return true;

     //check lower diagonal on left side
     for (int i = row, j = col; j >= 0 && i < NReines; i++, j--)
        if (board[i][j] == 1)
           return true;

     return false;
  }

  //fonction principale pour résoudre le problème N-reines
  public static boolean solveNQUtil(int col) {
     //base case: Si toutes les reines sont placées
     if (col == NReines) {
        return true;
     }

     //essayer de placer les reines sur toutes les lignes de la colonne en cours
     for (int i = 0; i < NReines; i++) {
        if (!isAttack(i, col)) {
           board[i][col] = 1;
           if (solveNQUtil(col + 1))
              return true;
           board[i][col] = 0; //backtracking
        }
     }
     return false;
  }

  public static void solveNQ() {
     if (solveNQUtil(0) == false) {
        System.out.println("Il n'y a pas de solution");
        return;
     }
     //afficher la solution
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
  }
}
