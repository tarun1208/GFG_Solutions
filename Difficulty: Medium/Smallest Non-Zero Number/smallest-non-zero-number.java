class Solution {
    public int find(int[] arr) {
        // code here
     long req = 0;
     for(int i=arr.length-1;i>=0;i--){
         req = (req+arr[i]+1)/2;
     }
     return (int) req;
    }
}
