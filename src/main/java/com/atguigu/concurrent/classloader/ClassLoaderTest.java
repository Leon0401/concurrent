package com.atguigu.concurrent.classloader;

import com.atguigu.concurrent.lombok.Book;

/**
 * @auther leon
 * @create 2019/4/24 19:28
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        //类加载器加载book.class到方法区中，类模板的属性在方法去中；
        //创建实例是在堆中的新生区的伊甸园区new出来的，给属性赋值，实例的变量存储在堆中。
        Book book = new Book();
        book.setPrice(1D);

        System.out.println(book.getClass().getClassLoader().getParent().getParent());
        System.out.println(book.getClass().getClassLoader().getParent());
        System.out.println(book.getClass().getClassLoader());
    }



}



