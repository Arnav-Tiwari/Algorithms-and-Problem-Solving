//Leetcode Problem 56: Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int []> list=new ArrayList<>();
        int prevstart=intervals[0][0];
        int prevend=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=prevend){
                prevend=Math.max(prevend,intervals[i][1]);
            }
            else{
                list.add(new int[]{prevstart,prevend});
                prevstart=intervals[i][0];
                prevend=intervals[i][1];
            }
        }
        list.add(new int[]{prevstart,prevend});
    return list.toArray(new int[list.size()][]);
    }
}
