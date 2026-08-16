class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int countNeg = 0;
        int countZero = 0;
        int product = 1;

        for (int i = 0; i < n; i++) {
            
            int val = arr[i];
            if (val == 0) {
                countZero++;
                continue;
            }
            if (val < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, val);
            }
            else {
                minPos = Math.min(minPos, val);
            }
            product *= val;
            
        }

        if (countNeg == 0) {
            if (countZero > 0) return 0;
            return minPos;
        }

        if (countNeg % 2 == 0) {
            product /= maxNeg;
        }

        return product;
    }
}