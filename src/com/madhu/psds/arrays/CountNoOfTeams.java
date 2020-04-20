package com.madhu.psds.arrays;
//https://leetcode.com/problems/count-number-of-teams/
//1395. Count Number of Teams

public class CountNoOfTeams {
    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 4, 1};
        CountNoOfTeams countNoOfTeams = new CountNoOfTeams();
        countNoOfTeams.numTeams(nums);
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
            }

            for (int k = i + 1; k < n; k++) {
                if (rating[i] < rating[k]) r++;
            }

            ans += (l * r) + (i - l) * (n - i - r - 1);
        }

        return ans;
    }

    //
    public int numTeamsClearIdea(int[] rating) {
        int length = rating.length;
        int result = 0;
        for (int i = 1; i < length - 1; i++) {
            int lessLeft = 0, moreLeft = 0, lessRight = 0, moreRight = 0;
            int middle = rating[i];
            for (int j = 0; j < i; j++) {
                if (rating[j] < middle) {
                    lessLeft++;
                } else {
                    moreLeft++;
                }
            }
            for (int j = i + 1; j < length; j++) {
                if (rating[j] < middle) {
                    lessRight++;
                } else {
                    moreRight++;
                }
            }
            result += lessLeft * moreRight + moreLeft * lessRight;
        }
        return result;
    }
}
