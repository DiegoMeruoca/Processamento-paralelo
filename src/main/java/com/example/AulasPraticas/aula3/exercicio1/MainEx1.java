package com.example.AulasPraticas.aula3.exercicio1;

import java.util.Random;

class MainEx1 {
  //variáveis globais
  public static int qtdRodadas = 3;
  public static int jogadas[][];

  public static void main(String[] args) throws InterruptedException {
    jogadas = new int[2][qtdRodadas];
    int escolhaA, escolhaB, totPontosA = 0, totPontosB = 0;

    //criando a 1a thread
    ThreadE1 ta = new ThreadE1(qtdRodadas, 0);//instanciando um obj da classe ThreadVetor
    ThreadE1 tb = new ThreadE1(qtdRodadas, 1);//instanciando um obj da classe ThreadVetor

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();

    //Join: faz a thread Main esperar a thread identificada terminar sua execução
    ta.join();
    tb.join();

    //Definindo quem é par e quem é impar
    Random num = new Random();
    int escolha = num.nextInt(2);
    if(escolha == 0){
      escolhaA = 0; //A é par
      escolhaB = 1; //B é impar
    }else{
      escolhaA = 1; //A é ímpar
      escolhaB = 0; //B é par
    }
    System.out.println("============Definições=============");
    System.out.println("ThreadA "+testaParImpar(escolhaA)+" vs "+testaParImpar(escolhaB)+" ThreadB");

    //Exibindo resultados
    for(int i = 0; i < qtdRodadas; i++){
      int jogadaA = jogadas[0][i];
      int jogadaB = jogadas[1][i];
      int resultado = jogadaA + jogadaB;
      System.out.println("==============Rodada"+(i+1)+"==============");
      System.out.println("ThreadA "+jogadaA+" vs "+jogadaB+" ThreadB");
      System.out.println("Resultado: "+ resultado + " - " + testaParImpar(resultado));
      if(resultado%2 == escolhaA  ){
        System.out.println("Vencedor da rodada: Thread A!!!!");
        totPontosA+=1;
      }else {
        System.out.println("Vencedor da rodada: Thread B!!!!");
        totPontosB+=1;
      }
    }
    //Veredito final
    System.out.println("==========Pontuação Final==========");
    System.out.println("ThreadA "+totPontosA+" vs "+totPontosB+" ThreadB");
    if(totPontosA > totPontosB  ){
      System.out.println("Vitoria da Thread A!!!!");
    }else {
      System.out.println("Vitoria da Thread B!!!!");
    }
  }

  public static String testaParImpar(int num){
    if(num%2==0){
      return "Par";
    }
    return "Ímpar";
  }

}
