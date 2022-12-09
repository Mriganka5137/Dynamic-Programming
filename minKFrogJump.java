import java.util.Arrays;

/**
 * minKFrogJump
 */
public class minKFrogJump {

  public static void main(String[] args) {
    int[] heights = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };
    int n = heights.length;
    int k = 4;

    int minJumps = frogJump(n, heights, k);
    System.out.println(minJumps);
  }

  public static int frogJump(int index, int[] heights, int k) {
    int[] dp = new int[index];
    Arrays.fill(dp, -1);
    // return frogJumpHelper(index - 1, heights, k, dp);

    return frogJumpTabulation(index, heights, k);
  }

  public static int frogJumpHelper(int index, int[] heights, int k, int[] dp) {
    if (index == 0) {
      return 0;
    }

    if (dp[index] != -1) return dp[index];

    int minSteps = Integer.MAX_VALUE;

    for (int j = 1; j <= k; j++) {
      if (index - j >= 0) {
        int jumps =
          frogJumpHelper(index - j, heights, k, dp) +
          Math.abs(heights[index] - heights[index - j]);
        minSteps = Math.min(minSteps, jumps);
      }
    }
    return dp[index] = minSteps;
  }

  public static int frogJumpTabulation(int index, int[] heights, int k) {
    int dp[] = new int[index];
    Arrays.fill(dp, -1);

    dp[0] = 0;
    for (int i = 1; i < index; i++) {
      int minSteps = Integer.MAX_VALUE;

      for (int j = 1; j <= k; j++) {
        if (i - j >= 0) {
          int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
          minSteps = Math.min(minSteps, jump);
        }
      }

      dp[i] = minSteps;
    }

    return dp[index - 1];
  }
}
