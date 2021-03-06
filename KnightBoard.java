import java.util.*;

public class KnightBoard{
  private int[][] board;
  private int[] coords;
  private int[][] moves;

  /**
  Initialize the board to the correct size and make them all 0's
  @throws IllegalArgumentException when either parameter is negative.
  */
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows <= 0 || startingCols <= 0) throw new IllegalArgumentException();
    // if the startingRows or startingCols is less than or equal to 0, throw IllegalStateException
    board = new int[startingRows][startingCols];
    // initialize board to given size
    coords = new int[] {-2, -1, -2, 1, -1, -2, -1, 2, 1, -2, 1, 2, 2, -1, 2, 1};
    // initialize coords to contain all 8 possible moves
    moves = new int[startingRows][startingCols];
    // initialize moves to given size
    fillMoves();
    // fill moves with the correct number of moves in each spot
  }

  private void fillMoves(){
    for (int i = 0; i < moves.length; i++){
      for (int j = 0; j < moves[i].length; j++){
        // for every place on the moves board
        if (i > 1 && i < moves.length - 2 && j > 1 && j < moves[i].length - 2){
          // if the place is two spots away from the edges of the board,
          moves[i][j] = 8;
          // set the number of moves to 8
        }
        else{
          int ans = 0;
          // starting number of moves is zero
          for (int x = 0; x < 16; x+=2){
            // for every possible move in the coords list
            i += coords[x];
            j += coords[x + 1];
            // add it to i and j
            if (!outOfBounds(i,j)){
              // if both i and j do not go out of bounds, add one to the number of moves
              ans++;
            }
            i -= coords[x];
            j -= coords[x + 1];
            // revert i and j back to original one
          }
          moves[i][j] = ans;
          // set the number of moves to ans
        }
      }
    }
  }

  public String toString(){
    String ans = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        int temp = board[i][j];
        if (temp == 0) ans += " _";
        // if there is no knight on that spot, add an underscore to the ans to hold the spot
        else if (temp < 10) ans += " " + temp;
        // else if the knight on the spot is less than ten
        // add a space and the number of the knight
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

  private int[] reorder(int row, int col){
    int[] ans = new int[moves[row][col]];
    int count = 0;
    for (int i = 0; i < coords.length; i+=2){
      int x = row + coords[i];
      int y = col + coords[i + 1];
      if (!outOfBounds(x,y) && moves[x][y] > 0 && board[x][y] == 0){
        ans[count] = i;
        count++;
      }
    }
    for (int i = 0; i < ans.length; i++){
      int smallest = ans[i];
      int index = i;
      for (int j = i; j < ans.length; j++){
        if (moves[row + coords[ans[j]]][col + coords[ans[j] + 1]] < moves[row + coords[smallest]][col + coords[smallest + 1]]){
          smallest = ans[j];
          index = j;
        }
      }
      ans[index] = ans[i];
      ans[i] = smallest;
    }
    return ans;
  }

  /**
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    if (outOfBounds(startingRow,startingCol)) throw new IllegalArgumentException();
    //if the parameters are out of bounds, throw IllegalArgumentException
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
    if (outOfBounds(startingRow,startingCol)) throw new IllegalArgumentException();
    //if the parameters are out of bounds, throw IllegalArgumentException
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0) throw new IllegalStateException();
        // if the values of the board are not zero, throw IllegalStateException
      }
    }
    int ans = calcH(startingRow, startingCol, 1);
    // ans is equal to result after calling helper
    return ans;
    // return ans
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

  private boolean outOfBounds(int row, int col){
    return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
  }

  private boolean solveH(int row ,int col, int level){
    if (level == board.length * board[0].length && board[row][col] == 0) {
      board[row][col] = level;
      return true;
    }
    if (outOfBounds(row,col)) {
      // if either the row or col is out of bounds, return false
      return false;
    }
    if (board[row][col] == 0){
      // if there is no knight at the given row and col
      int[] temp = reorder(row, col);
      for (int i = 0; i < temp.length; i++){
        moves[row + coords[temp[i]]][col + coords[temp[i] + 1]]--;
      }
      for (int i = 0; i < temp.length; i++){
        // for every one of the eight paths the knight can go
        board[row][col] = level;
        if (solveH(row + coords[temp[i]], col + coords[temp[i] + 1], level + 1)) return true;
        // if the successive knights works, return true
        board[row][col] = 0;
      }
      for (int i = 0; i < temp.length; i++){
        moves[row + coords[temp[i]]][col + coords[temp[i] + 1]]++;
      }
    }
    return false;
    // else return false
  }
  // level is the # of the knight

  private int calcH(int row ,int col, int level){
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      // if either the row or col is out of bounds, return 0
      return 0;
    }
    int ans = 0;
    if (board[row][col] == 0){
      // if there is no knight at the given row and col
      if (level == board.length * board[0].length) return 1;
      //if the knight is the last knight, return 1
      for (int i = 0; i < 16; i+=2){
        // else for every one of the eight paths the knight can go
        board[row][col] = level;
        ans += calcH(row + coords[i], col + coords[i + 1], level + 1);
        // add the number of ways from that path to the ans
        board[row][col] = 0;
        // reset it
      }
    }
    return ans;
  }

}
