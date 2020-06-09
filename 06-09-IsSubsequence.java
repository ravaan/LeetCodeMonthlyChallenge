class Solution {
    public boolean isSubsequence(String s, String t) {
        int itr_s = 0, itr_t = 0;
        int len_s = s.length(), len_t = t.length();
        while (itr_s < len_s && itr_t < len_t) {
            if (s.charAt(itr_s) == t.charAt(itr_t)) {
                itr_s++;
                itr_t++;
            } else {
                itr_t++;
            }
        }
        if (itr_s == len_s) return true;
        return false;
    }
}
