package com.example.AulasPraticas.aula2.exercicio1;

//Esta classe terá as instruções que a thread irá executar
public class ThreadA2E1 extends Thread{

  int posInicial, posFinal, posVetor;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadA2E1(int inicio, int fim, int indice) {
    posInicial = inicio;
    posFinal = fim;
    posVetor = indice;
  }



  public void run() {

    MainA2Ex1.menorParcial[posVetor] = MainA2Ex1.vet[posInicial];
    MainA2Ex1.maiorParcial[posVetor] = MainA2Ex1.vet[posInicial];
    for(int i = posInicial; i < posFinal; i++) {
      if(MainA2Ex1.menorParcial[posVetor] > MainA2Ex1.vet[i]){
        MainA2Ex1.menorParcial[posVetor] = MainA2Ex1.vet[i];
      }
      if(MainA2Ex1.maiorParcial[posVetor] < MainA2Ex1.vet[i]){
        MainA2Ex1.maiorParcial[posVetor] = MainA2Ex1.vet[i];
      }
    }
  }

}
