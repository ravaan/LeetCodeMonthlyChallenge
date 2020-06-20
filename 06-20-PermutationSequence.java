class Solution {
    boolean used[];
    int fact = 1;

    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        used = new boolean[n + 1];

        for (int i = 2; i < n; i++) fact *= i;
        StringBuilder ans = new StringBuilder();
        used[0] = true;
        boolean flag = false;
        while (k >= 1) {
            // System.out.println("n: " + n + " k: " + k + " fact: " + fact);
            int sm = k / fact;
            if (k % fact != 0) sm++;
            ans.append(findSmallest(sm));
            n--;
            if (k == 1) flag = true;
            k -= (sm - 1) * fact;
            if (flag) break;
            fact /= n;
        }
        for (int i = 1; i < used.length; i++) if (!used[i]) ans.append(i);
        return ans.toString();
    }

    public int findSmallest(int s) {
        int count = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) count++;
            if (count == s) {
                used[i] = true;
                return i;
            }
        }
        return 0;
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