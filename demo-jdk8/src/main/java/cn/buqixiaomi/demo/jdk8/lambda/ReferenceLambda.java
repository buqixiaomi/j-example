package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

public class ReferenceLambda {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("c","d","A","Z");
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);
    }
}
