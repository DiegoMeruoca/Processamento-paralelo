package com.example.AulasPraticas.aula4;

public class MainA4 {
    public static void main(String[] args) throws InterruptedException {
        //Chama a Thread filha com lambda
        new Thread(() -> {
            for(int i = 1; i <= 5; i++){
                System.out.println("Thread Filha: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //Codigo mais
        for(int j = 1; j <= 5; j++){
            System.out.println("Thread Main: " + j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
