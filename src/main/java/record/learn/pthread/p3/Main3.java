package record.learn.pthread.p3;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mqw
 * @create 2020-08-13-20:54
 */
public class Main3 {

    // 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread ta = new Thread(new ThreadABC(maj , 'A'));
        Thread tb = new Thread(new ThreadABC(maj , 'B'));
        Thread tc = new Thread(new ThreadABC(maj , 'C'));
        ta.start();
        tb.start();
        tc.start();
    }
}

/**
 * MajusculeABC类持有控制状态的变量
 */
class MajusculeABC {

    /* 标志位 初始值为65保证从A开始 */
    private static volatile int flag = 65;

    public int getFlag(){
        return flag;
    }
    public void setFlag(int flag){
         this.flag = flag;
    }

}

/**
 * 无锁实现
 */
@AllArgsConstructor
class ThreadABC implements Runnable {

    MajusculeABC maj;
    char aChar;

    final static AtomicInteger time = new AtomicInteger(0);


    /* 同时启动三个线程，过程无阻塞；但CPU利用率不高，空转相对较多，借鉴CAS的思想 */
    @Override
    public void run() {
        while (true){
            if(time.get() >= 30){
                break;
            }
            if(aChar == 65 && maj.getFlag() == aChar){
                print();
                // 直接切换状态，（+1的过程无线程安全问题，后面的set赋值是原子性的）
                maj.setFlag(aChar + 1);
            }
            if(aChar == 66 && maj.getFlag() == aChar){
                print();
                maj.setFlag(aChar + 1);
            }
            if(aChar == 67 && maj.getFlag() == aChar){
                print();
                maj.setFlag(aChar - 2);
            }
        }
    }

    void print(){
        System.out.println(aChar);
        time.getAndIncrement();
    }
}