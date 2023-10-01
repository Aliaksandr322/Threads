package threads;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args){
        Resource resource = new Resource();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                resource.add(Thread.currentThread());
                System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                Thread ChildA = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        resource.add(Thread.currentThread());
                        System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                    }
                }, "Child A");
                ChildA.start();
                try {
                    ChildA.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "Thread A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                resource.add(Thread.currentThread());
                System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                Thread ChildB = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        resource.add(Thread.currentThread());
                        System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                    }
                }, "Child B");
                ChildB.start();
                try {
                    ChildB.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread B");
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                resource.add(Thread.currentThread());
                System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                Thread ChildC = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        resource.add(Thread.currentThread());
                        System.out.println("Thread " + Thread.currentThread().getName() + " is starting");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is performed");
                        System.out.println("Thread " + Thread.currentThread().getName() + " is ending");
                    }
                }, "Child C");
                ChildC.start();
                try {
                    ChildC.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread C");
        A.start();
        B.start();
        C.start();
        try {
            A.join();
            B.join();
            C.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(resource.getThreads().toString());
    }
}

@Data
class Resource {
    private List<String> threads = new ArrayList<>();
    public synchronized void add(Thread thread){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threads.add(thread.getName());
    }
}