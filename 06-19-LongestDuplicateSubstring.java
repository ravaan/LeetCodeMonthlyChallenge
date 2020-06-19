class Solution {
    String str;
    long mod = (long) Math.pow(2, 32);
    int len;

    public String longestDupSubstring(String s) {
        len = s.length();
        if (len == 0) return "";

        str = s;

        int lo = 1, hi = len - 1;
        String ans = "";
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            String su = sub(mid);
            if (su != "") {
                ans = su;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    public String sub(int id) {
        Set<Long> set = new HashSet<>();
        long temp = 0;
        for (int i = 0; i < id; i++) temp = (temp * 26 + str.charAt(i) - 'a') % mod;
        set.add(temp);

        long aL = 1;
        for (int i = 1; i <= id; i++) aL = (aL * 26) % mod;

        for (int j = 1; j < len + 1 - id; j++) {
            temp = (temp * 26 - ((str.charAt(j - 1) - 'a')) * aL % mod + mod) % mod;
            temp = (temp + (str.charAt(j + id - 1) - 'a')) % mod;
            // System.out.println("id:" + id + " sub:"  + str.substring(j, j+id));
            if (set.contains(temp)) return str.substring(j, j + id);
            set.add(temp);
        }
        return "";
    }
}