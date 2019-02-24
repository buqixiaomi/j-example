package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化 lambda 表述
 */
public class ArgLambda {

    public static class Apple{
        private String color;
        private Integer weight;

        public Apple() {
        }

        public Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

    public interface  ApplePredicate<T>{
        boolean test(T t);
    }

    public static <T> List<T> filterApple(List<T> apples,ApplePredicate<T> applePredicate){
        List<T> result = new ArrayList();
        for (T t:apples){
            if (applePredicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Apple apple1 = new Apple("red",23);
        Apple apple2 = new Apple("green",13);
        List<Apple> appleResource = new ArrayList<Apple>();
        appleResource.add(apple1);
        appleResource.add(apple2);
        List<Apple> redApples = filterApple(appleResource, new ApplePredicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println(redApples.size());

        //使用lambda
        List<Apple> redApples1 = filterApple(appleResource,(Apple apple) ->
                "red".equals(apple.getColor())
        );
        System.out.println(redApples1.size());
        List<Integer> intResource = new ArrayList<Integer>();
        intResource.add(1);
        intResource.add(2);
        List<Integer> intResult = filterApple(intResource,(Integer a) ->
                a % 2 == 0
        );
        System.out.println(intResult.size());
    }
}
