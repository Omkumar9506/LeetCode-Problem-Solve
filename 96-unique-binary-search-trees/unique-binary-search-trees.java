class Solution {
    public int numTrees(int n) {
        int [] graph = new int[n+1];
        graph[0] = graph[1] = 1;
            
        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
            graph[i] += graph[j-1] * graph[i-j];
            }
        }
        return graph[n];
    }
}