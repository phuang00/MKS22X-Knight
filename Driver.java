import java.util.*;

public class Driver{
  public static void main(String[] args) {
    KnightBoard a = new KnightBoard(1,1);
    int ans = 0;
    for (int i = 0; i < 1; i++){
      for (int j = 0; j < 1; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    boolean printed = false;
    for (int i = 0; i < 1; i++){
      for (int j = 0; j < 1; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(2,2);
    ans = 0;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 2; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 2; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(3,3);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(4,4);
    ans = 0;
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(5,5);
    ans = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);
    /*for (int i = 0; i < a.moves.length; i++){
      System.out.println(Arrays.toString(a.moves[i]));
    }*/

    System.out.println();

    a = new KnightBoard(3,4);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 4; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 4; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(3,7);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 7; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 7; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(3,9);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 9; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println("Number of Solutions: " + ans);
    printed = false;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 9; j++){
        if (!printed){
          if (a.solve(i,j) == true){
            printed = true;
          }
        }
      }
    }
    System.out.println("Has Solution: " + printed);
    System.out.println(a);
    /*for (int i = 0; i < a.moves.length; i++){
      System.out.println(Arrays.toString(a.moves[i]));
    }*/
  }
}
