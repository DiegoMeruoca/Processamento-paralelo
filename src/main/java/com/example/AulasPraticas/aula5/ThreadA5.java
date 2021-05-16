package com.example.AulasPraticas.aula5;

//Esta classe terá as instruções que a thread irá executar
public class ThreadA5 extends Thread{

  public int cont;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadA5() {
    System.out.println("A - Trhead iniciada");
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
    System.out.println("A - Me chamou?"+cont);
    cont += 1;
  }

}
