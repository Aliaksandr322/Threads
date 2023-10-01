package threads;

import static java.lang.Thread.sleep;

public class Tasks12 {
    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new A());
        A.setName("A");
        Thread B = new Thread(new B());
        B.setName("B");
        Thread C = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " starts");
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                    sleep(1000);
                    Thread chC = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Thread " + Thread.currentThread().getName() + " starts");
                            try {
                                System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                                sleep(100);

                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Thread " + Thread.currentThread().getName() + " ends");
                        }
                    });
                    chC.setName("ChildC");
                    chC.start();
                    try {
                        chC.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " ends");
            }
        });
        C.setName("C");
        A.start();

        B.start();

        C.start();



    }
}

class A extends Thread {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " starts");
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
            sleep(100);
            Thread chA = new Thread(new ChildA());
            chA.setName("ChildA");
            chA.start();
            try {
                chA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");
    }
}
class ChildA extends A{
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " starts");
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");
    }
}

class B implements Runnable{
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " starts");
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
            sleep(500);
            Thread chB = new Thread(new ChildB());
            chB.setName("ChildB");
            chB.start();
            try {
                chB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");
    }
}
class ChildB extends B{
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " starts");
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
            sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ends");
    }
}