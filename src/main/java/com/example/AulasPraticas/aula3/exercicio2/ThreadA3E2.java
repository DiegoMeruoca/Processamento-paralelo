package com.example.AulasPraticas.aula3.exercicio2;

import java.util.Random;

//Esta classe terá as instruções que a thread irá executar
public class ThreadA3E2 extends Thread{

  int qtdRodadas, indice;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadA3E2(int qtd, int indice) {
    this.qtdRodadas = qtd;
    this.indice = indice;
  }

  public void run() {
    Random num = new Random();
    //Popular o vetor
    for(int i = 0; i < qtdRodadas; i++) {
      int jogada = num.nextInt(6);
      MainA3Ex2.jogadas[indice][i] = jogada;
    }
  }

}
