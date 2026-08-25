class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int maxConsecutive = 0;

        for (int x : arr) {
            dp[x] = dp[x - 1] + 1;
            maxConsecutive = Math.max(maxConsecutive, dp[x]);
        }

        return n - maxConsecutive;
    }
}