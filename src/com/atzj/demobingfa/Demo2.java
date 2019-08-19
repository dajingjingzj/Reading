package com.atzj.demobingfa;


import java.util.ArrayList;
import java.util.Collections;


/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Demo2 {
    public static void main(String[] args) {
       String s = "爱讯飞789swr1wwen34ifly65tek";
        findNum(s);
    }

    private static void findNum(String s) {
        ArrayList list = new ArrayList();
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++){
            if(arr[i] >= 48 && arr[i] <= 57){
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i));
        }
    }
}
