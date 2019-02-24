package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 比较器lambda写法
 */
public class ComparatorLambda {

    public static void main(String[] args) {
        Integer[]  nums = {3,4,6,178,33,23,89};
        List<Integer> numList = Arrays.asList(nums);
        numList.sort((Integer a,Integer b) ->{
                return  a-b;
        });
        System.out.println(numList);
    }
}
