class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int sum=0;

        // prefix : number of occurrance
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            sum=sum+num;
            if(sum==goal){
                count++;
            }

            if(freq.containsKey(sum-goal)){
                count = count+freq.get(sum-goal);
            }
            freq.put(sum, freq.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}