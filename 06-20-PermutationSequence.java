class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList();
        nums.add(1);
        long fact = 1;
        for (int i = 1; i < n; ++i) {
            fact *= i;
            nums.add(i + 1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = (int) (k / fact);
            k -= idx * fact;

            sb.append(nums.get(idx));
            nums.remove(idx);
            if (i != 0) fact /= i;
        }
        return sb.toString();
    }
}

// 123; k / (n-1)!
// 132;
// 213;
// 231;
// 312;
// 321;

//   1, 2, 3, 4, 5, 6

// 1234;
// 1243;
// 1324;
// 1342;
// 1423;
// 1432;
// 2134;
// 2143;
// 2314;
// 2341;
// 2413;
// 2431;
// 3124;
// 3142;
// 3214;
// 3241;
// 3412;
// 3421;
// 4123;
// 4132;
// 4213;
// 4231;
// 4312;
// 4321;