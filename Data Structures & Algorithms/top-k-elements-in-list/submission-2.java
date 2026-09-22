class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int res[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for (Integer mapKey : map.keySet()) {
           int freq = map.get(mapKey);

           if (bucket[freq] == null) {
            bucket[freq] = new ArrayList<>();
           }

           bucket[freq].add(mapKey);
        }

        int m = 0;

        for (int i = bucket.length-1; i >= 0 && k > 0; i--) {
            if (bucket[i] == null) {
                continue;
            }

            for (int j = 0; j < bucket[i].size(); j++) {
                res[m++] = bucket[i].get(j);
                k--;
            }
        }

        return res;
    }
}
