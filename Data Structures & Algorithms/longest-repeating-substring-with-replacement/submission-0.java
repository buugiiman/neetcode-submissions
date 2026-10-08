class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int res = 0;

        int[] count = new int[26];

        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);

            r++;
        }

        return res;
    }
}
