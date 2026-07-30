class Solution {
    public int maxSubsetXOR(int[] arr) {
        // code here
        int maxBits = 20;
        int[] basis = new int[maxBits];
        
        for (int num : arr) {
            for (int i = maxBits - 1; i >= 0; i--) {
                if (((num >> i) & 1) == 0) {
                    continue;
                }

                if (basis[i] == 0) {
                    basis[i] = num;
                    break;
                }

                num ^= basis[i];
            }
        }
        
        int maxXor = 0;
        for (int i = maxBits - 1; i >= 0; i--) {
            if ((maxXor ^ basis[i]) > maxXor) {
                maxXor ^= basis[i];
            }
        }
        
        return maxXor;
    }
}