package com.zy.cas;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @学习小结
 * 非安全的测试
 */
public class demo2 {
    public static void main(String[] args) {
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list =new CopyOnWriteArrayList<>();
        Random random = new Random();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                list.add(random.nextInt(5)+"");
                System.out.println(list);
            }).start();
        }

    }
}
