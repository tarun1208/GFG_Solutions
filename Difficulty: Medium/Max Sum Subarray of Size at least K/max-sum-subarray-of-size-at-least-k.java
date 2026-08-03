class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int n = arr.length;
        int currSum = 0;
        for(int i=0;i<k;i++){
            currSum += arr[i];
        }
        
        int maxSum = currSum;
        int maxEnd = 0;
        
        for(int i=k; i<n; i++){
            currSum += arr[i] - arr[i-k];
            maxEnd = Math.max(0, maxEnd + arr[i-k]);
            
            if(currSum + maxEnd > maxSum){
                maxSum = currSum + maxEnd;
            }
        }
        return maxSum;
    }
}