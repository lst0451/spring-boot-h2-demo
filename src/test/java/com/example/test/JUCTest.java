package com.example.test;

import org.junit.Test;

public class JUCTest {

    @Test
    public void test(){
        VolatileDemo td = new VolatileDemo();
        new Thread(td).start();

        while (true){
            if (td.isFlag()){
                System.out.println("flag is true;");
                break;
            }else {
                System.out.println("flag is false;");
            }
        }
    }

}

class VolatileDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }
}
