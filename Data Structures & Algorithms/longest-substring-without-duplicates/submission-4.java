class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1) {
            return 1;
        }

        int l = 0;
        int r = 0;

        int res = 0;

        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            char ch = s.charAt(r);
            if (!set.contains(ch)) {
                set.add(ch);
                res = Math.max(res, set.size());
                r++;
            } else {
                set.remove(s.charAt(l++));
            }
        }

        return res;
    }
}
