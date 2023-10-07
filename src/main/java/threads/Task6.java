package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task6 {
    private static List<Integer> list = new ArrayList<>();
    private static Object lock = new Object();
    private static boolean isOdd = false;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел :");
        int count = scanner.nextInt();

        Thread producerThread = new Thread(()->{
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                synchronized (lock){
                    int num = random.nextInt(100);
                    list.add(num);
                    System.out.println("Добавлено число: " + num);
                    isOdd = num % 2 != 0;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread consumerThread = new Thread(()->{
            for (int i = 0; i < count; i++) {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    int num = list.get(i);
                    System.out.println("Прочитано число: " + num);
                    System.out.println("Число " + num + " - " + (isOdd ? "нечетное" : "четное"));
                    lock.notify();
                }
            }
        });

        Thread averageThread = new Thread(()->{
            double sum = 0;
            for (int i = 0; i < count; i++) {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    int num = list.get(i);
                    sum += num;
                    double average = sum/list.size();
                    System.out.println("Среднее число в масстве : " + average);
                    lock.notify();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
        averageThread.start();
        try {
            producerThread.join();
            consumerThread.join();
            averageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}

