package com.example.AulasPraticas.aula4.exercicio1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MainA4Ex1 {
  //variáveis globais
  public static String vetPalavras[];
  public static String palavra;
  public static String letra;
  public static String alfabeto;
  public static char vetletras[];
  public static char vetAlfabeto[];
  public static char vetLetrasUsadas[];
  public static char vetLetrasCertas[];
  public static int op;
  public static int vida;
  public static int pontos; //resultados parciais



  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);

    pontos = 0;

    vida = 6;

    alfabeto = "ABCDEFGHIJKLMNOPQRSTUVXYWZ";
    vetAlfabeto = new char[26];
    vetLetrasUsadas = new char[26];
    int i =0;
    for(char c : alfabeto.toCharArray()){
      vetAlfabeto[i] = c;
      i+=1;
    }
    vetPalavras = new String[5];
    vetPalavras[0] = "JavaScript";
    vetPalavras[1] = "Bootstrap";
    vetPalavras[2] = "jQuery";
    vetPalavras[3] = "Python";
    vetPalavras[4] = "Pascal";

    Random num = new Random();
    op = num.nextInt(5);
    palavra = vetPalavras[op].toUpperCase();

    vetLetrasCertas = new char[palavra.length()];


    vetletras = new char[palavra.length()];
    i=0;
    for(char c : palavra.toCharArray()){
      vetletras[i] = c;
      i+=1;
    }
    vetLetrasUsadas = povoarTracos(vetLetrasUsadas);
    vetLetrasCertas = povoarTracos(vetLetrasCertas);

    int cont=0;
    while(true) {
      cont+=1;
      System.out.println("\n\n\n\n");
      System.out.println("==================================================================================================");
      System.out.println("                                            Tentativa " + cont);
      System.out.println("Letras utilizadas: " + Arrays.toString(vetLetrasUsadas));
      System.out.println("Qtd Letras:" + palavra.length());
      System.out.println("Palavra:" + Arrays.toString(vetLetrasCertas));
      System.out.println("Pontos = " + pontos);
      System.out.println("Vidas = " + vida);
      System.out.println("Digite uma letra: ");
      letra = sc.next().toUpperCase();
      adicionarLetras(letra);
      //criando a 1a thread
      ThreadA4E1 ta = new ThreadA4E1(0, palavra.length() / 2, vetletras, letra);//instanciando um obj da classe ThreadVetor
      ThreadA4E1 tb = new ThreadA4E1(palavra.length() / 2, palavra.length(), vetletras, letra);//instanciando um obj da classe ThreadVetor

      ta.start(); //inicia a thread --> colocar a thread para rodar!
      tb.start();

      //Join: faz a thread Main esperar a thread identificada terminar sua execução
      ta.join();
      tb.join();
      if (ta.acertou || tb.acertou) {
        pontos += ta.acertos + tb.acertos;
        System.out.println("Acertou!!!");
        marcarLetraCerta(letra);
        Thread.sleep(1500);
      } else {
        System.out.println("Errou!!!");
        vida -= 1;
        Thread.sleep(1500);
      }

      if (vida <= 0){
        System.out.println("==================================================================================================");
        System.out.println("                                             Derrota!!!");
        System.out.println("==================================================================================================");
        break;
      }
      if(pontos>=palavra.length()){
        System.out.println("==================================================================================================");
        System.out.println("                                             Vitoria!!!");
        System.out.println("==================================================================================================");
        break;
      }
    }
  }

  private static void marcarLetraCerta(String letra) {
      for(int i=0; i<vetletras.length; i++){
          if(vetletras[i]==letra.charAt(0)){
            vetLetrasCertas[i]=letra.charAt(0);
          }
      }
  }

  private static void adicionarLetras(String letra){
      for(int i=0; i<vetAlfabeto.length; i++){
          if(vetAlfabeto[i]==letra.charAt(0)){
            vetLetrasUsadas[i]=letra.charAt(0);
          }
      }
  }

  private static char[] povoarTracos(char[] vetor){
    for(int i=0; i<vetor.length; i++){
        vetor[i]='_';
    }
    return vetor;
  }

}
