class Solution {
    private static final long MOD = 1_000_000_007L;
    public int countGoodStrings(long n) {
        return (int) (2 * fibonacci(n)[0] % MOD);
    }

    private long[] fibonacci(long n) {
        if (n == 0) {
            return new long[]{0, 1};
        }
        long[] half = fibonacci(n / 2);

        long a = half[0];
        long b = half[1];
        long c = a * ((2 * b % MOD - a + MOD) % MOD) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;
        if (n % 2 == 0) {
            return new long[]{c, d};
        }
        return new long[]{d, (c + d) % MOD};
    }
}