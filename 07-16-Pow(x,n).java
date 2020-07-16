class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return helper(1 / x, -n);
        return helper(x, n);
    }

    public double helper(double x, int n) {
        if (n == 0) return 1.0;
        double sub = helper(x, n / 2);
        return n % 2 == 0 ? sub * sub : sub * sub * x;
    }
}