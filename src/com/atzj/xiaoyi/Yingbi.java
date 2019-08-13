package com.atzj.xiaoyi;

/**
 * 类描述：
 * 动态规划
 * @author zhoujing129
 */
public class Yingbi {
    public static void makeChange(int [] arr, int money){
        int [] dp = new int[money+1];
        dp[0] = 0;
        for (int i = 1; i<money; i++){
            int count = i;
            for (int j = 0; j<arr.length; j++){
                int temp = dp[i - arr[j]]+1;
                if(temp < count)
                    count = temp;
            }
            dp[i] = count;
            System.out.println("面值为"+i+"的最小硬币数"+dp[i]);
        }
    }

    public static void main(String[] args) {
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        int money = 63;
        makeChange(coinValue,money);
    }
}
