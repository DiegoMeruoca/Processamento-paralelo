package com.example.AulasPraticas.aula3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

//Esta classe terá as instruções que a thread irá executar
public class ThreadSomA3 extends Thread{

  public void run() {
    if(MainA3.cenario == 1){
      URL s = MainA3.class.getResource("src/main/java/com/example/AulasPraticas/aula3/musicas/house_lo.wav");
      AudioClip a = Applet.newAudioClip(s);
      a.play();
    }else if(MainA3.cenario == 2){
      URL s = MainA3.class.getResource("src/main/java/com/example/AulasPraticas/aula3/musicas/musica.wav");
      AudioClip a = Applet.newAudioClip(s);
      a.play();
    }
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
