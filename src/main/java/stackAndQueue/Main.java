package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            firstQueue.add((int)(Math.random()*10));
            secondQueue.add((int)(Math.random()*10));
        }
        System.out.println(firstQueue);
        System.out.println(secondQueue);
        int i = 0;
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty() && (i != 1000 * 1000)){
            int c1 = firstQueue.poll();
            int c2 = secondQueue.poll();
            if (c1 > c2 && !(c2 == 0 && c1==9) || (c1 == 0 && c2 == 9)){
                firstQueue.offer(c1);
                firstQueue.offer(c2);
            }else {
                secondQueue.offer(c1);
                secondQueue.offer(c2);
            }
            i++;
        }
        if (firstQueue.isEmpty()) System.out.println("Second " + i);
        else if (secondQueue.isEmpty()) System.out.println("First " + i);
        else System.out.println("botva");

    }




}
