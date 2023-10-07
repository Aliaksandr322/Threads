package threads;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class Task4 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t5 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t6 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        Thread t7 = new Thread() {
            @Override
            public void run() {
                runThread();
            }
        };
        DaemonTread daemon = new DaemonTread();
        daemon.start();
        t1.setName("ThreadNum1");
        t2.setName("ThreadNum2");
        t3.setName("ThreadNum3");
        t4.setName("ThreadNum4");
        t5.setName("ThreadNum5");
        t6.setName("ThreadNum6");
        t7.setName("ThreadNum7");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    public static void runThread(){
        String text = readFileByLines("warAndPiece");
        StringBuffer sb = new StringBuffer(text);
        String reversText = sb.reverse().toString();
        LocalDate currentDate = LocalDate.now();
        String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
        write(reversText, String.format("result\\%s",fileName),false);
    }
    public synchronized static String readFileByLines(String path){
        StringBuilder sb = new StringBuilder(214748364);
        try (BufferedReader reader = new BufferedReader(new FileReader(path), 214748364)){
            // используем try with resources . See AutoClosable так как reader AutoClosable он будет закрывать stream
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check your file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public synchronized static void write(String data, String path, boolean append){
        try (Writer writer = new BufferedWriter(new FileWriter(path , append))){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DaemonTread extends Thread{
    public DaemonTread() {
        this.setDaemon(true);
    }
    @Override
    public void run(){
        File folder = new File("result");
        int threadsCounter = 7;
        while (true){
            if (folder.length() == 0){
                System.out.println(threadsCounter + " потоков в работе");
            }
            else {
                File[] array = folder.listFiles();
                System.out.println( (threadsCounter - array.length)+ " потоков в работе");
            }

        }
    }

}
