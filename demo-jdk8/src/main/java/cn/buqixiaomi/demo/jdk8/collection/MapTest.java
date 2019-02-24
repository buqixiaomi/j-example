package cn.buqixiaomi.demo.jdk8.collection;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-17 16:06
 */
public class MapTest {

    public static void main(String[] args) {
//        /*HashMap 使用 equals 作为key唯一性验证*/
//        HashMap<Integer,String> stringHashMap = new HashMap<>(2);
//        stringHashMap.put(new Integer(1),"werew");
//        stringHashMap.put(new Integer(1),"dddd");
//        /*{1=dddd}*/
//        System.out.println(stringHashMap);
//
//        /*IdentityHashMap 使用 == 作为key唯一性验证*/
//        IdentityHashMap<Integer,String> integerStringIdentityHashMap = new IdentityHashMap<>(2);
//        integerStringIdentityHashMap.put(new Integer(1),"wer");
//        integerStringIdentityHashMap.put(new Integer(1),"324");
//        /* {1=wer, 1=324}*/
//        System.out.println(integerStringIdentityHashMap);

//        /*TreeMap key 不能为null*/
//        TreeMap<String,String> stringTreeMap = new TreeMap<>();
//        stringTreeMap.put(null,"sfsd");
//        System.out.println(stringTreeMap);

//        /*TreeMap key 要么可排序要么必须指定比较器*/
//        TreeMap<UserKey,String> userKeyStringTreeMap = new TreeMap<>();
//        userKeyStringTreeMap.put(new UserKey(1),"sdfsd");
//        System.out.println(userKeyStringTreeMap);

        TreeMap<String,String> stringTreeMap = new TreeMap<>();
        System.out.println(stringTreeMap.put("1","234"));
        System.out.println(stringTreeMap.put("2","sfsdf"));
        System.out.println(stringTreeMap.put("1","4444444"));;
        System.out.println(stringTreeMap);

    }


    static class UserKey implements Comparable<UserKey> {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public UserKey(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "UserKey{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public int compareTo(UserKey o) {
            return (this.id < o.getId())?-1:((this.id.equals(o.getId()))?0:1);
        }
    }
}
