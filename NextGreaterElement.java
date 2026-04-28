import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Build next greater map
        for(int num : nums2){
            while(!st.isEmpty() && num > st.peek()){
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        // Remaining elements → no greater element
        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }

        // Build result
        int[] r = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            r[i] = map.get(nums1[i]);
        }

        return r;
    }

    // Main method for testing
    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] result = obj.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result)); // [-1, 3, -1]
    }
}