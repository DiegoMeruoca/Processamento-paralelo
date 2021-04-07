package com.example.AulasPraticas.aula2.exercicio1;

//Esta classe terá as instruções que a thread irá executar
public class ThreadE1 extends Thread{

  int posInicial, posFinal, posVetor;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadE1(int inicio, int fim, int indice) {
    posInicial = inicio;
    posFinal = fim;
    posVetor = indice;
  }



  public void run() {

    MainEx1.menorParcial[posVetor] = MainEx1.vet[posInicial];
    MainEx1.maiorParcial[posVetor] = MainEx1.vet[posInicial];
    for(int i = posInicial; i < posFinal; i++) {
      if(MainEx1.menorParcial[posVetor] > MainEx1.vet[i]){
        MainEx1.menorParcial[posVetor] = MainEx1.vet[i];
      }
      if(MainEx1.maiorParcial[posVetor] < MainEx1.vet[i]){
        MainEx1.maiorParcial[posVetor] = MainEx1.vet[i];
      }
    }
  }

}
