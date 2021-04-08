package com.example.AulasPraticas.aula2;

//Esta classe terá as instruções que a thread irá executar
public class ThreadVetorA2 extends Thread{

  int posInicial, posFinal, posVetor;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadVetorA2(int inicio, int fim, int indice) {
    posInicial = inicio;
    posFinal = fim;
    posVetor = indice;
  }



  public void run() {

    int soma = 0;
    for(int i = posInicial; i < posFinal; i++) {
      MainA2.resultado[posVetor] = MainA2.resultado[posVetor] + MainA2.vet[i];
    }
    System.out.println();
    System.out.println("Soma calculada pela "+this.getName()+" "+ MainA2.resultado[posVetor]);
  }

}
