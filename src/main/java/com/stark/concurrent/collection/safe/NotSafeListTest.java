package com.stark.concurrent.collection.safe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @auther leon
 * @create 2019-03-23 19:33
 *
 * 1 故障现象
 *java.util.ConcurrentModificationException
 *
 *
 * 2 导致原因
 *
 *
 * 3 解决方案
 *  3.1 new Vector<>();
 *  3.2 Collections.synchronizedList(new ArrayList<>());
 *  3.3 CopyOnWriteArrayList(); /   ConcurrentHashMap
 *
 *
 * 4 优化建议(同样的错误 ，不来第2次)
 *
 *
 *
 */
public class NotSafeListTest {

    /**
     * 为什么ConcurrentHashMap可以解决线程安全问题呢？
     * @param args
     */
    public static void main(String[] args) {
//        Map map = new HashMap();
//        Map map = Collections.synchronizedMap(new HashMap<>());
        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,6),1);
                System.out.println(map.toString());
            },String.valueOf(i)).start();
        }
    }



 /*   public static void main2(String[] args) {
//        Set<String> set = new HashSet<>();
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {

                set.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(set);

            }, String.valueOf(i)).start();
        }
    }*/




/*    public static void main1(String[] args) {

//        List<String> list = new ArrayList<>();
//        Vector<String> vector = new Vector<>();
//        List list = Collections.synchronizedList(new ArrayList<>());
        List list = new CopyOnWriteArrayList();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                //vector.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
                //System.out.println(vector);
            },String.valueOf(i)).start();

            //System.out.println(String.valueOf(i));
        }
    }*/


}
