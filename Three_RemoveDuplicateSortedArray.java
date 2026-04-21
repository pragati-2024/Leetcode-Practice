import java.util.*;

class Solution   {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}

public class Three_RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int k = obj.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);

        System.out.println("Updated array:");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}