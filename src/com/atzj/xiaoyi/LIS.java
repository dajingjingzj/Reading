package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 * 最长上升子序列
 * @author zhoujing129
 */
public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(findLIS(nums));
    }

    private static int findLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int max = 1;
        for (int i = 0; i<n; i++){
            dp[i] =1;
            for (int j = 0; j< i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

}
