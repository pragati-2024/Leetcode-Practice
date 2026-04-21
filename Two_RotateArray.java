import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        rotatearray(nums, 0, n - 1);
        rotatearray(nums, 0, k - 1);
        rotatearray(nums, k, n - 1);
    }

    public static void rotatearray(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}

public class Two_RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();
        obj.rotate(nums, k);

        System.out.println("Rotated Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}