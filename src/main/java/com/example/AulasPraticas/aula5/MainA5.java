package com.example.AulasPraticas.aula5;

import com.example.AulasPraticas.testandoThreads.ThreadTestes;

import java.util.ArrayList;
import java.util.List;

class MainA5 {
  public static Object objeto;

  public static void main(String[] args) throws InterruptedException {
    objeto = new Object();
    //criando a 1a thread
    ThreadA5 ta = new ThreadA5();//instanciando um obj da classe Thread
    ThreadB5 tbR = new ThreadB5();
    Thread tb = new Thread(tbR);

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();
    Thread.sleep(2000);
    notificador();
    Thread.sleep(2000);
    notificador();
    Thread.sleep(2000);
    notificador();
    Thread.sleep(2000);
    notificador();
    Thread.sleep(2000);
    notificador();
    Thread.sleep(500);
    ta.stop();
    tb.stop();


}

  public static void notificador(){
    synchronized (objeto){
        objeto.notifyAll();
    }

  }
}
