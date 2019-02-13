public class KnightBoard{
  private int[][] board;


  /*
  Initialize the board to the correct size and make them all 0's
  @throws IllegalArgumentException when either parameter is negative.
  */
  public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
  }

  public String toString(){
    String digits = "_";
    if (board.length * board[0].length > 10) digits = "__";
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (j != board[i].length - 1){
          if (board[i][j] == 0) ans += digits + " ";
          else;
        }
        else{
          if (board[i][j] == 0) ans += digits + "\n";
        }
      }
    }
    return ans;
  }

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    return false;
  }

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public int countSolutions(int startingRow, int startingCol){
    return 0;
  }


  private boolean solveH(int row ,int col, int level){
    return false;
  }
  // level is the # of the knight
}
