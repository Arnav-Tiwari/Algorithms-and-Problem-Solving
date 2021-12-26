// Leetcode Problem 973: K Closest Point to origin
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue=new PriorityQueue<Point>(new SortQ());
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            long dist=x*x+y*y;
            Point p=new Point(x,y,dist);
            queue.offer(p);
        }
        while(queue.size()>k){
            queue.remove();}
        int [][]ans=new int[k][2];
        int index=0;
        while(!queue.isEmpty()){
            Point p=queue.poll();
            ans[index][0]=p.x;
            ans[index][1]=p.y;
            index++;
        }
        return ans;
    }   
    
 class Point{
        int x;
        int y;
        long dist;
        Point(int x,int y,long dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    class SortQ implements Comparator<Point>{
        public int compare(Point a,Point b){
            return (int)(b.dist-a.dist);
        }
    }
    
}
