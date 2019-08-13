package com.atzj.xiaoyi;

/**
 * 类描述：
 * 不重复大于0的数组 求目标和的数排列
 * @author zhoujing129
 */
public class 数组求目标和 {
        public static void main(String[] args){
            int[] num=new int[]{2,3,7,6};
            int target=9;
            find(num, target, "");
        }
        public static void find(int[] num, int target, String temp){
            if(issolution(temp,target)){
                System.out.println(temp);
                return;
            }
            for(int i=0;i<num.length;i++){
                if(num[i]!=-1){//如果取过这个数字了，就置为-1
                    int k=num[i];
                    num[i]=-1;
                    find(num, target, temp+k);
                    num[i]=k;
                }
            }
        }
        public static boolean issolution(String temp, int target){
            boolean result=false;
            int count=0;
            for(int i=0;i<temp.length();i++){
                count=count+Integer.valueOf(temp.charAt(i)+"");
            }
            if(count==target)
                result=true;
            return result;
        }
}
