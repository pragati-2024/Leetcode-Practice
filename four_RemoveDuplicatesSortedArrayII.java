public class four_RemoveDuplicatesSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (i < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Length after removing duplicates: " + k);
        System.out.print("Updated array: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}