package com.example.demo.lamdba;

import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @ClassName: CopyOnWrite
 * @description:  自带的带锁的list
 * @author: BeliieveForMe-GuoDF
 * @Email: 731998663@qq.com
 * @github: https://github.com/BeliieveForMe
 * @date: Created in 2021/4/27 0027
 * @Version 1.0.0
 */
public class CopyOnWrite {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            new Thread(()->{
                list.add(finalI+"");
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

    }
}
