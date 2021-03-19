package programacaoassincrona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExemplo {

  private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);
  public static void main(String[] args) {
    Casa casa = new Casa(new Quarto());
    casa .obterAfarezesDaCasa().forEach - threadPool.execute(() -> atividade.realizar());
    threadPool.shutdown();
  }
}

class Casa {
  private List<Comodo> comodos;

  Casa(Comodo... comodos) {
    this.comodos = Arrays.asList(comodos);
  }

  List<Atividade> obterAfazeresDeCasa() {
    return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
      .reduce(new ArrayList<Atividade>(), (pivo, atividade) -> {
        pivo.addAll(atividade);
        return pivo;
      });
  }
}

interface Atividade {
  void realizar();
}

abstract class Comodo {
  abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {

  @Override
  List<Atividade> obterAfazeresDoComodo() {
    return Arrays.asList(
      this::arrumarGuardaRoupa,
      this::varerQuarto,
      this::arrumarCama
    );
  }

  private void arrumarGuardaRoupa() {System.out.println("Arrumar o guarda roupa");}

  private void varerQuarto() {System.out.println("Varer o quarto");}

  private void arrumarCama() {System.out.println("Arrumar a cama");}

}
