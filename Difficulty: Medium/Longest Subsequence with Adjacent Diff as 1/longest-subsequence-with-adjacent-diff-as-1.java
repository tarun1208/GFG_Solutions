class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : arr) {
            int lenWithMinusOne = dp.getOrDefault(num - 1, 0);
            int lenWithPlusOne = dp.getOrDefault(num + 1, 0);

            int currentLen = 1 + Math.max(lenWithMinusOne, lenWithPlusOne);
            dp.put(num, currentLen);

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}