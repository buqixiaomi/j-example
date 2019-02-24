package cn.buqixiaomi.demo.jdk8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-18 14:51
 */
public class ListTest {

    public static void main(String[] args) {

//        List<String> strings = new ArrayList<>();
//        strings.add("232");
//        Iterator<String> it = strings.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//            it.remove();
//        }
//        System.out.println(strings);

//        List<String> strings = new ArrayList<>();
//        strings.add("232");
//        Iterator<String> it = strings.listIterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//            it.remove();
//        }
//        System.out.println(strings);

//        List<TestBean> testBeanList = new ArrayList<>();
//        testBeanList.add(new TestBean("232"));
//        TestBean[] testBeans = new TestBean[1];
//        testBeanList.toArray(testBeans);
//        System.out.println(testBeanList);
//        testBeans[0].setName("werwer");
//        System.out.println(testBeanList);
//        /*结论--toArray 是引用的转换，改变原集合会引起转换后的集合的变化*/

//        List<String> strings = new ArrayList<>();
//        strings.add("werwe");
//        strings.add("232432");
//        strings.add(null);
//        System.out.println(strings);

//        int[]  a = {1,2,3};
//        Integer[]  a = {1,2,3};
//        List l = Arrays.asList(a);
//        System.out.println(l);
//        System.out.println(l.size());
        /*基本数据类型不能自动泛型化*/

        List<String> list = new ArrayList(3);
        list.add("a");
        list.add("b");
        list.add("c");
//        for (String s : list){
//            if (s == "a"){
//                list.remove(s);
//            }
//        }
//        /*for each 是使用类内部迭代器做的循环*/
//        for (int i=0;i<=list.size()-1;i++){
//            if (list.get(i)=="a"){
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
//        List<String> subList = list.subList(0,1);
//        subList.add("d");
//        System.out.println(list);
//        System.out.println(subList);
//        System.out.println(list.size());
//        System.out.println(subList.size());

//        list.add("e");
//        System.out.println(list);
//        System.out.println(subList);
//        System.out.println(list.size());
//        System.out.println(subList.size());



    }
}
