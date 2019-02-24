package cn.buqixiaomi.demo.jdk8.lambda;

import buqixiaomi.learn.java8.lambda.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据流处理
 */
public class SteamTest {

    public static void main(String[] args) {
        List<Dish> source = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french",true,5300,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.OTHER),
                new Dish("salmon",false,450,Dish.Type.OTHER)
        );
        source.stream().forEach(System.out::println);

        List<String> threeHighCaloricDishNames = source.stream()
                .filter(dish -> dish.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        int sum = numbers.stream().reduce(0,(a,b)-> a + b);
        System.out.println(sum);
    }
}
