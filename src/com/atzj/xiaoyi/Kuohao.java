package com.atzj.xiaoyi;

import java.util.ArrayList;

/**
 * 类描述：
 * n对括号排列 回溯法 递归
 * @author zhoujing129
 */
public class Kuohao {
    public static void main(String[] args) {
        int n=3;
        int leftnum = n;
        int rightnum = n;
        ArrayList<String> list = new ArrayList<>(); //用于存放解空间
        parentless("",list,leftnum,rightnum);
        for (String s : list){
            System.out.println(s);
        }
    }
    public static void parentless(String sub, ArrayList<String> list, int leftnum, int rightnum){
        if(leftnum == rightnum){ //结束 边界条件
            list.add(sub);
        }
        if (rightnum > leftnum){ //选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
            parentless(sub+")",list,leftnum,rightnum-1);
        }
        if(leftnum>0){ //只有剩下的右括号比左括号多，才能放右括号。只有左括号数量大于0才能放入左括号。
            parentless(sub+"(",list,leftnum-1,rightnum);
        }
    }
}
