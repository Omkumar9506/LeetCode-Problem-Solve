class Solution {

    static List<Long>[] P = new ArrayList[2];

    static {
        P[0] = new ArrayList<>();
        P[1] = new ArrayList<>();
        long M = 1_000_000_000L;
        for (int v = 1; v < 100000; v++) {
            String s = String.valueOf(v);
            String r = new StringBuilder(s).reverse().toString();
            long a1 = Long.parseLong(s.substring(0, s.length() - 1) + r);
            long a2 = Long.parseLong(s + r);
            if (a1 < M) P[(int)(a1 & 1)].add(a1);
            if (a2 < M) P[(int)(a2 & 1)].add(a2);
        }
        Collections.sort(P[0]);
        Collections.sort(P[1]);
    }

    public long minOperations(int[] nums) {
        long res = 0;
        for (int a : nums) {
            List<Long> p = P[a & 1];
            int i = Collections.binarySearch(p, (long)a);
            if (i < 0) i = -(i + 1);
            if (i >= p.size()) i = p.size() - 1;
            long d1 = Math.abs(a - p.get(i));
            long d2 = i > 0 ? Math.abs(a - p.get(i - 1)) : d1;
            res += Math.min(d1, d2) / 2;
        }
        return res;
    }
}