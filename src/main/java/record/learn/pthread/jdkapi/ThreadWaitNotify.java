package record.learn.pthread.jdkapi;

public class ThreadWaitNotify {

    private static final Object syncObj = new Object();

    static class WaitThread extends Thread { 
        @Override
        public void run() {
            System.out.println("wait begin enter synchronized");
            synchronized(syncObj) {
                try {
                    System.out.println("wait start");
                    syncObj.wait();
                    System.out.println("wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NotifyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify begin enter synchronized");
            synchronized(syncObj) {
                System.out.println("notify start");
                syncObj.notifyAll();
                System.out.println("notify end");
            }
        }
    }

    static class SWaitThread extends Thread { 
        @Override
        public void run() {
            System.out.println("Swait begin enter synchronized");
            synchronized(syncObj) {
                try {
                    System.out.println("Swait start");
                    //syncObj.wait();
                    Thread.sleep(3000);
                    System.out.println("Swait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SNotifyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Snotify begin enter synchronized");
            synchronized(syncObj) {
                System.out.println("Snotify start");
//              syncObj.notifyAll();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Snotify end");
            }
        }
    }


    public static void main(String[] args) {
        new WaitThread().start();
        new NotifyThread().start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============");

        new SWaitThread().start();
        new SNotifyThread().start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============");

        new WaitThread().start();
        new WaitThread().start();
    }   
}