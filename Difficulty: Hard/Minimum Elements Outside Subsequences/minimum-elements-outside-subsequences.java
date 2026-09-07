import java.util.Arrays;

class Solution {
    private int[][][] dp;

    public int minCount(int[] arr) {
        int n = arr.length;
        dp = new int[n][n + 1][n + 1];
        
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        int maxIncluded = solve(0, -1, -1, arr);
        return n - maxIncluded;
    }

    private int solve(int idx, int lastInc, int lastDec, int[] arr) {
        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][lastInc + 1][lastDec + 1] != -1) {
            return dp[idx][lastInc + 1][lastDec + 1];
        }

        int ans = solve(idx + 1, lastInc, lastDec, arr);

        if (lastInc == -1 || arr[idx] > arr[lastInc]) {
            ans = Math.max(ans, 1 + solve(idx + 1, idx, lastDec, arr));
        }

        if (lastDec == -1 || arr[idx] < arr[lastDec]) {
            ans = Math.max(ans, 1 + solve(idx + 1, lastInc, idx, arr));
        }

        return dp[idx][lastInc + 1][lastDec + 1] = ans;
    }
}