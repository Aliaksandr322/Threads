package threads;

import static java.lang.Thread.sleep;

public class Task7 {

    private static boolean dishIsReady = false;
    private static Object lock = new Object();
    // Я не понимаю почему у меня не запускается сдесь 3 поток

    public static void main(String[] args) {

        Thread clientThread = new Thread(()->{
            synchronized (lock){
                System.out.println("Оформление заказа");
                System.out.println("Заказ оформлен");
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread waiterThread = new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Поднос заказа");
                lock.notify();
            }
        });
        //TODO
        Thread cookThread = new Thread(()->{
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Повар готовит заказ");
                System.out.println("Повар пригтовил заказ");
                lock.notify();
            }
        });

        clientThread.start();
        waiterThread.start();
        cookThread.start();

        try {
            clientThread.join();
            waiterThread.join();
            cookThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
