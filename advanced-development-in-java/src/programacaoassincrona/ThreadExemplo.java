package programacaoassincrona;

import java.util.Arrays;
import java.util.List;

public class ThreadExemplo {
  public static void main(String[] args) {
    GerarPDF gerarPDF = new GerarPDF();
    BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(gerarPDF);

    gerarPDF.start();
    barraDeCarregamento.start();
  }

}

class GerarPDF extends Thread {


  
}

// class BarraDeCarregamento implements Runnable {
class BarraDeCarregamento extends Thread {

  public void teste(){
    System.out.println("aqui");
  }

  private Thread iniciarGeradorPDF;

  public BarraDeCarregamento(Thread iniciarGeradorPDF) {
    this.iniciarGeradorPDF = iniciarGeradorPDF;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(500);

      while (true) {
        if (!iniciarGeradorPDF.isAlive()) {
          break;
        }
        System.out.println("Loading...");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// class BarraDeCarregamentoDois implements Runnable {
/*
 * class BarraDeCarregamentoDois extends Thread {
 * 
 * @Override public void run() { try { Thread.sleep(1000);
 * System.out.println("Rodei o barramento"); } catch (InterruptedException e) {
 * e.printStackTrace(); } } }
 */

/*
 * class BarraDeCarregamentoDois extends Thread {
 * 
 * @Override public void run() { super.run(); try { Thread.sleep(5000);
 * System.out.println("rodei " + this.getName()); } catch (InterruptedException
 * e) { e.printStackTrace(); } } }
 */
