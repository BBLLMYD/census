package record.learn.pthread.p4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
@Data
class MajusculeABC {

    /* 标志位 初始值为65保证从A开始 */
    private static volatile int flag = 65;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public int getFlag(){
        return flag;
    }
    public void setFlag(int flag){
        this.flag = flag;
    }
}

/**
 * 有锁实现
 */
@AllArgsConstructor
class ThreadABC implements Runnable {

    MajusculeABC maj;
    char aChar;

    final static AtomicInteger time = new AtomicInteger(0);

    @Override
    public void run() {
        while (true){
            try {
                maj.getLock().lock();
                if(time.get()>=30){
                    break;
                }
                if(maj.getFlag() == 65 && aChar == 65){
                    print();
                    // 设置到B线程能运行的状态
                    maj.setFlag(66);
                    // 唤醒B线程
                    maj.getConditionB().signal();
                }else if(aChar == 65){
                    maj.getConditionA().await();
                }

                if(maj.getFlag() == 66 && aChar == 66){
                    print();
                    // 设置到C线程能运行的状态
                    maj.setFlag(67);
                    // 唤醒C线程
                    maj.getConditionC().signal();
                }else if(aChar == 66){
                    maj.getConditionB().await();
                }

                if(maj.getFlag() == 67 && aChar == 67){
                    print();
                    // 同理
                    maj.setFlag(65);
                    maj.getConditionA().signal();
                }else if(aChar == 67){
                    maj.getConditionC().await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                maj.getLock().unlock();
            }
        }
    }

    void print(){
        System.out.println(aChar);
        time.getAndIncrement();
    }
}