class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket sort — index = frequency, value = list of numbers
        // Max frequency can't exceed nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : freq.keySet()) {
            int count = freq.get(num);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(num);
        }

        // Step 3: Collect top k elements from highest frequency down
        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return result;
    }
}