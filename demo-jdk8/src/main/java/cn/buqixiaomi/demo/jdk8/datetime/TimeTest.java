package cn.buqixiaomi.demo.jdk8.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : shengkai.li
 * @create :  2019-03-13  18:18
 * @description : localTimeDemo
 */
public class TimeTest {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
