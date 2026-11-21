class Solution {
    public int characterReplacement(String s, int k) {

        int res = 0;
        int l = 0;
        int r = 0;

        int[] count = new int[26];
        int maxFreq = 0;

        while (r < s.length()) {
            int index = s.charAt(r) - 'A';
            count[index]++;
            maxFreq = Math.max(count[index], maxFreq);

            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max((r - l + 1), res);
            r++;
        }

        return res;

    }
}
