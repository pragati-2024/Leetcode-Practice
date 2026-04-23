import java.util.ArrayList;
import java.util.Collections;

public class five_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        // nums1 ke first m elements add karo
        for (int i = 0; i < m; i++) {
            arr.add(nums1[i]);
        }

        // nums2 ke saare elements add karo
        for (int j = 0; j < n; j++) {
            arr.add(nums2[j]);
        }

        // sort kar do
        Collections.sort(arr);

        // sorted array ko nums1 me wapas daalo
        for (int i = 0; i < arr.size(); i++) {
            nums1[i] = arr.get(i);
        }
    }

    // Main method (testing ke liye)
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        // Output print
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}