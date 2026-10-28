class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);

            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(strs[i]);
            } else {
                map.put(sortedString, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        for (List<String> vals : map.values()) {
            res.add(vals);
        }

        return res;
    }
}
