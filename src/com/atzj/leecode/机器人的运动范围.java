package com.atzj.leecode;

/**
 * 类描述：
 * 回溯法
 * 思路： 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
 * 返回1 + 4 个方向的探索值之和。
 * 2.探索时，判断当前节点是否可达的标准为：
 *  1）当前节点在矩阵内；
 *  2）当前节点未被访问过；
 *  3）当前节点满足limit限制。
 * @author zhoujing129
 */
public class 机器人的运动范围 {
    public static void main(String[] args) {
        int k = 18;
        int rows = 100;
        int cols = 90;
        System.out.println(movingCount(k,rows,cols));
    }
    public static int movingCount(int threshold, int rows, int cols){
        boolean[][] flag = new boolean[rows][cols];
        return continueTeps(threshold,rows,cols,0,0,flag);

    }

    private static int continueTeps(int limit, int rows, int cols, int r, int c, boolean[][] flag) {
        if(r<0 || c<0 || r>=rows || c>=cols || flag[r][c] || count(r)+count(c)>limit){
            return 0;
        }
        flag[r][c] = true;
        return continueTeps(limit,rows,cols,r-1,c,flag)+
                continueTeps(limit,rows,cols,r,c-1,flag)+
                continueTeps(limit,rows,cols,r+1,c,flag)+
                continueTeps(limit,rows,cols,r,c+1,flag)+1;

    }

    private static int count(int c) {
        int sum =0;
        while (c != 0){
            sum += c%10 ;
            c /= 10;
        }
        return sum;
    }
}
