package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda {

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T t: list){
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        Integer[]  nums = {3,4,6,178,33,23,89};
        List<Integer> numList = Arrays.asList(nums);

        forEach(numList,(Integer a) ->{
            System.out.println(a);
        });
    }
}
