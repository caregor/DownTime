package ru.gb.hw;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CreateTable.createTable();
        InsertFakeData.insertData();
        DatabaseWatchdog.startWatchdog();
    }
}