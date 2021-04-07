package com.example.AulasPraticas.aula2;

import java.util.Random;

class Main {
  //variáveis globais
  public static int vet[]; //declarar um vetor em Java
  public static int tamanho = 10;
  public static int resultado[]; //resultados parciais



  public static void main(String[] args) throws InterruptedException {

    resultado = new int[4]; //reservando espaço em memória para o vetor

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
    ThreadVetor ta = new ThreadVetor(0,tamanho/4,0);//instanciando um obj da classe ThreadVetor
    ThreadVetor tb = new ThreadVetor(tamanho/4,tamanho/2,1);//instanciando um obj da classe ThreadVetor
    ThreadVetor tc = new ThreadVetor(tamanho/2,3*tamanho/4,2);//instanciando um obj da classe ThreadVetor
    ThreadVetor td = new ThreadVetor(3*tamanho/4,tamanho,3);//instanciando um obj da classe ThreadVetor

    ta.start(); //inicia a thread --> colocar a thread para rodar!
    tb.start();
    tc.start();
    td.start();


    //Join: faz a thread Main esperar a thread identificada terminar sua execução
    ta.join();
    tb.join();
    tc.join();
    td.join();




    int somafinal = resultado[0]+resultado[1]+resultado[2]+resultado[3];
    System.out.println("Soma Final (Main) = "+somafinal);


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
