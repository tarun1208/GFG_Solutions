class Solution {
    public int countFriendsPairings(int n) {
        // code here
        if(n<=2) return n;
        
        int prev2 = 1;
        int prev1= 2;
        int sum = 0;
        
        // f(n) = f(n-1) + (n-1) * f(n-2)
        //prev2 = f(1)
        //prev1 = f(2)
        
        for(int i= 3; i<=n;i++){
            sum = prev1 + (i-1) * prev2;
            prev2 = prev1;
            prev1 = sum;
        }
        
        return sum;
    }
}
