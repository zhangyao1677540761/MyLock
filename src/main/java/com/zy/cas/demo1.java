package com.zy.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @学习小结
 * 原子类引用,解决单一属性加锁的过重问题
 */
public class demo1 {
    public static void main(String[] args) {
        user u1 = new user(1, "张三");
        user u2 = new user(2, "李四");
        //既比较值又比较版本号stamp
        AtomicStampedReference<user> userAtomicStampedReference = new AtomicStampedReference<user>(u1,1);
        int stamp = userAtomicStampedReference.getStamp();
        userAtomicStampedReference.compareAndSet(u1,u2,1,stamp+1);
        System.out.println(userAtomicStampedReference.getReference());
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class user{
    private int id;
    private String name;
}