package cn.buqixiaomi.demo.jdk8.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features.forEach(n -> System.out.println(n));

// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
// 看起来像C++的作用域解析运算符
//        features.forEach(System.out::println);
//        features.stream().map(s -> s+"1").collect(Collectors.toList());

        System.out.println(Math.round(Float.valueOf("42.6666667") * 10000));
        System.out.println(Math.round(Double.valueOf("42.6666667") * 10000));
    }
}
