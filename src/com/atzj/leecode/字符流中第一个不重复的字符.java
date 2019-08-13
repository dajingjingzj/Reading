package com.atzj.leecode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 类描述：
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author zhoujing129
 */
public class 字符流中第一个不重复的字符 {
    public static void main(String[] args) {

    }
    HashMap<Character, Integer> map=new HashMap();
    ArrayList<Character> list=new ArrayList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }

        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {   char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }

        return c;
    }
}
