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
    // if the row * columns >= 10, default digits is "__" instead of "_"
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        int temp = board[i][j];
        if (temp == 0) ans += digits;
        // if there is no knight on that spot, add the default underscores to the ans
        else if (temp < 10 && digits.length() == 2) ans += "_" + temp;
        // else if the knight on the spot is less than ten but the row * columns has more than one digit,
        // add an underscore and the number of the knight
        else ans += temp;
        // else just add the number of the knight to the ans
        if (j != board[i].length - 1) ans += " ";
        // if it's not the last column on the row, add a space
        else ans += '\n';
        // else add '\n'
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
