package com.example.AulasPraticas.aula3.exercicio2;

import java.util.Scanner;

//Esta classe terá as instruções que a thread irá executar
public class ThreadInputE2 extends Thread{

  int qtdRodadas, indice;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadInputE2(int qtd, int indice) {
    this.qtdRodadas = qtd;
    this.indice = indice;
  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    //Popular o vetor
    for(int i = 0; i < qtdRodadas; i++) {
      System.out.println("Digite um numero de 0 a 5 para a rodada "+(i+1));
      int jogada = sc.nextInt();
      MainEx2.jogadas[indice][i] = jogada;
    }
  }

}
