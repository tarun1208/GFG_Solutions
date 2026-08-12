class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int n = grid.length;
        int MOD = 1_000_000_007;

        int[][] ways = new int[n][n];
        int[][] maxAdv = new int[n][n];

        ways[0][0] = 1;
        maxAdv[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ways[i][j] == 0) continue;

                int val = grid[i][j];

                if ((val == 1 || val == 3) && j + 1 < n) {
                    ways[i][j + 1] = (ways[i][j + 1] + ways[i][j]) % MOD;
                    maxAdv[i][j + 1] = Math.max(maxAdv[i][j + 1], maxAdv[i][j] + grid[i][j + 1]);
                }

                if ((val == 2 || val == 3) && i + 1 < n) {
                    ways[i + 1][j] = (ways[i + 1][j] + ways[i][j]) % MOD;
                    maxAdv[i + 1][j] = Math.max(maxAdv[i + 1][j], maxAdv[i][j] + grid[i + 1][j]);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (ways[n - 1][n - 1] == 0) {
            result.add(0);
            result.add(0);
        } else {
            result.add(ways[n - 1][n - 1]);
            result.add(maxAdv[n - 1][n - 1]);
        }

        return result;
    }
}