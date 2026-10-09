class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(map);

        int l = 0;
        int r = s1.length()-1;

        while (r < s2.length()) {
            Map<Character, Integer> windowMap = new HashMap<>();
            int tempL = l;
            while (tempL <= r) {
                char c = s2.charAt(tempL);
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                tempL++;
            }

            System.out.println(windowMap);

            if (map.equals(windowMap)) {
                return true;
            }

            l++;
            r++;
        }

        return false;
    }
}