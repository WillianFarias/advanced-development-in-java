package programacaoassincrona;

public class ThreadExemplo {
  public static void main(String[] args) {
    BarraDeCarregamentoDois barraDeCarregamentoDois = new BarraDeCarregamentoDois();

    barraDeCarregamentoDois.start();
  }

}

class GerarPDF {

}

class BarraDeCarregamento implements Runnable {
  @Override
  public void run() {
    System.out.println("Loading...");
  }
}

class BarraDeCarregamentoDois extends Thread {
  @Override
  public void run() {
    super.run();
    System.out.println("rodei " + this.getName());
  }
}
