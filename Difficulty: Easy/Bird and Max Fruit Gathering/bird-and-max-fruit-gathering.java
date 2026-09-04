class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n = arr.size();
        int sum = 0;
        
        for(int i =0; i<m;i++){
            sum += arr.get(i);
        }
        
        int max = sum;
        for(int i=1;i<n;i++){
            sum = sum - arr.get(i-1) + arr.get((i+m-1)%n);
            max = Math.max(max,sum);
        }
        return max;
    }
}