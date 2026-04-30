import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Step 3: Traverse bucket from high freq to low
        int[] ans = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return ans;
    }

    //  Testing
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}