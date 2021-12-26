//Leetcode Problem 416:Partition Equal Subset Sum
class Solution{
    public boolean canPartition(int []nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        else
            return CheckPossible(nums,0,sum,sum/2,new HashMap<String,Boolean>());
    }
    public boolean CheckPossible(int []nums,int index,int sum,int halfsum,HashMap<String,Boolean> map){
        if(index>=nums.length)
            return false;
        if(sum==halfsum)
            return true;
        String key=sum+""+index;
        if(map.containsKey(key))
            return map.get(key);
        boolean ans=CheckPossible(nums,index+1,sum-nums[index],halfsum,map)||CheckPossible(nums,index+1,sum,halfsum,map);
        map.put(key,ans);
        return map.get(key);
    }
