class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];
        int[] windowCount = new int[128];

        int need = 0;
        int have = 0;

        for (int i = 0; i < t.length(); i++) {
            
            char c = t.charAt(i);

            if (count[c] == 0) {
                need++;
            }

            count[c]++;
        }

        int l = 0;
        int r = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCount[c]++;

            if (windowCount[c] == count[c]) {
                have++;
            }

            while (need == have) {

                int length = (r-l) + 1;

                if (length < minLength) {
                    minLength = length;
                    start = l;
                }

                char leftMost = s.charAt(l);
                windowCount[leftMost]--;

                if (windowCount[leftMost] < count[leftMost]) {
                    have--;
                }

                l++;
            }

            r++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start+minLength);
    }
}