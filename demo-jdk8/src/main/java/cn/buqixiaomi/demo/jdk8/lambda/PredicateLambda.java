package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambda {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t: list){
            if (p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[]  nums = {3,4,6,178,33,23,89};
        List<Integer> numList = Arrays.asList(nums);
        List<Integer> result = filter(numList,(Integer a) ->{
            return a>40;
        });
        System.out.println(result);
    }
}
