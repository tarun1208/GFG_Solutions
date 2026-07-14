class Solution {
    public int countSubarray(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int val:arr){
            if(val == 0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(sum==0){
                count++;
            }
            if(hm.containsKey(sum)){
                count += hm.get(sum);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}