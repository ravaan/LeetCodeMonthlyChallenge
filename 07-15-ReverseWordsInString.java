class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String w[] = s.split(" ");
        // System.out.println(Arrays.toString(w));
        StringBuilder ans = new StringBuilder();
        for (int i = w.length - 1; i >= 0; i--) {
            if (w[i].length() != 0) ans.append(w[i] + " ");
        }

        return ans.toString().trim();
    }
}