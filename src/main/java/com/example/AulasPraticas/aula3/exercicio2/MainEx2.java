package com.example.AulasPraticas.aula3.exercicio2;

import java.util.Scanner;

class MainEx2 {
  //variáveis globais
  public static int qtdRodadas = 3;
  public static int jogadas[][];

  public static void main(String[] args) throws InterruptedException {
    jogadas = new int[2][qtdRodadas];
    int escolhaA, escolhaB, totPontosA = 0, totPontosB = 0;
    Scanner sc = new Scanner(System.in);

    //Definindo quem é par e quem é impar
    System.out.println("============Par ou Ímpar=============");
    System.out.println("Escolha agora! Você prefere par ou ímpar: ");
    System.out.println("Digite 0 para par ou 1 para ímpar: ");
    int escolha = sc.nextInt();
    if(escolha == 0){
      escolhaA = 1; //Computador ímpar
      escolhaB = 0; //player par
    }else{
      escolhaA = 0; //Computador par
      escolhaB = 1; //Player ímpar
    }

    //criando a 1a thread
    ThreadE2 ta = new ThreadE2(qtdRodadas, 0);//instanciando um obj da classe ThreadVetor
    ThreadInputE2 tb = new ThreadInputE2(qtdRodadas, 1);//instanciando um obj da classe ThreadVetor

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();

    //Join: faz a thread Main esperar a thread identificada terminar sua execução
    ta.join();
    tb.join();


    System.out.println("============Definições=============");
    System.out.println("Computador "+testaParImpar(escolhaA)+" vs "+testaParImpar(escolhaB)+" Player");

    //Exibindo resultados
    for(int i = 0; i < qtdRodadas; i++){
      int jogadaA = jogadas[0][i];
      int jogadaB = jogadas[1][i];
      int resultado = jogadaA + jogadaB;
      System.out.println("==============Rodada"+(i+1)+"==============");
      System.out.println("Computador "+jogadaA+" vs "+jogadaB+" Player");
      System.out.println("Resultado: "+ resultado + " - " + testaParImpar(resultado));
      if(resultado%2 == escolhaA  ){
        System.out.println("Vencedor da rodada: Computador!!!!");
        totPontosA+=1;
      }else {
        System.out.println("Vencedor da rodada: Player!!!!");
        totPontosB+=1;
      }
    }
    //Veredito final
    System.out.println("==========Pontuação Final==========");
    System.out.println("Computador "+totPontosA+" vs "+totPontosB+" Player");
    if(totPontosA > totPontosB  ){
      System.out.println("Vitoria da Computador!!!!");
    }else {
      System.out.println("Vitoria do Player!!!!");
    }
  }

  public static String testaParImpar(int num){
    if(num%2==0){
      return "Par";
    }
    return "Ímpar";
  }

}
