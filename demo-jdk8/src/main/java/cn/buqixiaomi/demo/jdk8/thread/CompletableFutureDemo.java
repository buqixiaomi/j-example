package cn.buqixiaomi.demo.jdk8.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author : shengkai.li
 * @create :  2019-03-12  14:18
 * @description : 并发异步计算新框架使用lambda
 */
public class CompletableFutureDemo {

    private static String[] names = {"q","w","e","r"};

    public static void main(String[] args) {
        List<String> strings = concat();
        strings.stream()
                .forEach(s-> System.out.printf(s));
    }

    public static List<String> concat(){
        List<CompletableFuture<String>> futureList = Arrays.stream(names).map(name ->
                CompletableFuture.supplyAsync(()->name +"-"))
                .collect(Collectors.toList());
        return futureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
