package com.example.AulasPraticas.aula2.exercicio1;

import java.util.Random;

class MainA2Ex1 {
  //variáveis globais
  public static int vet[]; //declarar um vetor em Java
  public static int tamanho = 10;
  public static int menorParcial[];//O menor de cada thread
  public static int menor;
  public static int maiorParcial[];//O menor de cada thread
  public static int maior;



  public static void main(String[] args) throws InterruptedException {
    menorParcial = new int[4];
    maiorParcial = new int[4];
    menor = 0;
    maior = 0;
    vet = new int[tamanho]; //reservando espaço em memória para o vetor


    Random num = new Random();

    //Popular o vetor
    for(int i = 0; i < tamanho; i++) {
      vet[i] = num.nextInt(100);
    }


    //imprimir o vetor

    System.out.print("[");
    for(int i = 0; i < tamanho; i++) {
      if (i != tamanho-1)
        System.out.print(vet[i]+" | ");
      else
        System.out.print(vet[i]+"]");
    }


    //criando a 1a thread
    ThreadA2E1 ta = new ThreadA2E1(0,tamanho/4,0);//instanciando um obj da classe ThreadVetor
    ThreadA2E1 tb = new ThreadA2E1(tamanho/4,tamanho/2,1);//instanciando um obj da classe ThreadVetor
    ThreadA2E1 tc = new ThreadA2E1(tamanho/2,3*tamanho/4,2);//instanciando um obj da classe ThreadVetor
    ThreadA2E1 td = new ThreadA2E1(3*tamanho/4,tamanho,3);//instanciando um obj da classe ThreadVetor

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();
    tc.start();
    td.start();


    //Join: faz a thread Main esperar a thread identificada terminar sua execução
    ta.join();
    tb.join();
    tc.join();
    td.join();
    System.out.println("\n");
    menor =menorParcial[0];
    for(int i = 0; i < menorParcial.length; i++){
      if(menor > menorParcial[i]){
        menor = menorParcial[i];
      }
    }
    System.out.println("Menor valor (Main) = "+menor);

    maior =maiorParcial[0];
    for(int i = 0; i < maiorParcial.length; i++){
      if(maior < maiorParcial[i]){
        maior = maiorParcial[i];
      }
    }
    System.out.println("Maior valor (Main) = "+maior);




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
