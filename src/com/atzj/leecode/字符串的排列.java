package com.atzj.leecode;

import java.util.ArrayList;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 字符串的排列 {
    public static void main(String[] args) {

    }
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == "" && str == null){
            list = null;
        }else if(str.length() != 0){
            solution(str,"",list);
        }
        return list;
    }

    private void solution(String str, String temp, ArrayList<String> list) {
        int len = str.length();
        boolean flag= list.contains(temp) ; //去除重复
        if(len == 0 && flag == false){
            list.add(temp);
            return;
        }
        for (int i=0; i<len; i++){
            String news = str.substring(0,i)+str.substring(i+1,len);
            solution(news,temp+str.charAt(i),list);
        }
    }
}
