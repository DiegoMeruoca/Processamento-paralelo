package com.example.AulasPraticas.aula2.exercicio2;

import java.util.Random;

//Esta classe terá as instruções que a thread irá executar
public class ThreadA2E2 extends Thread{

  int qtdRodadas, indice;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadA2E2(int qtd, int indice) {
    this.qtdRodadas = qtd;
    this.indice = indice;
  }

  public void run() {
    Random num = new Random();
    //Popular o vetor
    for(int i = 0; i < qtdRodadas; i++) {
      int jogada = num.nextInt(3);
      if(jogada == 0){
        MainA2Ex2.jogadas[indice][i] = "Pedra";
      }else if(jogada == 1){
        MainA2Ex2.jogadas[indice][i] = "Papel";
      }else{
        MainA2Ex2.jogadas[indice][i] = "Tesoura";
      }
    }
  }

}
