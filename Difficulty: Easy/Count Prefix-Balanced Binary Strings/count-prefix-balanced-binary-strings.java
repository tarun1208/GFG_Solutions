class Solution {
    public int prefixStrings(int n) {
        //code here
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - 1 - j]) % mod) % mod;
            }
        }

        return (int) dp[n];
    }
}