package cn.buqixiaomi.demo.jdk8.base;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-19 17:36
 */
public class ExceptionTest {

    public static void main(String[] args) {
//        runtimeException();
    }

    private static void runtimeException() throws Exception{
        throw new RuntimeException("342");
//        throw new FileNotFoundException();
    }
}
