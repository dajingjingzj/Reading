package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 * 俄罗斯方块变形
 * @author zhoujing129
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int [] b = new int[n];
        for (int i = 0; i<m; i++){
          b[ arr[i] -1 ]++; //从0开始下标
        }
        int temp = b[0];
        for(int i = 1; i<n; i++){
            if(temp > b[i])
                temp = b[i];
        }
        System.out.println(temp);

   /*     Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            arr[scanner.nextInt() - 1]++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);*/
    }
}
