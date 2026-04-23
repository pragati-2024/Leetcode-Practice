import java.util.ArrayList;

public class Six_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> arr = new ArrayList<>();

        // val ke equal elements skip karo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                arr.add(nums[i]);
            }
        }

        // filtered elements wapas nums me daalo
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        return arr.size();
    }

    // Testing ke liye main method
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = removeElement(nums, val);

        System.out.println("New length: " + k);
        System.out.print("Updated array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}