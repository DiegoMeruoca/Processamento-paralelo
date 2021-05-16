package com.example.AulasPraticas.aula4.exercicio1;

//Esta classe terá as instruções que a thread irá executar
public class ThreadA4E1 extends Thread{
  int posInicial, posFinal, acertos;
  String letra;
  char palavra[];
  boolean acertou;

  //construtor serve neste caso para receber os parametros (argumentos)
  public ThreadA4E1(int inicio, int fim, char palavra[], String letra) {
    this.posInicial = inicio;
    this.posFinal = fim;
    this.letra = letra;
    this.palavra = palavra;
    this.acertos=0;
    this.acertou = false;
  }



  public void run() {

      for(int i = posInicial; i < posFinal; i++) {
          if(palavra[i]==letra.charAt(0)) {
                acertos+=1;
          }
      }
      if(acertos>0) {
         acertou=true;
      }else{
          acertou=false;
      }

  }


}
