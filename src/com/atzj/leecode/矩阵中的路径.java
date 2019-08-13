package com.atzj.leecode;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        char [] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char [] str = {'b','c','a','b'};
        System.out.println(hasPath(matrix,rows,cols,str));
    }

    public  static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean [] flag = new boolean[matrix.length]; //标志位 未走过标记为false,走过true 初始化未false
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){ //循环遍历二位数组矩阵
                if(judge(matrix,i,j,rows,cols,flag,str,0)){ //找到起点等于str第一个元素的值，再递归四周是否有符合条件的元素-----回溯法
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private static boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i*cols + j; //根据i和j的位置判断在一维数组中起点的位置index
        if (i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true){ //递归终止条件
            return false;
        }
        if(k == str.length-1){ //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
            return true;
        }
        flag[index] = true; // 已走过未true

        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
           judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
           judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
           judge(matrix,i,j+1,rows,cols,flag,str,k+1) ) {  //回溯，递归寻找，每次找到了就给k加一，找不到，还原

            return true;
        }
        flag[index] = false;//走到这，说明这一条路不通，还原，再试其他的路径
        return false;
    }
}
