package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 牛牛背包 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            count = 0;
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] nums = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }
            if (sum <= total) {
                System.out.println((int)Math.pow(2, n));
            } else {
                dfs(0, 0, n, nums, total);
                // 均不添加也是一种情况
                System.out.println(count + 1);
            }
        }
    }

    private static void dfs(long sum, int cur, int n, int[] nums, int total) {
        if (cur < n) {
            if (sum > total) {
                return;
            }
            //  不添加这件零食
            dfs(sum, cur + 1, n, nums, total);
            //  当前这种添加方式合理,添加这件零食
            if (sum + nums[cur] <= total) {
                count++;
                dfs(sum + nums[cur], cur + 1, n, nums, total);
            }
        }
    }
}
