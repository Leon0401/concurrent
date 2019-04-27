package com.stark.concurrent.lambdaexpress;

/**
 * 显式申明是一个函数式接口
 */
@FunctionalInterface
interface FOO {
    public void sayHEllo();
}


/**
 * 针对匿名内部类的lambda表达式：
 * 1  使用lambda express 的前提，这个接口必须是一个函数式接口（一个方法）
 * 2    小口诀：
 * 拷贝小括号，写死右箭头，落地大括号
 *
 * 也就是说匿名内部类可以简化为lambda Express
 *
 */
public class LambdaExpressTest {
    public static void main(String[] args) {

        /*FOO foo = new FOO() {
            public void sayHEllo() {
                System.out.println("hello");
            }
        };
        foo.sayHEllo();*/

        FOO foo = () -> { System.out.println("hello"); };
        foo.sayHEllo();

    }
}
