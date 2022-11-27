package com.zy.deathLock;

/**
 * @学习小结
 * 找到程序不结束的原因:
 *1查看进程编号: jsp -l
 *2找到当前进程
 *3jstack 编号
 *
 *
 * 或者jconsole
 *
 *
 */
public class DeathLockDemo1 {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o) {

                }
            }
        }).start();


    }
}
