package com.example.AulasPraticas.aula2.exercicio2;

import java.util.Random;

class MainEx2 {
  //variáveis globais
  public static int qtdRodadas = 10;
  public static String jogadas[][];

  public static void main(String[] args) throws InterruptedException {
    jogadas = new String[2][qtdRodadas];

    //criando a 1a thread
    ThreadE2 ta = new ThreadE2(qtdRodadas, 0);//instanciando um obj da classe ThreadVetor
    ThreadE2 tb = new ThreadE2(qtdRodadas, 1);//instanciando um obj da classe ThreadVetor

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();

    //Join: faz a thread Main esperar a thread identificada terminar sua execução
    ta.join();
    tb.join();

  for(int i = 0; i < qtdRodadas; i++){
    String jogadaA = jogadas[0][i];
    String jogadaB = jogadas[1][i];
    System.out.println("================Rodada"+i+"================");
    System.out.println("ThreadA "+jogadaA+" vs "+jogadaB+" ThreadB");
    if(jogadaA == "Pedra" && jogadaB == "Papel" || jogadaA == "Tesoura" && jogadaB == "Pedra" || jogadaA == "Papel" && jogadaB == "Tesoura" ){
      System.out.println("Vitoria da Thread B!!!!");
    }else if(jogadaB == "Pedra" && jogadaA == "Papel" || jogadaB == "Tesoura" && jogadaA == "Pedra" || jogadaB == "Papel" && jogadaA == "Tesoura") {
      System.out.println("Vitoria da Thread A!!!!");
    }else {
      System.out.println("Rodada empatada!!!!");
    }
  }

    /*menor =menorParcial[0];
    for(int i = 0; i < menorParcial.length; i++){
      if(menor > menorParcial[i]){
        menor = menorParcial[i];
      }
    }
    System.out.println("Menor valor (Main) = "+menor);*/





    //Sequencial para somar os elementos do vetor
		/*
		int soma = 0;
		for(int i = 0; i < tamanho; i++) {
			soma = soma + vet[i];
		}

		System.out.println();
		System.out.println("Soma = "+soma);
		*/





		/*

		ThreadVetor ta = new ThreadVetor();//instanciando um obj da classe ThreadVetor

		ta.start(); //inicia a thread --> colocar a thread para rodar!
		*/
  }

}
