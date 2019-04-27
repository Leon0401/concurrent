package com.stark.concurrent.lambdaexpress;

/**
 * 显式申明是一个函数式接口
 */
@FunctionalInterface
interface FOO1 {
    public int add(int x, int y);
}




public class LambdaExpressTest2 {
    public static void main(String[] args) {


        FOO1 foo1 = (x, y) -> {
            System.out.println("hello");
            return x + y;
        };
        System.out.println(foo1.add(1, 6));

    }
}
