package programacaoassincrona;

public class ThreadExemplo {
  public static void main(String[] args) {
    
  }


  public class GerarPDF {
  
  }

  public class BarraDeCarregamento implements Runnable{
    @Override
    public void run() {
      System.out.println("Loading...");
    }
  }

  public class BarraDeCarregamentoDois extends Thread {
    @Override
    public void run() {
      super.run();
      System.out.println("rodei" + this.getName());
    }
    
  }
}


