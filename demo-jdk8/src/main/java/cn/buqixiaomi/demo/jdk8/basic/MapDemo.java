package cn.buqixiaomi.demo.jdk8.basic;

import java.util.*;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-09-04 17:43
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap(2);
        map.put("a","1");
        map.put("b","sf");
        System.out.println(Integer.toBinaryString(-1998098908));
        System.out.println(Integer.toBinaryString(1998098908));

        int n = 8- 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1);


        //Exception in thread "main" java.util.ConcurrentModificationException 快速失败
//        Iterator it = map.keySet().iterator();
//        while (it.hasNext()){
//            map.remove(it.next());
//        }
//        for (Map.Entry<String,String> entry:map.entrySet()){
//            map.remove(entry.getKey());
//        }
    }
}
