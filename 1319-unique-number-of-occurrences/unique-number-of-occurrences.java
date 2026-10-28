class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> result=new HashMap<>();
        for(int nums: arr){
            result.put(nums, result.getOrDefault(nums, 0)+1);
        }
        return result.size()==new HashSet<>(result.values()).size();
    }
}