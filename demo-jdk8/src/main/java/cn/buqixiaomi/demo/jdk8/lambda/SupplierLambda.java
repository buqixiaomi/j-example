package cn.buqixiaomi.demo.jdk8.lambda;

import java.util.function.Supplier;

public class SupplierLambda {

    public static <T> T build(Supplier<T> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        SupplierLambda supplierLambda = build(() ->{
            return new SupplierLambda();
        });
        System.out.println(supplierLambda);
    }
}
