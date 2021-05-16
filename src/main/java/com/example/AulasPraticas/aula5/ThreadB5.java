package com.example.AulasPraticas.aula5;

public class ThreadB5 implements Runnable{
  public int cont;
  public ThreadB5() {
    System.out.println("B -Trhead iniciada");
    cont = 0;
  }

  public void run() {
    while (true){
      update();
      synchronized (MainA5.objeto){
        try {
          MainA5.objeto.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  }

  private void update() {
    System.out.println("B - Me chamou?"+cont);
    cont += 1;
  }
}
