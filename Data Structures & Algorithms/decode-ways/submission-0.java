class Solution {
    //dp[i] = answer for dfs(i)
    //dp[2] = 1 There is 1 way to decode the string starting at index 2.
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];

        Arrays.fill(dp , -1);

        //Number of ways to decode the string starting from index 0.
        return decode(s , 0);   
    }

    //2nd Recursion + Memoization
    private int decode(String s , int index) {

        if(index == s.length())
            return 1;
        
        if(s.charAt(index) == '0')
            return 0;

        if(dp[index] != -1)
            return dp[index];

        //take single digit
        int ways = decode(s , index+1);

        //take double digit
        if(index+1 < s.length()) {
            int num = Integer.parseInt(s.substring(index , index+2));
            if(num >= 10 && num <= 26)
                ways = ways + decode(s , index+2);
        }

    return dp[index] = ways;

    }

    //1st Recursion
    /*private int decode(String s , int index) {

        if(index == s.length())
            return 1;
        
        if(s.charAt(index) == '0')
            return 0;

        //take single digit
        int ways = decode(s , index+1);

        //take double digit
        if(index+1 < s.length()) {
            int num = Integer.parseInt(s.substring(index , index+2));
            if(num >= 10 && num <= 26)
                ways = ways + decode(s , index+2);
        }

    return ways;

    }
    */
}
/*
For recursive solution
| Complexity | Answer   |
| ---------- | -------- |
| **Time**   | `O(2^n)` |
| **Space**  | `O(n)`   |

Not similar to pick and not pick pattern

             position i
                 |
          ┌──────┴──────┐
          ↓             ↓
       TAKE 1         TAKE 2
          |             |
       i + 1          i + 2

*/