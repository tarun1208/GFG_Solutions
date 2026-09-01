class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long totalCount = 0;

        for (int len = 1; len <= n; len++) {
            int m = len / 2;
            int distinctNeeded = (len % 2 == 1) ? m + 1 : m;

            if (distinctNeeded > k) {
                continue;
            }

            long ways = 1;
            for (int i = 0; i < distinctNeeded; i++) {
                ways = (ways * (k - i)) % MOD;
            }

            totalCount = (totalCount + ways) % MOD;
        }

        return (int) totalCount;
    }
}