class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                map.get(sortedStr).add(strs[i]);
            }

        }

        for (List<String> listString : map.values()) {
            res.add(listString);
        }

        return res;
    }
}
