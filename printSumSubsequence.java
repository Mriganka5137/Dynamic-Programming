import java.util.ArrayList;

public class printSumSubsequence {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 1 };
    int n = 3;
    int sum = 2;
    ArrayList<Integer> ds = new ArrayList<Integer>();

    // printSum(0, arr, ds, n, 0, sum);
    printSumOne(0, arr, ds, n, 0, sum);
  }

  private static void printSum(
    int i,
    int[] arr,
    ArrayList<Integer> ds,
    int n,
    int s,
    int sum
  ) {
    if (i == n) {
      if (sum == s) {
        for (Integer integer : ds) {
          System.out.print(integer + " ,");
        }
        System.out.println();
      }
      return;
    }

    s += arr[i];
    ds.add(arr[i]);
    printSum(i + 1, arr, ds, n, s, sum);

    s -= arr[i];
    ds.remove(ds.size() - 1);
    printSum(i + 1, arr, ds, n, s, sum);
    return;
  }

  private static boolean printSumOne(
    int i,
    int[] arr,
    ArrayList<Integer> ds,
    int n,
    int s,
    int sum
  ) {
    if (i == n) {
      if (s == sum) {
        for (Integer integer : ds) {
          System.out.print(integer + " ");
        }
        System.out.println();
        return true;
      }

      return false;
    }

    s += arr[i];
    ds.add(arr[i]);
    if (printSumOne(i + 1, arr, ds, n, s, sum) == true) {
      return true;
    }
    s -= arr[i];

    ds.remove(ds.size() - 1);
    if (printSumOne(i + 1, arr, ds, n, s, sum) == true) {
      return true;
    }
    return false;
  }
}
