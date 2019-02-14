public class Driver{
  public static void main(String[] args) {
    KnightBoard a = new KnightBoard(1,1);
    int ans = 0;
    for (int i = 0; i < 1; i++){
      for (int j = 0; j < 1; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(2,2);
    ans = 0;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 2; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(3,3);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(4,4);
    ans = 0;
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(5,5);
    ans = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    System.out.println(a);

    System.out.println();

    a = new KnightBoard(3,10);
    ans = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 7; j++){
        ans += a.countSolutions(i,j);
      }
    }
    System.out.println(ans);
    a.solve(0,0);
    System.out.println(a);
  }
}
