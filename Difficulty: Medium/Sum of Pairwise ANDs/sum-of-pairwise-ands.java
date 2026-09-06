class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        long sum = 0;
        
        for(int i=0;i<32;i++){
            long count = 0;
            for(int num : arr){
                if((num & (1<<i)) != 0){
                    count++;
                }
            }
            
            long pair = (count * (count-1))/2;
            sum += pair* (1L<<i);
        }
        return sum;
    }
}