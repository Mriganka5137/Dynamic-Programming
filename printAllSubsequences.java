import java.util.ArrayList;

public class printAllSubsequences {

  private static void printSubsequences(
    int i,
    ArrayList<Integer> temp,
    int n,
    int[] arr
  ) {
    if (i == n) {
      for (Integer integer : temp) {
        System.out.print(integer + " ");
      }
      System.out.println();
      return;
    }

    temp.add(arr[i]);
    printSubsequences(i + 1, temp, n, arr);
    temp.remove(temp.size() - 1);

    printSubsequences(i + 1, temp, n, arr);
    return;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 1, 2 };
    int n = 3;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    printSubsequences(0, temp, n, arr);
  }
}
