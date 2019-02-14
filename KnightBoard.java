public class KnightBoard{
  private int[][] board;


  /**
  Initialize the board to the correct size and make them all 0's
  @throws IllegalArgumentException when either parameter is negative.
  */
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows <= 0 || startingCols <= 0) throw new IllegalArgumentException();
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

  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    if (startingRow < 0 ||
        startingCol < 0 ||
        startingRow >= board.length ||
        startingCol >= board[0].length) throw new IllegalArgumentException();
    //if the parameters are negative or out of bounds, throw IllegalArgumentException
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0) throw new IllegalStateException();
        // if the values of the board are not zero, throw IllegalStateException
      }
    }
    return solveH(startingRow, startingCol, 1);
    // call helper function
  }

  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public int countSolutions(int startingRow, int startingCol){
    if (startingRow < 0 ||
        startingCol < 0 ||
        startingRow >= board.length ||
        startingCol >= board[0].length) throw new IllegalArgumentException();
    //if the parameters are negative or out of bounds, throw IllegalArgumentException
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0) throw new IllegalStateException();
        // if the values of the board are not zero, throw IllegalStateException
      }
    }
    int ans = calcH(startingRow, startingCol, 1);
    remove(-1);
    return ans;
    // call helper function
  }

  /** Removes all knights on the board higher than the given number
  */
  private void remove(int level){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        // loop through whole board
        if (board[i][j] > level) board[i][j] = 0;
        // if the number at the current position is greater than level, set it to zero
      }
    }
  }


  private boolean solveH(int row ,int col, int level){
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      // if the row or col are out of bounds, return false
      return false;
    }
    boolean ans = false;
    // default ans is false
    if (board[row][col] == 0){
      // if there is no knight at the given row and col
      board[row][col] = level;
      // set the spot to the level number
      if (level == board.length * board[0].length) return true;
      // if the level is the last knight to be put on the board, return true
      if (solveH(row - 2, col + 1, level + 1)) return true;
      remove(level);
      if (solveH(row - 2, col - 1, level + 1)) return true;
      remove(level);
      if (solveH(row - 1, col + 2, level + 1)) return true;
      remove(level);
      if (solveH(row - 1, col - 2, level + 1)) return true;
      remove(level);
      if (solveH(row + 1, col + 2, level + 1)) return true;
      remove(level);
      if (solveH(row + 1, col - 2, level + 1)) return true;
      remove(level);
      if (solveH(row + 2, col + 1, level + 1)) return true;
      remove(level);
      if (solveH(row + 2, col - 1, level + 1)) return true;
      remove(level);
      // run through all 8 possible directions the knight can go to next and if that works, return true
    }
    if (!ans) remove(level - 1);
    //if there is already a number on the spot, remove all knights greater than level - 1
    return ans;
  }
  // level is the # of the knight

  private int calcH(int row ,int col, int level){
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      return 0;
    }
    int ans = 0;
    if (board[row][col] == 0){
      board[row][col] = level;
      if (level == board.length * board[0].length) return 1;
      ans += calcH(row - 2, col + 1, level + 1);
      remove(level);
      ans += calcH(row - 2, col - 1, level + 1);
      remove(level);
      ans += calcH(row - 1, col + 2, level + 1);
      remove(level);
      ans += calcH(row - 1, col - 2, level + 1);
      remove(level);
      ans += calcH(row + 1, col + 2, level + 1);
      remove(level);
      ans += calcH(row + 1, col - 2, level + 1);
      remove(level);
      ans += calcH(row + 2, col + 1, level + 1);
      remove(level);
      ans += calcH(row + 2, col - 1, level + 1);
      remove(level);
    }
    return ans;
  }
}
