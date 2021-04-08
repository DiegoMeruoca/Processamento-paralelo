package com.example.AulasPraticas.testandoThreads;

//Esta classe terá as instruções que a thread irá executar
public class ThreadTestes extends Thread{

  public String status;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadTestes(String staus) {
      this.status = staus;
  }

  public void run() {
    for(int i = 1; i <= 10; i++){
      System.out.println("Meu status é "+status);
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}
