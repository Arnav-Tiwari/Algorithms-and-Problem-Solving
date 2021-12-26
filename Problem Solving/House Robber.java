//Leetcode Problem 198: House Robber
class Solution{
    public int rob(int []nums){
        int []dp=new int[nums.length];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[1],nums[0]+nums[2]);
        for(int i=0;i<nums.length;i++)
            dp[i]=nums[i];
        dp[nums.length-1]=nums[nums.length-1];
        dp[nums.length-2]=nums[nums.length-2];
        dp[nums.length-3]+=nums[nums.length-1];
        for(int i=nums.length-4;i>=0;i--){
            dp[i]+=Math.max(dp[i+2],dp[i+3]);
        }
        return Math.max(dp[0],dp[1]);
    }
}
