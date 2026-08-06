class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int num : arr) {
            int countDoubles = 0;
            
            while (num > 0) {
                if ((num & 1) == 1) {
                    totalIncrements++;
                }
                num >>= 1;
                if (num > 0) {
                    countDoubles++;
                }
            }
            
            maxDoubles = Math.max(maxDoubles, countDoubles);
        }

        return totalIncrements + maxDoubles;
    }
}