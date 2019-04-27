package com.stark.concurrent.lombok;

/**
 * @auther leon
 * @create 2019/4/23 21:07
 */
public class LomBokTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setNumber(1);
        book.setPrice(12.0);
        System.out.println(book);
    }
}
