import java.util.*;

public class FindRelativeRanks {

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // index + score store karne ke liye
        int[][] sortedPairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedPairs[i] = new int[]{i, score[i]};
        }

        // score ke basis pe descending sort
        Arrays.sort(sortedPairs, (x, y) -> y[1] - x[1]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                ans[sortedPairs[i][0]] = "Gold Medal";
            } else if (i == 1) {
                ans[sortedPairs[i][0]] = "Silver Medal";
            } else if (i == 2) {
                ans[sortedPairs[i][0]] = "Bronze Medal";
            } else {
                ans[sortedPairs[i][0]] = String.valueOf(i + 1);
            }
        }

        return ans;
    }

    // Testing ke liye main method
    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};

        String[] result = findRelativeRanks(score);

        System.out.println(Arrays.toString(result));
    }
}