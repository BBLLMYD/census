package record.learn.pthread;

import java.util.HashSet;

/**
 * @author mqw
 * @create 2020-08-06-10:53
 */
public class VMain {

    static class Task extends Thread{
        public static long value = 0L;
        @Override
        public void run() {
            while (VMain.flag){
                value++;
            }
            System.err.println("task over");
        }
    }

    static boolean flag = true;

    public static void main(String[] args) {
        new Task().start();
        sleep();
        System.err.println(Task.value);
        // sleep();
        HashSet<Long> ls = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            long value = Task.value;
            ls.add(value);
//            ls.add(Task.value);
        }
        System.out.println(ls);
    }


    static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}