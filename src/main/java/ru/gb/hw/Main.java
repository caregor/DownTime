package ru.gb.hw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatabaseWatchdog.startWatchdog();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait...");
            }
        });

        CreateTable.createTable();
        InsertFakeData.insertData();
        myThread.start();

        System.out.println("Нажмите 'exit', чтобы прервать выполнение программы.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                // Прерывание потока
                myThread.interrupt();
                break;
            } else {
                System.out.println("Неверная команда. Попробуйте снова или введите 'exit'.");
            }

        }
    }
}