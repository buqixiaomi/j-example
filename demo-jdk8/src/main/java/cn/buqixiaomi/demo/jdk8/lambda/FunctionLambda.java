package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionLambda {

    public static <T,R> List<R> trans(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for (T t:list){
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[]  nums = {3,4,6,178,33,23,89};
        List<Integer> numList = Arrays.asList(nums);
        List<Integer> result = trans(numList,(Integer a) ->{
           return a+100;
        });
        System.out.println(result);
    }
}
