class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        
        int sum=0;
        for(int num: nums){
            if(mp.get(num)==1){
                sum+=num;
            }
        }
        return sum;
    }
}