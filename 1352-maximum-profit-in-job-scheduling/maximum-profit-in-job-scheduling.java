class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n= startTime.length;

        int[][] jobs = new int[n][3];
         
        for(int i =0;i<n;i++){
           jobs[i][0] =  startTime[i];
           jobs[i][1] = endTime[i];
           jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs,(a,b)->a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int max = Integer.MIN_VALUE;
                int best = 0;

        for(int[] job : jobs){
            int start = job[0];
            int end = job[1];
            int pro = job[2];
            while(!queue.isEmpty() && queue.peek()[0] <= start){
                int[] curr = queue.poll(); 
                best = Math.max(best ,  curr[1]);
            }
            int totalProfit = best + pro;
            queue.offer(new int[]{end , totalProfit});
            max = Math.max(totalProfit , max);
           
        }
        return max;
    }
}