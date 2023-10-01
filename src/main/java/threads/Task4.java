package threads;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class Task4 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t5 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t6 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };
        Thread t7 = new Thread() {
            @Override
            public void run() {
                String text = readFileByLines("warAndPiece");
                System.out.println(text);
                StringBuffer sb = new StringBuffer(text);
                String reversText = sb.reverse().toString();
                LocalDate currentDate = LocalDate.now();
                String fileName = String.format("%s_%s", Thread.currentThread().getName(),currentDate);
                write(reversText, String.format("result\\%s",fileName),false);
            }
        };

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
