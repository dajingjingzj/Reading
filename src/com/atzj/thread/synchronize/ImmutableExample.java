package com.atzj.thread.synchronize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述： 不可变对象 线程安全： 多个线程不管以何种方式访问某个类，并且在主调代码中不需要进行同步，都能表现正确的行为。
 * 1.不可变
 * 类型：final 关键字修饰的基本数据类型；String；枚举类型；Number 部分子类，
 * 如 Long 和 Double 等数值包装类型，BigInteger 和 BigDecimal 等大数据类型。但同为 Number 的原子类 AtomicInteger 和 AtomicLong 则是可变的
 * 集合类型，可以使用 Collections.unmodifiableXXX() 方法来获取一个不可变的集合。
 * Collections.unmodifiableXXX() 先对原始的集合进行拷贝，需要对集合进行修改的方法都直接抛出异常。
 *
 * @author zhoujing129
 */
public class ImmutableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a", 1);
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.util.Collections$UnmodifiableMap.put(Collections.java:1457)
        //	at com.atzj.thread.synchronize.ImmutableExample.main(ImmutableExample.java:21)
    }
}
