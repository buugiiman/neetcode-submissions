class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = s1.length()-1;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (r < s2.length()) {
            int tempL = l;
            while (l == 0 && tempL <= r) {
                char c = s2.charAt(tempL);
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                tempL++;
            }

            if (map.equals(windowMap)) {
                return true;
            }

            windowMap.computeIfPresent(s2.charAt(l), (k,v) -> v > 1 ? v-1 : null);
            l++;
            r++;

            if (r < s2.length()) {
                windowMap.put(s2.charAt(r), windowMap.getOrDefault(s2.charAt(r), 0) + 1);
            }
        }

        return false;
    }
}