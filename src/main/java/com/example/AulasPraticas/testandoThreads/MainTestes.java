package com.example.AulasPraticas.testandoThreads;

import java.util.Random;

class MainTestes {
  //variáveis globais

  public static void main(String[] args) throws InterruptedException {

    //criando a 1a thread
    ThreadTestes ta = new ThreadTestes("Andando");//instanciando um obj da classe Thread

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    Thread.sleep(400);
    ta.status = "Correndo";
    Thread.sleep(400);
    ta.status = "Pulando";
    Thread.sleep(400);
    ta.status = "Andando";
    Thread.sleep(400);
    ta.status = "Chutando";
    Thread.sleep(400);
    ta.status = "Socando";
    ta.join();//Join: faz a thread Main esperar a thread identificada terminar sua execução
  }
}
