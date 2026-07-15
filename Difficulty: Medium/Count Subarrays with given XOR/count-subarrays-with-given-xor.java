class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        int xor = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0,1);
        
        for(int num : arr){
            xor = xor^num;
            if(map.containsKey(xor ^ k)){
                count += map.get(xor^k);
            }
            map.put(xor, map.getOrDefault(xor,0)+1);
        }
        
        return (long)count;
    }
}